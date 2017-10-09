package TriCon.controller;

import TriCon.model.InspectionReport;
import TriCon.model.Journal;
import TriCon.model.WeeklyReport;
import TriCon.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@Controller
public class LecturerController {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private InspectionReportRepository inspectionReportRepository;
    private String userId = "L00001";

    @RequestMapping("/Lec/index")
    public String welcome(Model model) {

        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(userId));
        return "Lecturer/index";
    }

    @RequestMapping("/Lec/committedStudents")
    public String committedStudents(Model model) {

        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(userId));
        model.addAttribute("journal", journalRepository.findAll());
        return "Lecturer/committedStudents";
    }

    @RequestMapping(value = "/Lec/inspectReport", method = RequestMethod.POST)
    public String inspectReport(HttpServletRequest request, Model model) {
        String action = request.getParameter("journal");

        model.addAttribute("journalId",action);
        model.addAttribute("localDate", LocalDate.now());

        return "Lecturer/inspectReport";
    }

    @RequestMapping(value = "/Lec/weeklyReport" ,method = RequestMethod.POST)
    public String weeklyReport(HttpServletRequest request, Model model) {
        String action= request.getParameter("journal");
        System.out.println(action);
    model.addAttribute("journalId",action);
        return "Lecturer/weeklyReport";
    }

    @RequestMapping("/Lec/weeklyReportEdit")
    public String weeklyReportEdit() {
        return "Lecturer/weeklyReportEdit";
    }

    @RequestMapping(value = "/Lec/inspectReportEdit",method = RequestMethod.POST)
    public String inspectReportEdit(HttpServletRequest request ,Model model) {
        String action = request.getParameter("journal");
        String date = request.getParameter("date");
        String report = request.getParameter("report");

        String Id = action + "/I/" + date;
        InspectionReport Ins=new InspectionReport();
        Ins.setId(Id);
        Ins.setJournalId(action);
        Ins.setLectId(userId);
        Ins.setDate(date);
        Ins.setReview(report);
        inspectionReportRepository.save(Ins);
        model.addAttribute("journalId",action);
        model.addAttribute("localDate", LocalDate.now());
        return "Lecturer/inspectReport";
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
