package com.company.bookservice.service;

import com.company.bookservice.dao.BookDao;
import com.company.bookservice.model.Book;
import com.company.bookservice.model.Note;
import com.company.bookservice.viewmodel.BookViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    public static final String EXCHANGE = "note-exchange";
    public static final String QUEUE_NAME = "note.list.add-queue";
    public static final String ROUTING_KEY = "note.list.add.#";

    private BookDao bookDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    public BookViewModel findBookById(int id) {
        Book book = bookDao.getBook(id);
        if (book == null) {
            return null;
        } else {
            return buildBookViewModel(book);
        }
    }

    public List<BookViewModel> findAllBooks() {
        List<Book> bookList = bookDao.getAllBooks();

        List<BookViewModel> bookVMList = new ArrayList<>();

        for (Book book : bookList) {
            BookViewModel bookVM = buildBookViewModel(book);
            bookVMList.add(bookVM);
        }
        return bookVMList;
    }

    @Transactional
    public BookViewModel addBook(BookViewModel bookViewModel) {

        Book book = new Book();
        book.setTitle(bookViewModel.getTitle());
        book.setAuthor(bookViewModel.getAuthor());
        book = bookDao.addBook(book);
        if (bookViewModel.getNotes() != null){
            for (Note note: bookViewModel.getNotes()){
                // Add each note to the queue
                note.setBookId(book.getBookId());
                System.out.println("Sending message...");
                rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, note);
                System.out.println("Message Sent");
            }
        }

        bookViewModel.setBookId(book.getBookId());
        return bookViewModel;
    }

    public void removeBook(int id) {
        bookDao.deleteBook(id);
    }

    public void updateBook(BookViewModel bookViewModel) {

        Book book = new Book();
        book.setBookId(bookViewModel.getBookId());
        book.setTitle(bookViewModel.getTitle());
        book.setAuthor(bookViewModel.getAuthor());
        bookDao.updateBook(book);

        if (bookViewModel.getNotes() != null){
            for (Note note: bookViewModel.getNotes()){
                // Add each note to the queue
                note.setBookId(book.getBookId());
                System.out.println("Sending message...");
                rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, note);
                System.out.println("Message Sent");
            }
        }
    }

    private BookViewModel buildBookViewModel(Book book) {
        BookViewModel bookViewModel = new BookViewModel();
        bookViewModel.setBookId(book.getBookId());
        bookViewModel.setTitle(book.getTitle());
        bookViewModel.setAuthor(book.getAuthor());
        return bookViewModel;

    }
}
