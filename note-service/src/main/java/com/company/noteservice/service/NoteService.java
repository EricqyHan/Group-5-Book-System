package com.company.noteservice.service;

import com.company.noteservice.dao.NoteDao;
import com.company.noteservice.model.Note;
import com.company.noteservice.viewmodel.NoteViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteService {
    NoteDao noteDao;

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public NoteViewModel addNote(NoteViewModel noteViewModel) {
        Note note = new Note();
        note.setBookId(noteViewModel.getBookId());
        note.setNote(noteViewModel.getNote());
        note = noteDao.addNote(note);

        noteViewModel.setNoteId(note.getNoteId());

        return noteViewModel;
    }

    public void updateNote(NoteViewModel noteViewModel) {

        Note note = new Note();
        note.setNoteId(noteViewModel.getNoteId());
        note.setBookId(noteViewModel.getBookId());
        note.setNote(noteViewModel.getNote());

        noteDao.updateNote(note);
    }

    public NoteViewModel findNoteById(int id) {
        Note note = noteDao.getNote(id);

        if(note == null) {
            return null;
        } else {
            return buildNoteViewModel(note);
        }
    }

    private NoteViewModel buildNoteViewModel(Note note) {
        NoteViewModel noteViewModel = new NoteViewModel();

        noteViewModel.setNoteId(note.getNoteId());
        noteViewModel.setBookId(note.getBookId());
        noteViewModel.setNote(note.getNote());

        return noteViewModel;
    }

    public void removeBook(int id) {
        noteDao.deleteNote(id);
    }

    public List<Note> findAllNotes() {
        return noteDao.getAllNotes();
    }
}
