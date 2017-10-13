
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

import TriCon.model.*;
import TriCon.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;





@Controller
public class LecturerController {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private InspectionReportRepository inspectionReportRepository;
   
    @RequestMapping("/Lec/index")
    public String welcome(Model model) {
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(getUserId()));
        return "Lecturer/index";
    }
            /*Change password*/

    @RequestMapping ("Lec/changePassword")
    public String changePassword(Model model){
        String message1="Change your password if you want";
        String userId="1";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                userId=user.get(i).getId();
            }
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Lecturer/changePassword";
    }

    @RequestMapping (value = "Lec/changePassword",method = RequestMethod.POST)
    public String changePassword(org.apache.catalina.servlet4preview.http.HttpServletRequest request, Model model){
        String OP=request.getParameter("oldPassword");
        String NP=request.getParameter("newPassword");
        String CP=request.getParameter("confirmPassword");
        System.out.println(OP);
        System.out.println(NP);
        System.out.println(CP);
        String message1="Change your password if you want";
        Boolean p=false;

        String userId="1";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getEmail().equals(users1) && user.get(i).getPassword().equals(OP)&&NP.equals(CP))
            {
                p=true;
            }

            if (user.get(i).getEmail().equals(users1)) {
                userId=user.get(i).getId();
            }

        }
        User user2=userRepository.findOne(userId);


        if(p)
        {
            user2.setPassword(NP);
            userRepository.save(user2);
            message1="Your Password has changed.";
        }
        else
        {
            message1="Your Password has not changed!";
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Lecturer/changePassword";
    }


    @RequestMapping("/Lec/committedStudents")
    public String committedStudents(Model model) {

        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(getUserId()));
        model.addAttribute("journal", journalRepository.findAll());
        return "Lecturer/committedStudents";
    }

    @RequestMapping(value = "/Lec/inspectReport", method = RequestMethod.POST)
    public String inspectReport(HttpServletRequest request, Model model) {
        String action = request.getParameter("journal");

        model.addAttribute("journalId",action);
        model.addAttribute("localDate", LocalDate.now());

        return "Lecturer/inspectReport";
    }

    @RequestMapping(value = "/Lec/weeklyReport" ,method = RequestMethod.POST)
    public String weeklyReport(HttpServletRequest request, Model model) {
        String action= request.getParameter("journal");
        System.out.println(action);
    model.addAttribute("journalId",action);
        return "Lecturer/weeklyReport";
    }

    @RequestMapping("/Lec/weeklyReportEdit")
    public String weeklyReportEdit() {
        return "Lecturer/weeklyReportEdit";
    }

    @RequestMapping(value = "/Lec/inspectReportEdit",method = RequestMethod.POST)
    public String inspectReportEdit(HttpServletRequest request ,Model model) {
        String action = request.getParameter("journal");
        String date = request.getParameter("date");
        String report = request.getParameter("report");

        String Id = action + "/I/" + date;
        InspectionReport Ins=new InspectionReport();
        Ins.setId(Id);
        Ins.setJournalId(action);
        Ins.setLectId(getUserId());
        Ins.setDate(date);
        Ins.setReview(report);
        inspectionReportRepository.save(Ins);
        model.addAttribute("journalId",action);
        model.addAttribute("localDate", LocalDate.now());
        return "Lecturer/inspectReport";
    }

    @RequestMapping("/Lec/finalReport")
    public String finalReport() {
        return "Lecturer/finalReport";
    }

    @RequestMapping("/Lec/pastRecords")
    public String PastRecords() {
        return "Lecturer/pastRecords";
    }

    @RequestMapping("/Lec/forum")
    public String forum() {
        return "Lecturer/forum";
    }

    @RequestMapping("/Lec/chat")
    public String chat() {
        return "Lecturer/chat";
    }

    @RequestMapping("/Lec/progressReport")
    public String progressReport() {
        return "Lecturer/progressReport";
    }
    @RequestMapping("/Lec/profileUpdate")
    public String profileUpdate(Model model) {


        Lecturer student1 = lecturerRepository.findOne(getUserId());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("lecturer", student1);
        return "Lecturer/profileUpdate";
    }

    @RequestMapping(value = "/Lec/profileUpdate", method = RequestMethod.POST)
    public String profileUpdate(HttpServletRequest request, Model model) {
        String userId="1";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                userId=user.get(i).getId();
            }
        }
        String Id = userId;
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        String MobileNo = request.getParameter("Mobile");
        String TPNo = request.getParameter("TP");
        String Address = request.getParameter("Address");
        String LinkedIn = request.getParameter("LinkedIn");
        String Twitter = request.getParameter("Twitter");
        String GitHub = request.getParameter("GitHub");
        String Facebook = request.getParameter("Facebook");
        String Blog = request.getParameter("Blog");
        String action = request.getParameter("save");
        Lecturer s1 = lecturerRepository.findOne(Id);
        if (action.equals("personal")) {

            s1.setId(Id);
            s1.setFirstName(FirstName);
            s1.setLastName(LastName);
            s1.setMobileNo(MobileNo);
            s1.setEmail(Email);
            s1.setTPNo(TPNo);
            s1.setAddress(Address);

            lecturerRepository.save(s1);
        } else if (action.equals("socialMedia")) {

            Lecturer s2 = lecturerRepository.findOne(Id);
            s2.setLinkedIn(LinkedIn);
            s2.setTwitter(Twitter);
            s2.setGitHub(GitHub);
            s2.setFacebook(Facebook);
            s2.setBlog(Blog);

            lecturerRepository.save(s2);
        }

        model.addAttribute("lecturer", s1);
        return "Lecturer/profileUpdate";
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
