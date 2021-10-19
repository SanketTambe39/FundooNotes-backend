package com.example.fundoonotesbackend.dto;

import com.example.fundoonotesbackend.model.CollaboratorData;
import com.example.fundoonotesbackend.model.LabelData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NoteDTO {
    public String title;
    public String description;
    public String color;
    public LocalDateTime registerDate = LocalDateTime.now();
    public boolean isPin;
    public boolean isArchive;
    public List<LabelData> labels;
    public List<CollaboratorData> collaborators;
}
