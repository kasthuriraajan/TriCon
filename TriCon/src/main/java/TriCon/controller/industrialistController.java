package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
public class industrialistController {
    @RequestMapping("/ind/ index")
    public String index(Map<String, Object> model) {
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
}
