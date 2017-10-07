package TriCon.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndustrialistController {

    @RequestMapping("/Ind/index")
    public String welcome() {
        return "Industrialist/index";
    }

    @RequestMapping("/Ind/committedStudents")
    public String committedStudents() {
        return "Industrialist/committedStudents";
    }

    @RequestMapping("/Ind/weeklyReport")
    public String weeklyReport() {
        return "Industrialist/weeklyReport";
    }

    @RequestMapping("/Ind/profileUpdate")
    public String profileUpdate() {
        return "Industrialist/profileUpdate";
    }
}
