package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.example.fundoonotesbackend.dto.NoteDTO;
import com.example.fundoonotesbackend.dto.ResponseDTO;

import java.time.LocalDateTime;

public interface INoteService {

    ResponseDTO add(String userIdToken, NoteDTO noteDTO);
    ResponseDTO getNoteByUser(String userIdToken, int noteId);
    ResponseDTO getAllNoteByUser(String userIdToken);
    ResponseDTO getNoteByTitle(String title);
    ResponseDTO updateNote(String userIdToken, NoteDTO noteDTO, int noteId);
    ResponseDTO deleteNote(String userIdToken, int noteId);
    ResponseDTO pinTheNote(String userIdToken, int noteId);
    ResponseDTO addToArchive(String userIdToken, int noteId);
    ResponseDTO addToTrash(String userIdToken, int noteId);
    ResponseDTO addLabelToNote(String userIdToken, LabelDTO labelToNoteDTO);
    ResponseDTO removeLabelFromNote(String userIdToken, LabelDTO labelToNoteDTO);
    ResponseDTO addReminder(String userIdToken, int noteId, LocalDateTime reminder);
    ResponseDTO updateReminder(String userIdToken, int noteId, LocalDateTime reminder);
    ResponseDTO removeReminder(String userIdToken, int noteId);

}
