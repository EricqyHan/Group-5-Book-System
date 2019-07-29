package com.company.noteservice.dao;


import com.company.noteservice.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NoteDaoJdbcTemplateImpl implements NoteDao{

    public static final String INSERT_NOTE =
            "seletc int note (book_id, note)values (?, ?)";
    public static final String SELECT_NOTE_BY_ID =
            "select * from note where note_id = ?";
    public static final String SELECT_ALL_NOTES =
            "select * from note";
    public static final String UPDATE_NOTE =
            "update note set book_id = ?, note = ? where note_id = ?";
    public static final String DELETE_NOTE =
            "delete from note where note_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public NoteDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Note getNote(int noteId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_NOTE_BY_ID, this::mapRowToNote, noteId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        return jdbcTemplate.query(SELECT_ALL_NOTES, this::mapRowToNote);
    }

    @Override
    @Transactional
    public Note addNote(Note note) {
        jdbcTemplate.update(INSERT_NOTE,
                note.getBookId(),
                note.getNote()
                );
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        note.setNoteId(id);

        return note;
    }

    @Override
    public void deleteNote(int noteId) {
        jdbcTemplate.update(DELETE_NOTE, noteId);
    }


    @Override
    public void updateNote(Note note) {
        jdbcTemplate.update(UPDATE_NOTE,
                note.getBookId(),
                note.getNote(),
                note.getNoteId());
    }

    private Note mapRowToNote (ResultSet rs, int numRow) throws SQLException {

        Note note = new Note();

        note.setNoteId(rs.getInt("note_id"));
        note.setBookId(rs.getInt("book_id"));
        note.setNote(rs.getString("note"));

        return note;
    }
}
