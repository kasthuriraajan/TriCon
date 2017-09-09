package TriCon.controller;


import TriCon.model.Department;
import TriCon.model.User;
import TriCon.repo.DepartmentRepository;
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
@Autowired
private DepartmentRepository departmentRepository;

    @RequestMapping("/")
    public String welcome() {

        return "index";
    }
// user registration
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
        u1.setId("00245");
        u1.setEmail(Email);
        u1.setRegNo(RegNo);
        u1.setUniversity(University);
        u1.setDepartment(Department);
        u1.setType(Type);
        u1.setUserName(UserName);
        userRepository.save(u1);
        /*List<User> user1=userRepository.findAll();
        for(int i=0; i<user1.size();i++)
        {
            System.out.println(user1.get(i).getId());
            System.out.println(user1.get(i).getUniversity());
            System.out.println(user1.get(i).getDepartment());
            System.out.println(user1.get(i).getRegNo());
            System.out.println(user1.get(i).getEmail());
            System.out.println(user1.get(i).getUserName());
            System.out.println(user1.get(i).getType());
        }*/
        //System.out.println(UserName);

        return "index";
    }
@RequestMapping(value = "/registerDept", method = RequestMethod.POST)
    public String registerDept(HttpServletRequest request){


    String UnivName=request.getParameter("Univ");
    String DeptName=request.getParameter("DeptName");
    String Email=request.getParameter("mail");
    String Phone=request.getParameter("Phone");

    Department dept1=new Department();


    dept1.setEmail(Email);
    dept1.setUniId("03");
    dept1.setUniversity(UnivName);
    dept1.setDeptId("001");
    dept1.setDepartment(DeptName);
    dept1.setContactNo(Phone);
    dept1.setAuthKey("!2QwAsZx");

    departmentRepository.save(dept1);
        return "index";
}

    /*@RequestMapping("/header")
    public String header() {

        return "fragments/header";
    }

    @RequestMapping("/footer")
    public String footer() {

        return "fragments/footer";
    }

    @RequestMapping("/profile")
    public String profile() {

        return "fragments/profile";
    }

    @RequestMapping("/userlist")
    public String userlist() {

        return "fragments/userlist";
    }

    @RequestMapping("/sidebar")
    public String sidebar() {

        return "fragments/sidebar";
    }
*/



}

