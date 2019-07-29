package com.company.bookservice.service;

import com.company.bookservice.dao.BookDao;
import com.company.bookservice.dao.BookDaoJdbcTemplateImpl;
import com.company.bookservice.model.Book;
import com.company.bookservice.viewmodel.BookViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BookServiceTest {
    BookDao bookDao;
    BookService bookService;

    @Before
    public void setUp() throws Exception {
        setUpBookDaoMock();
        bookService = new BookService(bookDao);
    }

    private void setUpBookDaoMock() {
        bookDao = mock(BookDaoJdbcTemplateImpl.class);

        Book book = new Book();
        book.setBookId(1);
        book.setTitle("Eat, Pray, Love");
        book.setAuthor("Elizabeth Gilbert");

        Book book1 = new Book();
        book1.setTitle("Eat, Pray, Love");
        book1.setAuthor("Elizabeth Gilbert");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        doReturn(book).when(bookDao).addBook(book1);
        doReturn(book).when(bookDao).getBook(1);
        doReturn(bookList).when(bookDao).getAllBooks();
    }

    @Test
    public void saveFindFindAllBook() {
        BookViewModel bookViewModel = new BookViewModel();
        bookViewModel.setTitle("The Alchemist");
        bookViewModel.setAuthor("Paulo Coelho");

        bookViewModel = bookService.saveBook(bookViewModel);
        BookViewModel fromService = bookService.findBookById(bookViewModel.getId());
        assertEquals(bookViewModel, fromService);

        List<BookViewModel> bookViewModelList = bookService.findAllBooks();
        assertEquals(1, bookViewModelList.size());
        assertEquals(bookViewModel, bookViewModelList.get(0));
    }
}