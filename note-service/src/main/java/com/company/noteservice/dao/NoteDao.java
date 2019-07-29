package com.company.noteservice.dao;

import com.company.noteservice.model.Note;

import java.util.List;

public interface NoteDao {

    Note getNote(int noteId);

    List<Note> getAllNotes();

    Note addNote(Note note);

    void deleteNote(int noteId);

    void updateNote(Note note);
}
