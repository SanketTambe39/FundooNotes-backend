package com.example.fundoonotesbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "collaborator")
@Data
public class CollaboratorData {

    @Id
    @Column(name = "collab_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collabId;

    @Column(name = "collab_created_date")
    private LocalDateTime createdDate;

    @Column(name = "collab_updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "collab_user_id")
    private Long userId;

    @Column(name = "collab_user_email")
    private String userEmail;

    @Column(name = "collab_user_fname")
    private String userFname;

    @Column(name = "collab_user_lname")
    private String userLname;

    @JsonIgnoreProperties(value = "collaborators")
    @ManyToMany(mappedBy = "collaborators", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NoteData> notes;
    
}
