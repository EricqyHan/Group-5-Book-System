package com.company.noteservice.controller;

import com.company.noteservice.service.NoteService;
import com.company.noteservice.viewmodel.NoteViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteServiceController {

    @Autowired
    private NoteService service;

    public NoteServiceController(NoteService service){
        this.service = service;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public NoteViewModel addNote(@RequestBody @Valid NoteViewModel noteViewModel){
        noteViewModel = service.addNote(noteViewModel);
        return noteViewModel;
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public NoteViewModel getNote(@PathVariable int id) {
        NoteViewModel noteViewModel = service.findNoteById(id);
        return noteViewModel;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<NoteViewModel> getAllNotes() {
        List<NoteViewModel> noteViewModelList = service.findAllNotes();
       return noteViewModelList;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public NoteViewModel updateNote(@RequestBody @Valid NoteViewModel noteViewModel){
        service.updateNote(noteViewModel);
        return noteViewModel;
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable int id) {
        service.removeNote(id);
    }
}

//
//        Get Notes by Book
//        =================
//        URI: /notes/book/{book_id}
//        HTTP Method: GET
//        RequestBody: None
//        ResponseBody: Array of Book data
