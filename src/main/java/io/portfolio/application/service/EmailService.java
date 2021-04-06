package io.portfolio.application.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Log log = LogFactory.getLog(this.getClass());

    @Value("${server.url}")
    private String SERVER_URL;

    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;

    private JavaMailSender javaMailSender;

    public EmailService() {
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(String email, String username, String activationCode) {
        SimpleMailMessage message = null;

        try{
            message=new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo(email);
            message.setSubject("Projektmunka Registration");
            message.setText("Dear " + username + "! \n \nThank you for registering to my project!\nHere is your activation link: " + SERVER_URL + "activation/" + activationCode);
            javaMailSender.send(message);

        }catch (Exception e){
            log.error("Error with the email sending process: " + email + " " + e);
        }

    }

}
