package com.example.fundoonotesbackend.controllers;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.example.fundoonotesbackend.dto.ResponseDTO;
import com.example.fundoonotesbackend.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    ILabelService labelService;

    @GetMapping("")
    public ResponseDTO getAllLabelsByUser(@RequestParam String UserIdToken) {
        return labelService.getAllLabelsByUser(UserIdToken);
    }

    @PostMapping("/add")
    public ResponseDTO addLabel(@RequestParam String userIdToken, @RequestBody LabelDTO labelDTO) {
        return labelService.addLabel(userIdToken, labelDTO);
    }

    @PutMapping("/update")
    public ResponseDTO updateLabel(@RequestParam String userIdToken, @RequestParam int labelId, @RequestBody LabelDTO labelDTO) {
        return labelService.updateLabel(userIdToken, labelId, labelDTO);
    }

    @DeleteMapping("/deletelabel")
    public ResponseDTO deleteLabel(@RequestParam String userIdToken, @RequestParam int labelId) {
        return labelService.deleteLabel(userIdToken, labelId);

    }

    @DeleteMapping("/deleteall")
    public ResponseDTO removeAllNotesByLabel(@RequestParam String userIdToken, @RequestParam int labelId) {
        return labelService.deleteLabel(userIdToken, labelId);
    }

    @DeleteMapping("/delete")
    public ResponseDTO deleteAllLabelByUser(@RequestParam String userIdToken) {
        return labelService.deleteAllLabelByUser(userIdToken);
    }
    
}
