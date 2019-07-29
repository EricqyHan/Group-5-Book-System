package com.company.noteservice.viewmodel;

import java.util.Objects;

public class NoteViewModel {
    private int noteId;
    private int bookId;
    private String note;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteViewModel)) return false;
        NoteViewModel that = (NoteViewModel) o;
        return noteId == that.noteId &&
                bookId == that.bookId &&
                note.equals(that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, bookId, note);
    }

}
