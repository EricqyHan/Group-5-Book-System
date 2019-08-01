package com.company.notequeueconsumer;


import com.company.notequeueconsumer.util.messages.NoteListEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
    @Autowired
    NotesClient client;
    @RabbitListener(queues = NoteQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(NoteListEntry msg) {

        System.out.println("Invoking notes service for " + msg.toString());
        NoteListEntry newnote = client.addNote(msg);
        System.out.println("Notes added " + newnote.toString());

    }

}
