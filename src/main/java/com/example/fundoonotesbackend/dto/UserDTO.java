package com.example.fundoonotesbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    @NotEmpty(message = "Persons first-name cannot be null.")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$",message = "Persons first-name is Invalid")
    public String fname;

    @NotEmpty(message = "Persons first-name cannot be null.")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$",message = "Persons first-name is Invalid")
    public String lname;

    @NotEmpty(message = "Email Id cannot be null.")
    public String email;

    @NotEmpty(message = "Password cannot be null.")
    public String password;

    @NotEmpty(message = "Number cannot be null.")
    public String phoneno;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Date of birth should not be empty")
    public LocalDate dob;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Update Date should not be empty")
    public LocalDate updatedDate;

    @NotEmpty(message = "verification cannot be null.")
    public boolean verify;

    @NotEmpty(message = "profilepic cannot be null.")
    public String profilepic;

}
