package TriCon.controller;


import TriCon.model.User;
import TriCon.repo.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
public class indexController {
@Autowired
private UserRepository userRepository;
    // inject via application.properties
    @Value("${index.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "fragments/index";
    }

    @RequestMapping("/weeklyreport")
    public String weeklyreport(Map<String, Object> model) {
        model.put("message", this.message);
        return "weeklyreport";
    }

    @RequestMapping("/student")
    public String student(Map<String, Object> model) {
        model.put("message", this.message);
        return "student";
    }

    @RequestMapping("/lecturer")
    public String lecturer(Map<String, Object> model) {
        model.put("message", this.message);
        return "lecturer";
    }

    @RequestMapping("/industrialist")
    public String industrialist(Map<String, Object> model) {
        model.put("message", this.message);
        return "industrialist";
    }

    @RequestMapping("/user")
    public String user(Map<String, Object> model) {
        model.put("message", this.message);
        return "user";
    }

    @RequestMapping("/header")
    public String header(Map<String, Object> model) {
        model.put("message", this.message);
        return "fragments/header";
    }

    @RequestMapping("/footer")
    public String footer(Map<String, Object> model) {

        return "fragments/footer";
    }

    @RequestMapping("/profile")
    public String profile(Map<String, Object> model) {

        return "fragments/profile";
    }

    @RequestMapping("/userlist")
    public String userlist(Map<String, Object> model) {

        return "fragments/userlist";
    }

    @RequestMapping("/sidebar")
    public String sidebar(Map<String, Object> model) {

        return "fragments/sidebar";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String welcome(HttpServletRequest request)
    {
        String UserName=request.getParameter("UserName");
        String Email =request.getParameter("Email");
        String RegNo =request.getParameter("RegNo");
        String University =request.getParameter("Uni");
        String Department =request.getParameter("Dept");
        String Type =request.getParameter("Type");

        User u1=new User();
        u1.setId("0023");
        u1.setEmail(Email);
        u1.setRegNo(RegNo);
        u1.setUniversity(University);
        u1.setDepartment(Department);
        u1.setType(Type);
        u1.setUserName(UserName);
        userRepository.save(u1);
        List<User> user1=userRepository.findAll();
        for(int i=0; i<user1.size();i++)
        {
            System.out.println(user1.get(i).getId());
            System.out.println(user1.get(i).getUniversity());
            System.out.println(user1.get(i).getDepartment());
            System.out.println(user1.get(i).getRegNo());
            System.out.println(user1.get(i).getEmail());
            System.out.println(user1.get(i).getUserName());
            System.out.println(user1.get(i).getType());
        }
        //System.out.println(UserName);
        return "fragments/register";
    }

    @RequestMapping ("/register")
    public String register(Map<String, Object>model){
        return "fragments/register";
    }
    @RequestMapping ("/model")
    public String register(){
        return "samplemodel";
    }
}

