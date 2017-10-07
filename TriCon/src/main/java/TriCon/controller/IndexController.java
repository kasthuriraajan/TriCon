package TriCon.controller;


import TriCon.mailsender.SmtpMailSender;
import TriCon.model.Department;
import TriCon.model.User;
import TriCon.repo.DepartmentRepository;
import TriCon.repo.UniversityRepository;
import TriCon.repo.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private SmtpMailSender smtpMailSender;

    @RequestMapping("/")
    public String welcomes(Model model) {

        model.addAttribute("university", universityRepository.findAll());
        return "index";
    }


    /*user registration*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request) throws MessagingException {
        String UserName = request.getParameter("UserName");
        String Email = request.getParameter("Email");
        String Type = request.getParameter("Type");

        User u1 = new User();

        u1.setId("S0002");
        u1.setEmail(Email);
        u1.setType(Type);

        userRepository.save(u1);

        smtpMailSender.send(Email, "Confirmation of Registration in TriCon",
                "Hello" + UserName + " Welcome to TriCon .Your user name is :" + UserName +
                        "Your Password is :!2QwAsZx  . Please change your password before use account");
        return "index";
    }

    /*Department Register*/
    @RequestMapping(value = "/registerDept", method = RequestMethod.POST)
    public String registerDept(HttpServletRequest request, Model model) throws MessagingException {
        String Id = DeptId();
        String UniId = request.getParameter("UniId");
        String DeptName = request.getParameter("DeptName");
        String Email = request.getParameter("Email");
        String Phone = request.getParameter("Phone");
        String AuthKey = "!2QwAsZx";
        String Password = "!2QwAsZx";

        Department dept1 = new Department();
        User user1 = new User();

        dept1.setId(Id);
        dept1.setUniId(UniId);
        dept1.setDeptName(DeptName);
        dept1.setEmail(Email);
        dept1.setContactNo(Phone);
        dept1.setAuthKey(AuthKey);

        user1.setId(Id);
        user1.setEmail(Email);
        user1.setPassword(Password);
        user1.setType("DeptAdmin");

        List<User> list1 = userRepository.findAll();
        Boolean a = true;
        for (int i = 0; i < list1.size(); i++) {
            String a1 = "Hi";
            String as = "Hi";
            if (list1.get(i).getEmail().equals(Email)) {
                a = false;
                System.out.println("Hello");
                break;
            }
            System.out.println("Hi");
            System.out.println(list1.get(i).getEmail() + "and" + Email);
        }

        if (a) {
            departmentRepository.save(dept1);
            userRepository.save(user1);
            smtpMailSender.send(Email, "Confirmation of Registration in TriCon",
                    "Hello  " + DeptName + " Welcome to TriCon .Your user name is :  " + DeptName +
                            "Your Password is :  " + Password + " Your Authentication key is " + AuthKey + ". Please change your password and AuthenticationKey before use account");
        } else {
            System.out.println("This Email have been registered already");

        }
        return "index";
    }


    public String DeptId() {
        String Id = "D";

        List<Department> list1 = departmentRepository.findAll();
        int i = 0;
        while (i < list1.size()) {
            i++;
        }
        String s = String.format("%03d", (i + 1));
        Id = Id + s;


        return Id;
    }
}

