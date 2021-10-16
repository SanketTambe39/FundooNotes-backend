package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.UserDTO;

import javax.mail.MessagingException;

public interface IMailService {

    void sendRegisterMail(UserDTO userDTO) throws MessagingException;
    void sendOTPMessage(String to, String subject, String message);
}
