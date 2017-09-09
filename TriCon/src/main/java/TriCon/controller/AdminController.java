package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin/department")
    public String adminindex(){
        return "admin/department";
    }
}
