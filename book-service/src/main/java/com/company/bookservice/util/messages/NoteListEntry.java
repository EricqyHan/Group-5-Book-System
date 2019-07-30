package com.company.bookservice.util.messages;

public class NoteListEntry {

    private String note;

    public NoteListEntry() {
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
