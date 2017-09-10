package TriCon.controller;

import TriCon.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class studentController
{
    private StudentRepository studentRepository;
    @RequestMapping("/stu/index")
    public String index(Map<String, Object> model)
    {
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
    public String profileupdate()
    {

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

}
