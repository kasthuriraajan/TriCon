package TriCon.controller;

<<<<<<< HEAD
import TriCon.model.Student;
import TriCon.repo.StudentRepository;
=======
import TriCon.model.User;
import TriCon.repo.UserRepository;
>>>>>>> origin/romi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
=======

>>>>>>> origin/romi
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class industrialistController {

    @Autowired
<<<<<<< HEAD
    private StudentRepository studentRepository;

    @RequestMapping(value = "/ind/index", method = RequestMethod.POST)
=======
    private UserRepository userRepository;

    @RequestMapping(value = "/ind/index" ,method = RequestMethod.POST)
>>>>>>> origin/romi
    public String index(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

<<<<<<< HEAD
        System.out.println("Username " + username);
        System.out.println("Password " + password);

        Student s1 = new Student();
        s1.setFirstName("Kasthuri");
        s1.setLastName("Rajan");
        studentRepository.save(s1);
        System.out.println("Saved success");
=======
        System.out.println("Username" + username);
        System.out.println("Password" + password);

        User user = new User();
        user.setFirstName("romi");
        user.setLastName("praveen");

        userRepository.save(user);
        System.out.println("saved success");
>>>>>>> origin/romi

        return "industrialist/index";
    }




    @RequestMapping("/ind/commitedstudents")
    public String commitedstudents(Map<String, Object> model) {
        return "industrialist/commitedstudents";
    }

    @RequestMapping("/ind/weeklyreport")
    public String weeklyreport(Map<String, Object> model) {
        return "industrialist/weeklyreport";
    }

    @RequestMapping("/ind/profileupdate")
    public String profileupdate(Map<String, Object> model) {
        return "industrialist/profileupdate";
    }
}
