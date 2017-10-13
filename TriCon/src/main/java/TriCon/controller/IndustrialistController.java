
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
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static TriCon.crypto.SignGenerator.verifyDigitalSignature;

@Controller
public class IndustrialistController {

    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private WeeklyReportRepository weeklyReportRepository;
    @Autowired
    private InspectionReportRepository inspectionReportRepository;
    @Autowired
    private ProgressReportRepository progressReportRepository;
    @Autowired
    private VerifyRepository verifyRepository;


   /* private String userId ="0123";*/

   @RequestMapping("/Ind/index")
    public String welcome(Model model) {
       model.addAttribute("department", departmentRepository.findAll());
       model.addAttribute("university", universityRepository.findAll());
       model.addAttribute("industrialist", industrialistRepository.findAll());
       model.addAttribute("student", studentRepository.findAll());
       model.addAttribute("lecturer", lecturerRepository.findAll());
       model.addAttribute("users", industrialistRepository.findOne(getUserId()));

       return "Industrialist/index";

    }
            /*Change password*/

    @RequestMapping ("Ind/changePassword")
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
        model.addAttribute("users", industrialistRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Industrialist/changePassword";
    }

    @RequestMapping (value = "Ind/changePassword",method = RequestMethod.POST)
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
        model.addAttribute("users", industrialistRepository.findOne(userId));
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("message1",message1);
        return"Industrialist/changePassword";
    }

    @RequestMapping("/Ind/committedStudents")
    public String committedStudents(Model model) {

        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", industrialistRepository.findOne(getUserId()));
        model.addAttribute("journal", journalRepository.findAll());
        return "Industrialist/committedStudents";
    }

    @RequestMapping(value = "/Ind/weeklyReport" ,method = RequestMethod.POST)
    public String weeklyReport(HttpServletRequest request, Model model) {
        String action= request.getParameter("journal");
        model.addAttribute("lists",weeklyReportRepository.findAll());
        model.addAttribute("journalId",action);
        return "Industrialist/weeklyReport";
    }


    @RequestMapping("/Ind/profileUpdate")
    public String profileUpdate(Model model) {


       Industrialist Industrialist1 = industrialistRepository.findOne(getUserId());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", Industrialist1);
        return "Industrialist/profileUpdate";
    }

    @RequestMapping(value = "/Ind/profileUpdate", method = RequestMethod.POST)
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
        Industrialist s1 = industrialistRepository.findOne(Id);
        if (action.equals("personal")) {

            s1.setId(Id);
            s1.setFirstName(FirstName);
            s1.setLastName(LastName);
            s1.setMobileNo(MobileNo);
            s1.setEmail(Email);
            s1.setTPNo(TPNo);
            s1.setCompany(Address);

            industrialistRepository.save(s1);
        } else if (action.equals("socialMedia")) {

            Industrialist s2 = industrialistRepository.findOne(Id);
            s2.setLinkedIn(LinkedIn);
            s2.setTwitter(Twitter);
            s2.setGitHub(GitHub);
            s2.setFacebook(Facebook);
            s2.setBlog(Blog);

            industrialistRepository.save(s2);
        }

        model.addAttribute("industrialist", s1);
        return "Industrialist/profileUpdate";
    }
    @RequestMapping(value = "/Ind/progressReport", method = RequestMethod.POST)
    public String progRep(HttpServletRequest request,Model model)
    {
        String action= request.getParameter("journal");
        model.addAttribute("journalId",action);
        return"Industrialist/progressReport";
    }
    @RequestMapping(value ="/Ind/inspectReport", method = RequestMethod.POST)
    public String inspectRep(HttpServletRequest request,Model model)
    {
        String action= request.getParameter("journal");

        model.addAttribute("JournalId",action);
        model.addAttribute("lists",inspectionReportRepository.findAll());
        model.addAttribute("lecturer",lecturerRepository.findOne(journalRepository.findOne(action).getLecId()));
        return"Industrialist/inspectionReport";
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
    private static byte[] getKeyData(String filePath) {
        File file = new File(filePath);
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return buffer;
    }

}
