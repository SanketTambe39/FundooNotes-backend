package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService implements IMailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JavaMailSender javaMailSender;

    @Override
    public void sendRegisterMail(UserDTO userDTO) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Thank you for registering");
        helper.setTo(userDTO.getEmail());
        helper.setText("Dear " + userDTO.getFname() + ",\n" +
                "\n" +
                "Thank you for your registration. If you have any questions, please let me know!.\n" +
                "\n" +
                "Thank you , Have great day,", false);
        javaMailSender.send(message);
    }

    @Override
    public void sendOTPMessage(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("uniquebookstore098@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        logger.info(subject);
        logger.info(to);
        logger.info(message);

        javaMailSender.send(simpleMailMessage);
    }
}
