package TriCon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LecturerController {

    @RequestMapping("/Lec/index")
    public String welcome() {
        return "Lecturer/index";
    }

    @RequestMapping("/Lec/committedStudents")
    public String committedStudents() {
        return "Lecturer/committedStudents";
    }

    @RequestMapping("/Lec/inspectReport")
    public String inspectReport() {
        return "Lecturer/inspectReport";
    }

    @RequestMapping("/Lec/weeklyReport")
    public String weeklyReport() {
        return "Lecturer/weeklyReport";
    }

    @RequestMapping("/Lec/weeklyReportEdit")
    public String weeklyReportEdit() {
        return "Lecturer/weeklyReportEdit";
    }

    @RequestMapping("/Lec/inspectReportedit")
    public String inspectReportEdit() {
        return "Lecturer/inspectReportedit";
    }

    @RequestMapping("/Lec/finalReport")
    public String finalReport() {
        return "Lecturer/finalReport";
    }

    @RequestMapping("/Lec/pastRecords")
    public String PastRecords() {
        return "Lecturer/pastRecords";
    }

    @RequestMapping("/Lec/forum")
    public String forum() {
        return "Lecturer/forum";
    }

    @RequestMapping("/Lec/chat")
    public String chat() {
        return "Lecturer/chat";
    }

    @RequestMapping("/Lec/progressReport")
    public String progressReport() {
        return "Lecturer/progressReport";
    }
}
