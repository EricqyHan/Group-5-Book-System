package com.company.notequeueconsumer.util.messages;

public class NoteListEntry {
    private int noteId;
    private int bookId;
    private String note;

    public NoteListEntry(int noteId, int bookId, String note) {
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
                "noteId=" + noteId +
                ", bookId=" + bookId +
                ", note='" + note + '\'' +
                '}';
    }
}
