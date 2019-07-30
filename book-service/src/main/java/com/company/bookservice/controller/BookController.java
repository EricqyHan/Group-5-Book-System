package com.company.bookservice.controller;

import com.company.bookservice.service.BookService;
import com.company.bookservice.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    BookViewModel addBook(@RequestBody @Valid BookViewModel book){
        BookViewModel newBook = bookService.addBook(book);
        return newBook;
    }

}
