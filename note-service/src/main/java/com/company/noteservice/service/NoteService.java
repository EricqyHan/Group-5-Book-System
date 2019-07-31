package com.company.noteservice.service;

import com.company.noteservice.dao.NoteDao;
import com.company.noteservice.model.Note;
import com.company.noteservice.viewmodel.NoteViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public void removeNote(int id) {
        noteDao.deleteNote(id);
    }

    public List<NoteViewModel> findAllNotes() {
        List<NoteViewModel> noteViewModelList = new ArrayList<>();
        for(Note note :noteDao.getAllNotes()){
            NoteViewModel noteViewModel = new NoteViewModel();
            noteViewModel.setNote(note.getNote());
            noteViewModel.setBookId(note.getBookId());
            noteViewModel.setNoteId(note.getNoteId());
            noteViewModelList.add(noteViewModel);
        }

        return  noteViewModelList;

    }

    public List<Note> findNotesByBookId(int bookId) {
        return noteDao.getNotesByBookId(bookId);
    }
}
