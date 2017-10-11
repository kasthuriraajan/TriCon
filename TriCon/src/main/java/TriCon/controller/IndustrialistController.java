package TriCon.controller;


import TriCon.model.Industrialist;
import TriCon.model.Lecturer;
import TriCon.model.User;
import TriCon.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        System.out.println(action);
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
