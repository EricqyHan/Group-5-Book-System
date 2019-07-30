package com.company.noteservice.dao;

import com.company.noteservice.model.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoteDaoTest {

    @Autowired
    NoteDao noteDao;

    @Before
    public void setUp() throws Exception {
        List<Note> noteList = noteDao.getAllNotes();
        for(Note note : noteList){
            noteDao.deleteNote(note.getNoteId());
        }
    }

    @Test
    public void getNote() {
        Note note1 = new Note();
        note1.setBookId(1);
        note1.setNote("my notes");
        note1 = noteDao.addNote(note1);

        Note note2 = new Note();
        note2.setBookId(1);
        note2.setNote("my notes");
        note2 = noteDao.addNote(note2);

        Note note3 = noteDao.getNote(note1.getNoteId());
        assertEquals(note1, note3);
        note3 = noteDao.getNote(note2.getNoteId());
        assertEquals(note2, note3);
    }

    @Test
    public void getAllNotes() {
        Note note1 = new Note();
        note1.setBookId(1);
        note1.setNote("my notes");
        note1 = noteDao.addNote(note1);

        Note note2 = new Note();
        note2.setBookId(1);
        note2.setNote("my notes");
        note2 = noteDao.addNote(note2);

        List<Note> noteList = noteDao.getAllNotes();
        assertEquals(noteList.size(),2);
    }

    @Test
    public void addNote() {
        Note note = new Note();
        note.setBookId(1);
        note.setNote("my notes");
        note = noteDao.addNote(note);

        Note note1 = noteDao.getNote(note.getNoteId());
        assertEquals(note1, note);
    }

    @Test
    public void deleteNote() {
        Note note = new Note();
        note.setBookId(1);
        note.setNote("my notes");
        note = noteDao.addNote(note);

        noteDao.deleteNote(note.getNoteId());
        Note note1 = noteDao.getNote(note.getNoteId());
        assertNull(note1);
    }

    @Test
    public void updateNote() {
        Note note = new Note();
        note.setBookId(1);
        note.setNote("my notes");
        note = noteDao.addNote(note);

        note.setBookId(10);
        noteDao.updateNote(note);

        Note note1 = noteDao.getNote(note.getNoteId());
        assertEquals(note1, note);
    }

    @Test
    public void getNotesByBookId() {
        Note note = new Note();
        note.setBookId(10);
        note.setNote("my notes");

        note = noteDao.addNote(note);

        List<Note> noteList = noteDao.getNotesByBookId(10);
        assertEquals(1,noteList.size());
        assertEquals(10, noteList.get(0).getBookId());
    }
}