package com.example.fundoonotesbackend.controllers;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.example.fundoonotesbackend.dto.NoteDTO;
import com.example.fundoonotesbackend.dto.ResponseDTO;
import com.example.fundoonotesbackend.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    INoteService noteService;

    @PostMapping("/add/{token}")
    public ResponseDTO addNotes(@PathVariable String token, @RequestBody NoteDTO nodeDTO) {
        return noteService.add(token, nodeDTO);
    }

    @GetMapping(value ={ "getall/{token}"})
    public ResponseDTO getAllNotesByUser(@PathVariable String token) {
        return noteService.getAllNoteByUser(token);
    }

    @GetMapping(value ={ "", "/"})
    public ResponseDTO getNoteByUser(@RequestParam String token, @RequestParam int noteId) {
        return noteService.getNoteByUser(token, noteId);
    }

    @PutMapping("/update")
    public ResponseDTO updateNote(@RequestParam String token, @RequestParam int noteId, @RequestBody NoteDTO nodeDTO) {
        return noteService.updateNote(token, nodeDTO, noteId);
    }

    @PostMapping("/pin")
    public ResponseDTO pinTheNote(@RequestParam String userIdToken, @RequestParam int noteId) {
        return noteService.pinTheNote(userIdToken, noteId);
    }

    @PostMapping("/archive")
    public ResponseDTO addToArchive(@RequestParam String userIdToken, @RequestParam int noteId) {
        return noteService.addToArchive(userIdToken, noteId);
    }

    @PostMapping("/trash")
    public ResponseDTO addToTrash(@RequestParam String userIdToken, @RequestParam int noteId) {
        return noteService.addToTrash(userIdToken, noteId);
    }

    @PostMapping("/addlabel")
    public ResponseDTO addLabelToNote(@RequestParam String userIdToken, @RequestParam LabelDTO labelToNoteDTO) {
        return noteService.addLabelToNote(userIdToken, labelToNoteDTO);
    }

    @DeleteMapping("/delete")
    public ResponseDTO deleteNote(@RequestParam String userIdToken, @RequestParam int noteId) {
        return noteService.deleteNote(userIdToken, noteId);
    }
}