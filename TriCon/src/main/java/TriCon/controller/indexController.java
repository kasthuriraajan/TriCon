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

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/weeklyreport")
	public String weeklyreport(Map<String, Object> model) {
		model.put("message", this.message);
		return "weeklyreport";
	}
}

