package TriCon.controller;


import TriCon.model.*;
import TriCon.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;


    /*University*/
    @RequestMapping("Admin/universities")
    public String universities(){

        return "Admin/universities";
    }

    @RequestMapping(value = "/Admin/universities", method = RequestMethod.POST)
    public String universities(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String UniName = request.getParameter("UniName");
        String ShortCut=request.getParameter("ShortCut");

        University uni=new University();
        uni.setId(Id);
        uni.setUniName(UniName);
        uni.setShortCut(ShortCut);

        universityRepository.save(uni);
        return "Admin/universities";
    }
    @RequestMapping("/Admin/universityDetails")
    public String universityDetails(Model model) {
        model.addAttribute("university", universityRepository.findAll());
        return "Admin/universityDetails";
    }
    /*Department*/
    @RequestMapping("/Admin/department")
    public String departments() {
        return "Admin/department";
    }

    @RequestMapping("/Admin/departmentDetails")
    public String departmentDetails(Model model) {
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        return "Admin/departmentDetails";
    }

    /*User*/
    @RequestMapping("/Admin/userDetails")
    public String userDetails(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "Admin/userDetails";
    }

    /*Student*/
    @RequestMapping("/Admin/student")
    public String students() {
        return "Admin/student";
    }

    @RequestMapping("/Admin/studentDetails")
    public String studentDetails(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        return "Admin/studentDetails";
    }

    /*Lecturer*/
    @RequestMapping("/Admin/lecturer")
    public String lecturers() {
        return "/Admin/lecturer";
    }

    @RequestMapping("/Admin/lecturerDetails")
    public String lecturerDetails(Model model) {
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        return "Admin/lecturerDetails";
    }

    /*Industrialist*/
    @RequestMapping("/Admin/industrialist")
    public String industrialists() {
        return "Admin/industrialist";
    }

    @RequestMapping("/Admin/industrialistDetails")
    public String industrialistDetails(Model model) {
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        return "Admin/industrialistDetails";
    }
}
