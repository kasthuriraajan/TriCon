package TriCon.controller;

import TriCon.mailsender.SmtpMailSender;
import TriCon.model.User;
import TriCon.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;

@RestController
public class mailController {

    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/send-mail")
    public void sendMail() throws MessagingException {
        List<User> user1=userRepository.findAll();
        for (int i=0;i<user1.size();i++) {
            smtpMailSender.send(user1.get(i).getEmail(), "Test mail from Spring",
                    "Howdy This is just a sample .Your user name is :"+user1.get(i).getUserName()+
                            "Your Password is :"+user1.get(i).getPassword());
        }
    }


}