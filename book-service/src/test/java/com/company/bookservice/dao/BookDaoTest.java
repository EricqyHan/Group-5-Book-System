package com.company.bookservice.dao;

import com.company.bookservice.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {

        List<Book> books = bookDao.getAllBooks();
        for (Book book : books) {
            bookDao.deleteBook(book.getBookId());
        }
    }

    @Test
    public void addGetDeleteBook() {

        Book book = new Book();
        book.setTitle("The Alchemist");
        book.setAuthor("Paulo Coelho");

        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBookId());
        assertEquals(book1, book);

        bookDao.deleteBook(book.getBookId());

        book1 = bookDao.getBook(book.getBookId());
        assertNull(book1);

    }


    @Test
    public void getAllBooks() {

        Book book = new Book();
        book.setTitle("The Alchemist");
        book.setAuthor("Paulo Coelho");
        book = bookDao.addBook(book);

        book = new Book();
        book.setTitle("Under The Dome");
        book.setAuthor("Stephen King");
        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();
        assertEquals(2, bookList.size());

    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setTitle("The AlChemist");
        book.setAuthor("Paulo Coelho");
        book = bookDao.addBook(book);

        book.setTitle("The Alchemist");
        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getBookId());
        assertEquals(book1, book);
    }
}