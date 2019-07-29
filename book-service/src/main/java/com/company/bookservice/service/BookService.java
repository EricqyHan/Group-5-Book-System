package com.company.bookservice.service;

import com.company.bookservice.dao.BookDao;
import com.company.bookservice.model.Book;
import com.company.bookservice.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// Updated bookService
@Component
public class BookService {

    BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookViewModel saveBook(BookViewModel bookViewModel) {
        Book book = new Book();
        book.setTitle("The Alchemist");
        book.setAuthor("Paulo Coelho");
        book = bookDao.addBook(book);

        bookViewModel.setId(book.getBookId());
        return bookViewModel;
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

        for (Book book: bookList) {
            BookViewModel bookVM = buildBookViewModel(book);
            bookVMList.add(bookVM);
        }
        return bookVMList;
    }

    @Transactional
    public void updateBook(BookViewModel bookViewModel) {
        Book book = new Book();
        book.setBookId(bookViewModel.getId());
        book.setTitle(bookViewModel.getTitle());
        book.setAuthor(bookViewModel.getAuthor());

        bookDao.updateBook(book);
    }

    public void removeBook(int id) {
        bookDao.deleteBook(id);
    }

    private BookViewModel buildBookViewModel(Book book) {
        BookViewModel bookViewModel = new BookViewModel();
        bookViewModel.setId(book.getBookId());
        bookViewModel.setTitle(book.getTitle());
        bookViewModel.setAuthor(book.getAuthor());
        return bookViewModel;
    }
}






