package com.hnm.hnm.controller.words;

import com.hnm.hnm.entity.words.Note;
import com.hnm.hnm.service.words.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/makeNote")
    public Note makeNote(@RequestParam String name) {
        return noteService.makeNote(name);
    }
}
