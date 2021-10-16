package com.example.fundoonotesbackend.model;

import com.example.fundoonotesbackend.dto.UserDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "userregistration")
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID")
    private int userId;

    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phoneno;
    private LocalDate dob;
    private LocalDateTime registerDate = LocalDateTime.now();
    private LocalDate updatedDate;
    private boolean verify;
    private String profilepic;

    public UserData(){ }

    public UserData(UserDTO userDTO){ this.updateUserModel(userDTO); }

    public void updateUserModel(UserDTO userDTO){
        this.fname = userDTO.fname;
        this.lname = userDTO.lname;
        this.email = userDTO.email;
        this.password = userDTO.password;
        this.phoneno = userDTO.phoneno;
        this.dob = userDTO.dob;
        this.updatedDate = userDTO.updatedDate;
        this.verify = userDTO.verify;
        this.profilepic = userDTO.profilepic;
    }

}
