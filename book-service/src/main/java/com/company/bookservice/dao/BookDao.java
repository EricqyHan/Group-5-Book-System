package com.company.bookservice.dao;

import com.company.bookservice.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book Book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);



}
