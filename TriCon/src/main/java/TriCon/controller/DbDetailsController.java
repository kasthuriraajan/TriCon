package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
public class DbDetailsController {

    @RequestMapping("/DbD/student")
    public String student(Map<String, Object> model) {
        return "DbDetails/student";
    }

    @RequestMapping("/DbD/lecturer")
    public String lecturer(Map<String, Object> model) {
        return "DbDetails/lecturer";
    }

    @RequestMapping("/DbD/industrialist")
    public String industrialist(Map<String, Object> model) {
        return "DbDetails/industrialist";
    }
    @RequestMapping("/DbD/user")
    public String user(Map<String, Object> model) {
        return "DbDetails/user";
    }
}

