
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
import TriCon.model.*;
import TriCon.repo.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private SmtpMailSender smtpMailSender;

    @RequestMapping("/")
    public String welcomes(Model model) {

        model.addAttribute("university", universityRepository.findAll());
        return "index";
    }
/*Loginprocess*/
    @RequestMapping("/homepage")
    public String homepage(Model model) {
        String uri="/Stu/index";
        String type="common";
        String ip="12";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

            String users1 = auth.getName();
            List<User> user = userRepository.findAll();
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getEmail().equals(users1)) {
                    type = user.get(i).getType();
                }
            }

            switch (type){
                case "Admin":
                    uri="/Admin/universities";
                    break;
                case "DeptAdmin":
                    uri="/DeptAdmin/student";
                    break;
                case "Student":
                    uri="/Stu/index";
                    break;
                case "Lecturer":
                    uri="/Lec/index";
                    break;
                case "Industrialist":
                    uri="/Ind/index";
                    break;
            }
        model.addAttribute("users", userRepository.findOne(getUserId()));
        model.addAttribute("kas",uri);
        return "home";
    }

    @GetMapping("/403")
    public String error403(Model model) {


            String uri="/Stu/index";
            String type="common";
            Authentication auth
                    = SecurityContextHolder.getContext().getAuthentication();

            String users1 = auth.getName();
            List<User> user = userRepository.findAll();
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getEmail().equals(users1)) {
                    type = user.get(i).getType();

                }
            }

            switch (type){
                case "Admin":
                    uri="/Admin/universities";
                    break;
                case "DeptAdmin":
                    uri="/DeptAdmin/student";
                    break;
                case "Student":
                    uri="/Stu/index";
                    break;
                case "Lecturer":
                    uri="/Lec/index";
                    break;
                case "Industrialist":
                    uri="/Ind/index";
                    break;
            }

            model.addAttribute("kas",uri);
        return "/error/403";
    }
  /*  @GetMapping("/403")
    public String error403(Model model) {

        String uri="/Stu/index";
        String type="common";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                type = user.get(i).getType();

            }
        }

        switch (type){
            case "Admin":
                uri="/Admin/universities";
                break;
            case "DeptAdmin":
                uri="/DeptAdmin/student";
                break;
            case "Student":
                uri="Stu/index";
                break;
            case "Lecturer":
                uri="Lec/index";
                break;
            case "Industrialist":
                uri="Ind/index";
                break;
        }

        model.addAttribute("kas",uri);
        return "/403";
    }
*/
    /*user registration*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request) throws MessagingException {

        String Id = "123";
        String Email = request.getParameter("Email");
        String Type = request.getParameter("Type");
        String Password = "!2QwAsZx";
        Boolean a = false;

        User u1 = new User();
        List<Student> s1 = studentRepository.findAll();
        List<Lecturer> L1 = lecturerRepository.findAll();
        List<Industrialist> Ind = industrialistRepository.findAll();

      if (Type.equals("Student")) {
            for (int i = 0; i < s1.size(); i++) {
                if (s1.get(i).getEmail().equals(Email)) {
                    Id = s1.get(i).getId();
                    a = true;
                }
            }
        } else if (Type.equals("Lecturer")) {
            for (int i = 0; i < L1.size(); i++) {
                if (L1.get(i).getEmail().equals(Email)) {
                    Id = L1.get(i).getId();
                    a = true;
                }
            }
        } else if (Type.equals("Industrialist")) {
            for (int i = 0; i < Ind.size(); i++) {
                if (Ind.get(i).getEmail().equals(Email)) {
                    Id = Ind.get(i).getId();
                    a = true;
                }
            }
        } else {
            System.out.println(" User Type is error");
        }


        u1.setId(Id);
        u1.setEmail(Email);
        u1.setPassword(Password);
        u1.setType(Type);

        List<User> list2 = userRepository.findAll();
        Boolean b = true;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getEmail().equals(Email)) {
                b = false;
                break;
            }

        }

        if (a && b) {

            userRepository.save(u1);
            smtpMailSender.send(Email, "Confirmation of Registration in TriCon",
                    "Hello  " + studentRepository.findOne(Id) + " Welcome to TriCon .Your user name is :  " + Email +
                            "Your Password is :  " + Password + ". Please change your password  before use account");
        } else if (!b) {
            System.out.println("This Email have been registered already");

        } else {
            System.out.println("This Email is not recommended");
        }
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
            if (list1.get(i).getEmail().equals(Email)) {
                a = false;
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
    public String getUserId()
    {
        String type="common";
        String ip="";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                ip=user.get(i).getId();
            }
        }
        return ip;
    }

}

