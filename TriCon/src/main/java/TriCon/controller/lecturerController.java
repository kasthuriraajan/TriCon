package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class lecturerController {
    @RequestMapping("/lec/index")
    public String index(Map<String, Object> model)

    {
        return "lecturer/index";
    }
    @RequestMapping("/lec/inspectreport")
    public String inspectreport(Map<String, Object> model)
    {
        return "lecturer/inspectreport";
    }
    @RequestMapping("/lec/weeklyreport")
    public String weeklyreport(Map<String, Object> model)
    {
        return "lecturer/weeklyreport";
    }
    @RequestMapping("/lec/weeklyreportedit")
    public String weeklyreportedit(Map<String, Object> model)
    {
        return "lecturer/weeklyreportedit";
    }
    @RequestMapping("/lec/inspectreportedit")
    public String inspectreportedit(Map<String, Object> model)
    {
        return "lecturer/inspectreportedit";
    }
    @RequestMapping("/lec/pastrecords")
    public String pastrecords(Map<String, Object> model)
    {
        return "lecturer/pastrecords";
    }
}
