package com.company.noteservice.service;

import com.company.noteservice.dao.NoteDao;
import com.company.noteservice.model.Note;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesListner {

    @Autowired
    NoteDao dao;

    @RabbitListener
    public void receiveMessage(Note note) {
        System.out.println("Received note " + note.getNote());
        if(note != null){
            if(note.getNoteId()==0){

                dao.addNote(note);
            }else {
                dao.updateNote(note);
            }
        }
    }
}
