package com.company.bookservice.viewmodel;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class BookViewModel {
    private int id;
    @NotEmpty(message = "Please supply a value for title")
    private String title;
    @NotEmpty(message = "Please supply a value for author")
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int bookId) {
        this.id = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookViewModel that = (BookViewModel) o;
        return id == that.id &&
                title.equals(that.title) &&
                author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
}
