package com.company.noteservice.service;

import com.company.noteservice.dao.NoteDao;
import com.company.noteservice.dao.NoteDaoJdbcTemplateImpl;
import com.company.noteservice.model.Note;
import com.company.noteservice.viewmodel.NoteViewModel;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class NoteServiceTest {

    private NoteDao noteDao;

    private NoteService noteService;

    @Before
    public void setUp() throws Exception{
        setUpNoteDaoMock();
        noteService = new NoteService(noteDao);
    }

    public void setUpNoteDaoMock(){
        noteDao = mock(NoteDaoJdbcTemplateImpl.class);

        Note note = new Note();
        note.setNoteId(1);
        note.setBookId(10);
        note.setNote("my note");

        Note note1 = new Note();
        note1.setBookId(10);
        note1.setNote("my note");

        List<Note> noteList = new ArrayList<>();
        noteList.add(note);
        doReturn(note).when(noteDao).addNote(note1);
        doReturn(note).when(noteDao).getNote(1);
    }

    @Test
    public void addNote() {
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setBookId(10);
        noteViewModel.setNote("my note");

        noteViewModel = noteService.addNote(noteViewModel);
        assertEquals(1,noteViewModel.getNoteId());
    }

    @Test
    public void updateNote() {
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setNoteId(1);
        noteViewModel.setBookId(10);
        noteViewModel.setNote("my note");
    }

    @Test
    public void findNoteById() {
        NoteViewModel noteViewModel = noteService.findNoteById(1);
        assertEquals(noteViewModel.getNoteId(), 1);

    }

    @Test
    public void removeBook() {
        noteService.removeBook(10);
    }

    @Test
    public void findAllNotes() {
        List<Note> noteList = noteService.findAllNotes();
    }
}