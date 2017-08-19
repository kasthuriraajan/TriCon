package TriCon.controller;

import TriCon.model.Student;
import TriCon.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Controller
public class DeptAdminController {
    @Autowired
    private StudentRepository studentRepository;
    @RequestMapping(value="/DeptAdmin/student", method = RequestMethod.POST)
    public String student(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String RegNo = request.getParameter("RegNo");
        String DeptNo= request.getParameter("DeptNo");
        String DeptName = request.getParameter("DeptName");
        String University = request.getParameter("University");
        String Email = request.getParameter("Email");

        Student s1 = new Student();
        s1.setId(Id);
        s1.setFirstName(FirstName);
        s1.setLastName(LastName );
        s1.setRegNo(RegNo);
        s1.setDeptNo(DeptNo);
        s1.setDeptName(DeptName);
        s1.setUniversity(University);
        s1.setEmail(Email);
        studentRepository.save(s1);
        return "DeptAdmin/student";
    }
    @RequestMapping("/DeptAdmin/student")
    public String student(Map<String, Object> model) {
        return "/DeptAdmin/student";
    }
    @RequestMapping("/DeptAdmin/studentdetails")
    public String studentdetails(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "/DeptAdmin/studentdetails";
    }
}
