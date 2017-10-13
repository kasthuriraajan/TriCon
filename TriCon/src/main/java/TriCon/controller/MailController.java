
/*
 *  Copyright 2017 copyright to triconnect2017@gmail.com
 *
 *
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *
 *    you may not use this file except in compliance with the License.
 *
 *    You may obtain a copy of the License at
 *
 *
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *    See the License for the specific language governing permissions and
 *
 *    limitations under the License
 */

package TriCon.controller;

import TriCon.mailsender.SmtpMailSender;
import TriCon.model.User;
import TriCon.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;

@RestController
public class MailController {

    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/sendMail")
    public void sendMail() throws MessagingException {
        List<User> user1 = userRepository.findAll();
        for (int i = 0; i < user1.size(); i++) {
            smtpMailSender.send(user1.get(i).getEmail(), "Test mail from Spring",
                    "Howdy This is just a sample .Your user name is :" +
                            "Your Password is :" + user1.get(i).getPassword());
        }
    }


}