package com.company.noteservice.dao;

import com.company.noteservice.model.Note;

import java.util.List;

public interface NoteDao {

    Note getNote(int note_id);

    List<Note> getAllNotes();

    Note addNote(Note note);

    void deleteNote(int note_id);

    void updateNote(Note note);
}
