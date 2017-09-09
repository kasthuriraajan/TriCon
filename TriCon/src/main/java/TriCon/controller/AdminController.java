package TriCon.controller;


import TriCon.model.Industrialist;
import TriCon.model.Lecturer;
import TriCon.model.Student;
import TriCon.repo.DepartmentRepository;
import TriCon.repo.IndustrialistRepository;
import TriCon.repo.LecturerRepository;
import TriCon.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @RequestMapping("/admin/department")
    public String departments(){
        return "admin/department";
    }
    @RequestMapping("/admin/departmentdetails")
    public String departmentdetails(Model model){
        model.addAttribute("department",departmentRepository.findAll());
        return "admin/departmentdetails";
    }
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @RequestMapping(value="/admin/student", method = RequestMethod.POST)
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
    @RequestMapping("/admin/student")
    public String student(Map<String, Object> model) {
        return "/DeptAdmin/student";
    }
    @RequestMapping("/admin/studentdetails")
    public String studentdetails(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "/DeptAdmin/studentdetails";
    }
    @RequestMapping(value="/admin/lecturer", method = RequestMethod.POST)
    public String lecturer(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String LectId = request.getParameter("LectId");
        String DeptId= request.getParameter("DeptId");
        String DeptName = request.getParameter("DeptName");
        String University = request.getParameter("University");
        String Email = request.getParameter("Email");

        Lecturer lec1 = new Lecturer();
        lec1.setId(Id);
        lec1.setFirstName(FirstName);
        lec1.setLastName(LastName);
        lec1.setLectId(LectId);
        lec1.setDeptId(DeptId );
        lec1.setDeptName(DeptName);
        lec1.setUniversity(University );
        lec1.setEmail(Email );

        lecturerRepository.save(lec1);
        return "DeptAdmin/lecturer";
    }
    @RequestMapping("/admin/lecturer")
    public String lecturer(Map<String, Object> model) {
        return "/DeptAdmin/lecturer";
    }
    @RequestMapping("/admin/lecturerdetails")
    public String lecturerdetails(Model model) {
        model.addAttribute("lecturer", lecturerRepository.findAll());
        return "/DeptAdmin/lecturerdetails";
    }
    @RequestMapping(value="/admin/industrialist", method = RequestMethod.POST)
    public String industrialist(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String IndId = request.getParameter("IndId");
        String Company= request.getParameter("Company");
        String Designation = request.getParameter("Designation");

        String Email = request.getParameter("Email");

        Industrialist ind1 = new Industrialist();
        ind1.setId(Id);
        ind1.setFirstName(FirstName);
        ind1.setLastName(LastName );
        ind1.setIndId(IndId);
        ind1.setCompany(Company );
        ind1.setDesignation(Designation);

        ind1.setEmail(Email );

        industrialistRepository.save(ind1);
        return "DeptAdmin/industrialist";
    }
    @RequestMapping("/admin/industrialist")
    public String industrialist(Map<String, Object> model) {
        return "/DeptAdmin/industrialist";
    }
    @RequestMapping("/admin/industrialistdetails")
    public String industrialistdetails(Model model) {
        model.addAttribute("industrialist", industrialistRepository.findAll());
        return "/DeptAdmin/industrialistdetails";
    }
}
