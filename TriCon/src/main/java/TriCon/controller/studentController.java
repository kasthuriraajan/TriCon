package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class studentController
{
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
}
