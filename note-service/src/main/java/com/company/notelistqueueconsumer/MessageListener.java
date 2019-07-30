package com.company.notelistqueueconsumer;

import com.company.noteservice.NoteServiceApplication;
import com.company.noteservice.util.messages.NoteListEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = NoteServiceApplication.QUEUE_NAME)
    public void receiveMessage(NoteListEntry note) {
        System.out.println(note.toString());
    }

}
