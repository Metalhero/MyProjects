package com.project.work.service;

import com.project.work.model.ContactMessage;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EmailService {

    private final Log log = LogFactory.getLog(this.getClass());

    @Value("${server.url}")
    private String SERVER_URL;

    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(String email, String username, String activationCode) {
        SimpleMailMessage message;
        try{
            message=new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo(email);
            message.setSubject("Sikeres regisztráció");
            message.setText("Kedves " + username + "! \n \nKöszönöm hogy regisztráltál az oldalamra!\nAz alábbi linken tudod aktiválni magadat: "
                    + SERVER_URL + "activation/" + activationCode);
            javaMailSender.send(message);
        }catch (Exception e){
            log.error("Error with the email sending(sending) process: " + email + " " + e);
        }
    }

    public void contactMessage(ContactMessage contactMessage) {
        SimpleMailMessage message;
        try {
            message = new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo("metalhero2010@gmail.com");
            message.setSubject("Projekt értesítés " + contactMessage.getEmail());
            message.setText("Projekt kapcsán üzenetet küldtek az alábbi adatokkal:\n"+
                    "\temail: "+contactMessage.getEmail()+
                    "\n\tneve: "+contactMessage.getFullName()+
                    "\n\ttelefonszáma: "+contactMessage.getPhoneNumber()+
                    "\n\nAz alábbi üzenet érkezett hozzá: \n"+
                    contactMessage.getMessage());
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("Error with the email sending(receiving) process: " + contactMessage.getEmail() + " " + e);
        }
    }

}
