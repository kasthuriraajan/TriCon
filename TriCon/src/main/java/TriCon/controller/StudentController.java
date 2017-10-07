package TriCon.controller;

import TriCon.model.Student;
import TriCon.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    private static String UPLOADED_FOLDER = "G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\static\\imagesample\\";

    @RequestMapping("/Stu/index")
    public String welcome(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "Student/index";
    }

    @RequestMapping("/Stu/myRecords")
    public String myRecords() {
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
    public String profileUpdate(Model model)
    {

        Student student1=studentRepository.findOne("S00003");

        model.addAttribute("student", student1);
        return "Student/profileUpdate";
    }
    @RequestMapping(value="/Stu/profileUpdate", method = RequestMethod.POST)
    public String profileUpdate(HttpServletRequest request) {
        String Id ="S00003";
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String MobileNo = request.getParameter("Mobile");
        String TPNo= request.getParameter("TP");
        String Address= request.getParameter("Address");

        String Email = request.getParameter("Email");

        Student s1 = new Student();
        s1.setId(Id);
        s1.setFirstName(FirstName);
        s1.setLastName(LastName );
        s1.setMobileNo(MobileNo);
        s1.setEmail(Email);
        s1.setTPNo(TPNo);
        s1.setAddress(Address);
        studentRepository.save(s1);

        return "Student/profileUpdate";
    }

    @RequestMapping("/Stu/editProfile")
    public String editProfile() {
        return "Student/editProfile";
    }

    @RequestMapping("/Stu/weeklyReport")
    public String weeklyReport() {
        return "Student/weeklyReport";
    }

    @RequestMapping("/Stu/summary")
    public String summary() {
        return "Student/summary";
    }

    @RequestMapping("/Stu/finalReport")
    public String finalReport() {
        return "Student/finalReport";
    }

    @RequestMapping("/Stu/newJournal")
    public String newJournal() {
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

}
