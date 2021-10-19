package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.example.fundoonotesbackend.dto.NoteDTO;
import com.example.fundoonotesbackend.dto.ResponseDTO;
import com.example.fundoonotesbackend.model.NoteData;
import com.example.fundoonotesbackend.model.UserData;
import com.example.fundoonotesbackend.repo.NoteRepo;
import com.example.fundoonotesbackend.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService {

    @Autowired
    Token myToken;

    @Autowired
    IUserService userService;

    @Autowired
    NoteRepo noteRepo;

    @Override
    public ResponseDTO add(String userIdToken, NoteDTO noteDTO) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {

            NoteData note = new NoteData(noteDTO);
            note.setUserId(userId);
            ;
            return new ResponseDTO(200, "Node added by "+ user.get().getFname(), noteRepo.save(note));

        }
        return new ResponseDTO(200, "User is not present ", null);
    }

    @Override
    public ResponseDTO getNoteByUser(String userIdToken, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            NoteData notes = noteRepo.getById(noteId);
            return new ResponseDTO(200, "getNoteByUser call success ", notes);
        }
        return new ResponseDTO(200, "getNoteByUser call Failed user not present ", null);
    }

    @Override
    public ResponseDTO getAllNoteByUser(String userIdToken) {
        System.out.println("decode ==="+ " =="+ userIdToken);
        Long userId = myToken.decodeToken(userIdToken);
        System.out.println("decode ==="+ userId+" =="+ userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            List<NoteData> notes = noteRepo.findAllByUser(userId);
            return new ResponseDTO(200, "getAllNoteByUser call success ", notes);
        }
        return new ResponseDTO(200, "getAllNoteByUser call Failed user not present ", null);
    }

    @Override
    public ResponseDTO getNoteByTitle(String title) {

        return null;
    }

    @Override
    public ResponseDTO updateNote(String userIdToken, NoteDTO noteDTO, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {

            NoteData note = noteRepo.getById(noteId);
            note.updateNote(noteDTO);
            return new ResponseDTO(200, "Note updated by "+ user.get().getFname(), noteRepo.save(note));

        }
        return new ResponseDTO(200, "Note is not updated because User is not present ", null);
    }

    @Override
    public ResponseDTO deleteNote(String userIdToken, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            NoteData note = noteRepo.getById(noteId);
            noteRepo.delete(note);
            return new ResponseDTO(200, "Note deleted by "+ user.get().getFname(),null );

        }
        return new ResponseDTO(200, "Note is not deleted because User is not present ", null);
    }


    @Override
    public ResponseDTO pinTheNote(String userIdToken, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            NoteData note = noteRepo.getById(noteId);
            note.setPin(true);
            return new ResponseDTO(200, "Note is pinned by "+ user.get().getFname(),noteRepo.save(note));

        }
        return new ResponseDTO(200, "Note is not pinned because User is not present ", null);
    }

    @Override
    public ResponseDTO addToArchive(String userIdToken, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            NoteData note = noteRepo.getById(noteId);
            note.setArchieve(true);
            return new ResponseDTO(200, "added to archive by "+ user.get().getFname(),noteRepo.save(note) );

        }
        return new ResponseDTO(200, "Note is not added to archive because User is not present ", null);
    }

    @Override
    public ResponseDTO addToTrash(String userIdToken, int noteId) {
        Long userId = myToken.decodeToken(userIdToken);

        Optional<UserData> user = Optional.ofNullable(userService.getUserById(userId));

        if(user.isPresent()) {
            NoteData note = noteRepo.getById(noteId);
            note.setTrash(true);
            return new ResponseDTO(200, "Note added to trash by "+ user.get().getFname(),noteRepo.save(note));

        }
        return new ResponseDTO(200, "Note is not added to trash because User is not present ", null);
    }

    @Override
    public ResponseDTO addLabelToNote(String userIdToken, LabelDTO labelToNoteDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseDTO removeLabelFromNote(String userIdToken, LabelDTO labelToNoteDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseDTO addReminder(String userIdToken, int noteId, LocalDateTime reminder) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseDTO updateReminder(String userIdToken, int noteId, LocalDateTime reminder) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseDTO removeReminder(String userIdToken, int noteId) {
        // TODO Auto-generated method stub
        return null;
    }

}
