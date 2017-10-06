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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
public class studentController
{
   @Autowired
    private StudentRepository studentRepository;

    private static String UPLOADED_FOLDER = "G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\static\\imagesample\\";
    @RequestMapping("/stu/index")
    public String index(Model model)
    {
        model.addAttribute("student", studentRepository.findAll());
        return "student/index";
    }

    @RequestMapping("/stu/myrecords")
    public String myrecords(Map<String, Object> model)
    {
        return "student/myrecords";
    }

    @RequestMapping("/stu/progreport")
    public String progreport(Map<String, Object> model)
    {
        return "student/progreport";
    }

    @RequestMapping("/stu/profile")
    public String profile(Map<String, Object> model)
    {
        return "student/profile";
    }

    @RequestMapping("/stu/profileupdate")
    public String profileupdate(Model model)
    {

        Student student1=studentRepository.findOne("S0001");

        model.addAttribute("student", student1);
        return "student/profileupdate";
    }

    @RequestMapping("/stu/editprofile")
    public String editprofile(Map<String, Object> model)
    {
        return "student/editprofile";
    }

    @RequestMapping("/stu/weeklyreport")
    public String weeklyreport(Map<String, Object> model)
    {
        return "student/weeklyreport";
    }

    @RequestMapping("/stu/summary")
    public String summary(Map<String, Object> model)
    {
        return "student/summary";
    }

    @RequestMapping("/stu/finalreport")
    public String finalreport(Map<String, Object> model)
    {
        return "student/finalreport";
    }

    @RequestMapping("/stu/newjournal")
    public String newjournal(Map<String, Object> model)
    {
        return "student/newjournal";
    }

    @RequestMapping("/stu/inspectreport")
    public String inspectreport(Map<String, Object> model)
    {
        return "student/inspectreport";
    }
    @RequestMapping("/stu/novation")
    public String novation()
    {
        return "student/novation";
    }

    @RequestMapping(value="/stu/novation", method= RequestMethod.POST)
    public String novation(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes)
    {if (file.isEmpty()) {
        System.out.println("Please select a file to upload");
        return "student/novation";
    }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "' at "+UPLOADED_FOLDER +
                    file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "student/novation";


    }

}
