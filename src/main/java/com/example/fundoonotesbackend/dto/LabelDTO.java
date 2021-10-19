package com.example.fundoonotesbackend.dto;

import com.example.fundoonotesbackend.model.NoteData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class LabelDTO {
    public String labelName;

    public List<NoteData> notes;

    public LocalDateTime createdDate = LocalDateTime.now();
}
