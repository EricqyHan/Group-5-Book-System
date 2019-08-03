package com.company.bookservice.util.messages;

import com.company.bookservice.model.Note;

import java.util.List;

public class NoteListEntry {
    private String note;

    public NoteListEntry(String title, String author, List<Note> notes) {
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
