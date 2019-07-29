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
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NoteDaoJdbcTemplateImpl(JdbcTemplate newjdbcTemplate){
        this.jdbcTemplate = newjdbcTemplate;
    }

    //Prepared Statement
    private static final String INSERT_NOTE_SQL =
            "insert into note (book_id, note) values (?,?)";

    private static final String SELECT_NOTE_SQL =
            "select * from note where note_id = ?";

    private static final String SELECT_ALL_NOTE_SQL =
            "select * from note";

    private static final String DELETE_NOTE_SQL =
            "delete from note where note_id = ?";

    private static final String UPDATE_NOTE_SQL =
            "update note set book_id = ?, note = ? where note_id = ?";

    private Note mapRowToNote(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();
        note.setNoteId(rs.getInt("note_id"));
        note.setBookId(rs.getInt("book_id"));
        note.setNote(rs.getString("note"));

        return note;
    }

    @Override
    public Note getNote(int noteId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_NOTE_SQL, this::mapRowToNote, noteId);
        } catch (EmptyResultDataAccessException e){
            // if there is no match for this note id, return null
            return null;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        return jdbcTemplate.query(SELECT_ALL_NOTE_SQL, this::mapRowToNote);
    }

    @Override
    public Note addNote(Note note) {
        jdbcTemplate.update(
                INSERT_NOTE_SQL,
                note.getBookId(),
                note.getNote());
        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        note.setNoteId(id);
        return note;
    }

    @Override
    public void deleteNote(int noteId) {
        jdbcTemplate.update(DELETE_NOTE_SQL,noteId);

    }

    @Override
    public void updateNote(Note note) {
        jdbcTemplate.update(
                UPDATE_NOTE_SQL,
                note.getBookId(),
                note.getNote(),
                note.getNoteId());
    }



}
