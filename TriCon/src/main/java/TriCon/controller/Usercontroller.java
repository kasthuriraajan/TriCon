package TriCon.controller;

import TriCon.model.User;
import TriCon.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Usercontroller {
    private UserRepository userRepository;
    @RequestMapping(value="/signup" ,method=RequestMethod.POST)
    public  String user(HttpServletRequest request){

        User u1=new User();
        u1.setId("S0001");
        u1.setEmail("kasthuriraajan@gmail.com");
        u1.setUniversity("UOJ");
        u1.setDepartment("CSC");
        u1.setPassword("!2QwAsZx");
        u1.setType("Student");
        u1.setUserName("Kasthu");
        return "profileupdate";
    }
}
