package com.company.notequeueconsumer;

import com.company.notequeueconsumer.util.messages.NoteListEntry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "localhost:1984", name = "notes")
public interface NotesClient {
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    List<String> getNotes();
    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    NoteListEntry addNote(NoteListEntry note);
}
