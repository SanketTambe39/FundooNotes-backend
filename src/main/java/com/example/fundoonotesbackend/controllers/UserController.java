package com.example.fundoonotesbackend.controllers;

import com.example.fundoonotesbackend.dto.ResponseDTO;
import com.example.fundoonotesbackend.dto.UserDTO;
import com.example.fundoonotesbackend.dto.VerifyUser;
import com.example.fundoonotesbackend.service.IMailService;
import com.example.fundoonotesbackend.service.IUserService;
import com.example.fundoonotesbackend.util.Response;
import com.example.fundoonotesbackend.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    Token userToken;

    @Autowired
    IMailService mailService;

    @PostMapping("/adduser")
    ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<ResponseDTO>( new ResponseDTO("Add Call Success",
                userService.addUser(userDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", userId),
                HttpStatus.OK);
    }

    @PutMapping("/updateuser/{token}")
    ResponseEntity<Response> updateUser(@PathVariable("token") String token,
                                        @RequestBody UserDTO userDTO){
        Response resp = userService.updateUser(token, userDTO);
        return new ResponseEntity<Response>(resp, HttpStatus.OK);
    }

    @GetMapping(value = {"/all"})
    ResponseEntity<ResponseDTO> getUsers(){
        return new ResponseEntity<ResponseDTO> (new ResponseDTO("Get Call Success",
                userService.getUsers()), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDTO> getUserbyId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<ResponseDTO>( new ResponseDTO("Get Call By Id Success",
                userService.getUserById(userId)), HttpStatus.OK);
    }

    @GetMapping("/useremail/{emailId}")
    public ResponseEntity<ResponseDTO> getUserByEmailId(@PathVariable("emailId") String emailId) {

        return new ResponseEntity<ResponseDTO>( new ResponseDTO("Get Call By Mail Id Success",
                userService.getUserByEmailId(emailId)), HttpStatus.OK);
    }

    @PostMapping("/verifyuser")
    ResponseEntity<Response> verifyUser(@RequestBody VerifyUser verifyUser){
        Response response = userService.verifyUser(verifyUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/send")
    public String sendEmail( HttpServletRequest req) {
        mailService.sendOTPMessage("sdtambe62@gmail.com", "Email testing", "you registered successfully");
        return "Mail Sent";
    }

    @PostMapping("/register")
    public String sendRegisterMail(@RequestBody UserDTO userDTO) throws MessagingException {
        mailService.sendRegisterMail(userDTO);
        return "Mail Sent";
    }
}
