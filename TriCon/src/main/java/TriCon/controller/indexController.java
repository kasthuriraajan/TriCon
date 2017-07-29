package TriCon.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class indexController {

    // inject via application.properties
    @Value("${index.message:test}")
    private String message = "Hello World";

<<<<<<< HEAD
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}
	@RequestMapping("/inspectnew")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "";
	}
=======
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "fragments/index";
    }
>>>>>>> e1ef41901767dbc23a120bfbcf5563d2ecd77d0d

    @RequestMapping("/weeklyreport")
    public String weeklyreport(Map<String, Object> model) {
        model.put("message", this.message);
        return "weeklyreport";
    }

    @RequestMapping("/header")
    public String header(Map<String, Object> model) {
        model.put("message", this.message);
        return "fragments/header";
    }

    @RequestMapping("/footer")
    public String footer(Map<String, Object> model) {

        return "fragments/footer";
    }

    @RequestMapping("/profile")
    public String profile(Map<String, Object> model) {

        return "fragments/profile";
    }

    @RequestMapping("/userlist")
    public String userlist(Map<String, Object> model) {

        return "fragments/userlist";
    }

    @RequestMapping("/sidebar")
    public String sidebar(Map<String, Object> model) {

        return "fragments/sidebar";
    }
}

