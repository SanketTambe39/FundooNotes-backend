package com.example.fundoonotesbackend.model;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "labels")
@Data
public class LabelData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private int labelId;

    @Column(name = "label_name")
    private String labelName;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "note_id")
    private int noteId;

    @Column(name = "label_created_date")
    private LocalDateTime createdDate;


    @Column(name = "label_updated_date")
    private LocalDateTime updatedDate;

    @JsonIgnoreProperties(value = "labels")
    @ManyToMany(mappedBy = "labels", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NoteData> notes;

    public LabelData() {
        super();
    }

    public LabelData(LabelDTO labelDTO) {

        this.labelName = labelDTO.labelName;
        this.createdDate = labelDTO.createdDate;
        this.notes = labelDTO.notes;
    }

    public void  updateLabel(LabelDTO labelDTO) {

        this.labelName = labelDTO.labelName;
        this.updatedDate = labelDTO.createdDate;
        this.notes = labelDTO.notes;
    }
}
