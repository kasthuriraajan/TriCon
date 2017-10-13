
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

import TriCon.crypto.SignGenerator;
import TriCon.model.*;
import TriCon.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static TriCon.crypto.SignGenerator.generateDigitalSignature;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private WeeklyReportRepository weeklyReportRepository;
    @Autowired
    private AccessTableRepository accessTableRepository;
    @Autowired
    private KeyTableRepository keyTableRepository;


    private static String UPLOADED_FOLDER = "G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\static\\imagesample\\";

    @RequestMapping("/Stu/index")
    public String welcome(Model model) {
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
        model.addAttribute("users", studentRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        return "Student/index";
    }
        /*Change password*/

    @RequestMapping ("Stu/changePassword")
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
        model.addAttribute("users", studentRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Student/changePassword";
    }

    @RequestMapping (value = "Stu/changePassword",method = RequestMethod.POST)
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
            System.out.println("Password has changed.");
            message1="Your Password has changed.";
        }
        else
        {
            System.out.println("Password hasn't changed");
            message1="Your Password has not changed!";
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("users", studentRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Student/changePassword";
    }


    @RequestMapping("/Stu/myRecords")
    public String myRecords(Model model) {

        model.addAttribute("journal", journalRepository.findAll());
        return "Student/myRecords";
    }

    @RequestMapping("/Stu/progReport")
    public String progReport() {
        return "Student/progReport";
    }

    @RequestMapping("/Stu/profile")
    public String profile() {

        return "Student/profile";
    }

    @RequestMapping("/Stu/profileUpdate")
    public String profileUpdate(Model model) {

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
        Student student1 = studentRepository.findOne(userId);
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("student", student1);
        return "Student/profileUpdate";
    }

    @RequestMapping(value = "/Stu/profileUpdate", method = RequestMethod.POST)
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
        Student s1 = studentRepository.findOne(Id);
        if (action.equals("personal")) {

            s1.setId(Id);
            s1.setFirstName(FirstName);
            s1.setLastName(LastName);
            s1.setMobileNo(MobileNo);
            s1.setEmail(Email);
            s1.setTPNo(TPNo);
            s1.setAddress(Address);

            studentRepository.save(s1);
        } else if (action.equals("socialMedia")) {

            Student s2 = studentRepository.findOne(Id);
            s2.setLinkedIn(LinkedIn);
            s2.setTwitter(Twitter);
            s2.setGitHub(GitHub);
            s2.setFacebook(Facebook);
            s2.setBlog(Blog);


            studentRepository.save(s2);
        }

        model.addAttribute("student", s1);
        return "Student/profileUpdate";
    }

    @RequestMapping("/Stu/editProfile")
    public String editProfile() {
        return "Student/editProfile";
    }

    @RequestMapping(value = "/Stu/weeklyReport", method = RequestMethod.POST)
    public String weeklyReport(HttpServletRequest request, Model model) {
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

        String day = request.getParameter("date");
        String report = request.getParameter("report");
        Calendar c = GregorianCalendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String startDate = "", endDate = "";
        String JournalId = "";
        String Week = "";
        Boolean b = true;
        List<Journal> j2 = journalRepository.findAll();

        for (int i = 0; i < j2.size(); i++) {
            if (j2.get(i).getStuId().equals(userId) && j2.get(i).getStatus().equals("Active"))
                JournalId = j2.get(i).getId();
        }

        try {
            Date date = df.parse(day);
            Week = date.toString().substring(0, Math.min(date.toString().length(), 3));
            c.setTime(date);
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            startDate = df.format(c.getTime());
            c.add(Calendar.DATE, 6);
            endDate = df.format(c.getTime());
        } catch (ParseException e) {
            //handle exception if date is not in "dd-MMM-yyyy" format
        }

        String Id = JournalId + "/" + startDate;
       /* System.out.println(Id);
        System.out.println(JournalId);
        System.out.println("Start Date = " + startDate);
        System.out.println("End Date = " + endDate);
        System.out.println(Week);
        System.out.println(report);*/

        List<WeeklyReport> we1 = weeklyReportRepository.findAll();
        for (int i = 0; i < we1.size(); i++) {
            if (we1.get(i).getFrom().equals(startDate) && we1.get(i).getJournalId().equals(JournalId)) {
                b = false;
            }
        }
        WeeklyReport w1 = new WeeklyReport();

        if (b) {
            w1.setId(Id);
            w1.setJournalId(JournalId);
            w1.setFrom(startDate);
            w1.setTo(endDate);
            w1.setStuSign("non");
            w1.setIndSign("non");
            w1.setLectSign("non");
            w1.setStatus("Not submitted");
            weeklyReportRepository.save(w1);
        }
        WeeklyReport w2 = weeklyReportRepository.findOne(Id);

        switch (Week) {
            case "Mon":
                w2.setMonday(report);
                break;
            case "Tue":
                w2.setTuesday(report);
                break;
            case "Wed":
                w2.setWednesday(report);
                break;
            case "Thu":
                w2.setThursday(report);
                break;
            case "Fri":
                w2.setFriday(report);
                break;
            case "Sat":
                w2.setSaturday(report);
                break;
            case "Sun":
                w2.setSunday(report);
                break;

        }

        weeklyReportRepository.save(w2);
        model.addAttribute("weeklyReport", weeklyReportRepository.findOne(Id));
        model.addAttribute("localDate", LocalDate.now());
        return "Student/weeklyReport";
    }

    @RequestMapping("/Stu/weeklyReport")
    public String weeklyReport(Model model) {
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
        Calendar c = GregorianCalendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String startDate = df.format(c.getTime());
        c.add(Calendar.DATE, 6);
        String endDate = df.format(c.getTime());
        String JournalId = "";
        List<Journal> j2 = journalRepository.findAll();

        for (int i = 0; i < j2.size(); i++) {
            if (j2.get(i).getStuId().equals(userId) && j2.get(i).getStatus().equals("Active"))
                JournalId = j2.get(i).getId();
        }
        String Id = JournalId + "/" + startDate;

        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("weeklyReport", weeklyReportRepository.findOne(Id));


        return "Student/weeklyReport";
    }


    @RequestMapping("/Stu/finalReport")
    public String finalReport() {
        return "Student/finalReport";
    }

    @RequestMapping("/Stu/newJournal")
    public String newJournal() {
        return "Student/newJournal";
    }

    @RequestMapping(value = "/Stu/newJournal", method = RequestMethod.POST)
    public String newJournal(HttpServletRequest request) {
        String From = request.getParameter("StartDate");
        String To = request.getParameter("EndDate");
        String Company = request.getParameter("Company");
        String Catergory = request.getParameter("Catergory");
        String Field = request.getParameter("Field");
        String RegNo = request.getParameter("RegNo");
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
        Journal j1 = new Journal();
        j1.setId(journalId());
        j1.setStuId(userId);
        j1.setCompany(Company);
        j1.setField(Field);
        j1.setCategory(Catergory);
        j1.setContractNo(RegNo);
        j1.setFrom(From);
        j1.setTo(To);
        j1.setStatus("Active");
        j1.setLecId("L00001");
        j1.setIndId("I00001");
        journalRepository.save(j1);

        return "Student/newJournal";
    }

    @RequestMapping("/Stu/inspectReport")
    public String inspectReport() {
        return "Student/inspectReport";
    }

    @RequestMapping("/Stu/novation")
    public String novation() {
        return "Student/novation";
    }

    @RequestMapping(value = "/Stu/novation", method = RequestMethod.POST)
    public String novation(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            System.out.println("Please select a file to upload");
            return "Student/novation";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "' at " + UPLOADED_FOLDER +
                    file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Student/novation";


    }

    public String journalId() {
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

        List<Journal> list1 = journalRepository.findAll();
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getStuId().equals(userId)) {
                count++;
            }
        }
        String s = "/J/" + (count + 1);
        Id = Id + s;


        return Id;
    }

}
