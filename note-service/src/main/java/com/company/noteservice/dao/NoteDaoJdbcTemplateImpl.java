package com.company.noteservice.dao;


import com.company.noteservice.model.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDaoJdbcTemplateImpl implements NoteDao{

    public static final String INSERT_NOTE =
            "seletc int note (note_id, book_id, note)values (?, ?, ?)";
    public static final String SELECT_NOTE_BY_ID =
            "";
    public static final String SELECT_ALL_NOTES =
            "";
    public static final String UPDATE_NOTE =
            "";
    public static final String DELETE_NOTE =
            "";

    @Override
    public Note getNote(int note_id) {
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }

    @Override
    public Note addNote(Note note) {
        return null;
    }

    @Override
    public void deleteNote(int note_id) {

    }


    @Override
    public void updateNote(Note note) {

    }
}
