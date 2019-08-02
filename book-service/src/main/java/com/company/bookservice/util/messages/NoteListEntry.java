package com.company.bookservice.util.messages;

import com.company.bookservice.model.Note;

import java.util.List;

public class NoteListEntry {

    private int noteId;
    private int bookId;
    private String note;

//    public NoteListEntry(String title, String author, List<Note> notes) {
//
//    }
    public NoteListEntry(int noteId, int bookId, String note){
        this.noteId = noteId;
        this.bookId = bookId;
        this.note = note;
    }

    public NoteListEntry() {

    }

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
    public String toString() {
        return "NoteListEntry{" +
                "note='" + note + '\'' +
                '}';
    }
}
