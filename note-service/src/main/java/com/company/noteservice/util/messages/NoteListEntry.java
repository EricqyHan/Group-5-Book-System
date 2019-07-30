package com.company.noteservice.util.messages;

public class NoteListEntry {

    private String note;

    public NoteListEntry() {

    }

    public NoteListEntry(String note) {
        this.note = note;
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

