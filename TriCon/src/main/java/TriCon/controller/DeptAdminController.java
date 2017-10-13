
/*
 *  Copyright 2017 copyright to triconnect2017@gmail.com
 *
 *
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *
 *    you may not use this file except in compliance with the License.
 *
 *    You may obtain a copy of the License at
 *
 *
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *    See the License for the specific language governing permissions and
 *
 *    limitations under the License
 */

package TriCon.controller;

import TriCon.model.*;
import TriCon.repo.*;
import com.opencsv.CSVReader;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class DeptAdminController {

    private String DeptId = "D001";
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private JournalRepository journalRepository;

    private static String UPLOADED_FOLDER = "G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\static\\dbfiles\\";

    @RequestMapping("/DeptAdmin/approve")
    public String approve(Model model)
    {

        model.addAttribute("journal",journalRepository.findAll());
        return "DeptAdmin/journalApproval";
    }
    @RequestMapping(value ="/DeptAdmin/approve",method = RequestMethod.POST)
    public String approve(HttpServletRequest request, Model model)
    {
        String action=request.getParameter("approve");
        String id=request.getParameter("id");
        String StuId=request.getParameter("StuId");
        String LectId=request.getParameter("LectId");
        String IndId=request.getParameter("IndId");
        String company=request.getParameter("company");
        String from=request.getParameter("from");
        String to=request.getParameter("to");

        Journal j12=journalRepository.findOne(action);

        j12.setId(id);
        j12.setStuId(StuId);
        j12.setLecId(LectId);
        j12.setIndId(IndId);
        j12.setCompany(company);
        j12.setFrom(from);
        j12.setTo(to);


        journalRepository.save(j12);

        model.addAttribute("journal",journalRepository.findAll());
        return "DeptAdmin/journalApproval";
    }

    /*Student*/
    @RequestMapping(value = "/DeptAdmin/student", method = RequestMethod.POST)
    public String students(HttpServletRequest request) {

        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String RegNo = request.getParameter("RegNo");
        String Email = request.getParameter("Email");
        Department department =departmentRepository.findOne(DeptId);

        Student s1 = new Student();

        s1.setId(studentId());
        s1.setFirstName(FirstName);
        s1.setLastName(LastName);
        s1.setRegNo(RegNo);
        s1.setEmail(Email);
        s1.setDeptId(DeptId);
        s1.setUniId(department.getUniId());


        studentRepository.save(s1);
        return "DeptAdmin/student";
    }

    @RequestMapping("/DeptAdmin/student")
    public String students(Model model) {

        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        return "/DeptAdmin/student";
    }

    @RequestMapping(value = "/DeptAdmin/studentBulk", method = RequestMethod.POST)
    public String studentBulk(@RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) {
        Department department =departmentRepository.findOne(DeptId);
        if (file.isEmpty()) {
        System.out.println("Please select a file to upload");
        return "/DeptAdmin/student";
    }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "student.csv");
            Files.write(path, bytes);
            //read csv file using existing uploaded file
            String csvFile = UPLOADED_FOLDER+"student.csv";
            CSVReader reader = null;
            try {
                reader = new CSVReader(new FileReader(csvFile));
                String[] line;
                String[] headerLine = reader.readNext();
                while ((line = reader.readNext()) != null) {
                    Student s2 = new Student();
                    s2.setId(studentId());
                    s2.setFirstName(line[0]);
                    s2.setLastName(line[1] );
                    s2.setRegNo(line[2]);
                    s2.setEmail(line[3]);
                    s2.setDeptId(DeptId);
                    s2.setUniId( department.getUniId());

                    studentRepository.save(s2);
                }
                try{

                    File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\" +
                            "static\\dbfiles\\student.csv");

                    file1.delete();
                  /*  if(file1.delete()){
                        System.out.println(file1.getName() + " is deleted!");
                    }else{
                        System.out.println("Delete operation is failed.");
                    }*/

                }catch(Exception e){

                    e.printStackTrace();

                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "/DeptAdmin/student";
    }

    @RequestMapping("/DeptAdmin/studentDetails")
    public String studentDetails(Model model) {
        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        return "/DeptAdmin/studentDetails";
    }

    /*Lecturer*/
    @RequestMapping(value = "/DeptAdmin/lecturer", method = RequestMethod.POST)
    public String lecturers(HttpServletRequest request) {
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        Department department =departmentRepository.findOne(DeptId);

        Lecturer lec1 = new Lecturer();

        lec1.setId(lecturerId());
        lec1.setFirstName(FirstName);
        lec1.setLastName(LastName);
        lec1.setEmail(Email);
        lec1.setDeptId(DeptId);
        lec1.setUniId(department.getUniId());


        lecturerRepository.save(lec1);
        return "DeptAdmin/lecturer";
    }

    @RequestMapping(value = "/DeptAdmin/lecturerBulk", method = RequestMethod.POST)
    public String lecturerBulk(@RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) {
        Department department =departmentRepository.findOne(DeptId);
        if (file.isEmpty()) {
            System.out.println("Please select a file to upload");
            return "/DeptAdmin/lecturer";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "student.csv");
            Files.write(path, bytes);
            //read csv file using existing uploaded file
            String csvFile = UPLOADED_FOLDER+"student.csv";
            CSVReader reader = null;
            try {
                reader = new CSVReader(new FileReader(csvFile));
                String[] line;
                String[] headerLine = reader.readNext();
                while ((line = reader.readNext()) != null) {
                    Lecturer l2 = new Lecturer();
                    l2.setId(lecturerId());
                    l2.setFirstName(line[0]);
                    l2.setLastName(line[1] );
                    l2.setEmail(line[2]);
                    l2.setDeptId(DeptId);
                    l2.setUniId( department.getUniId());

                    lecturerRepository.save(l2);
                }
                try{

                    File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\" +
                            "static\\dbfiles\\student.csv");

                    file1.delete();
                  /*  if(file1.delete()){
                        System.out.println(file1.getName() + " is deleted!");
                    }else{
                        System.out.println("Delete operation is failed.");
                    }*/

                }catch(Exception e){

                    e.printStackTrace();

                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "/DeptAdmin/lecturer";
    }
    @RequestMapping("/DeptAdmin/lecturer")
    public String lecturers(Model model) {
        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        return "/DeptAdmin/lecturer";
    }

    @RequestMapping("/DeptAdmin/lecturerDetails")
    public String lecturerDetails(Model model) {
        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        return "/DeptAdmin/lecturerDetails";
    }

    /*Industrialist*/
    @RequestMapping(value = "/DeptAdmin/industrialist", method = RequestMethod.POST)
    public String industrialists(HttpServletRequest request) {

        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        String Company = request.getParameter("Company");
        String Designation = request.getParameter("Designation");

        Industrialist ind1 = new Industrialist();

        ind1.setId(indId());
        ind1.setFirstName(FirstName);
        ind1.setLastName(LastName);
        ind1.setCompany(Company);
        ind1.setDesignation(Designation);

        ind1.setEmail(Email);

        industrialistRepository.save(ind1);
        return "DeptAdmin/industrialist";
    }

    @RequestMapping(value = "/DeptAdmin/industrialistBulk", method = RequestMethod.POST)
    public String industrialistBulk(@RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            System.out.println("Please select a file to upload");
            return "/DeptAdmin/industrialist";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "student.csv");
            Files.write(path, bytes);
            //read csv file using existing uploaded file
            String csvFile = UPLOADED_FOLDER+"student.csv";
            CSVReader reader = null;
            try {
                reader = new CSVReader(new FileReader(csvFile));
                String[] line;
                String[] headerLine = reader.readNext();
                while ((line = reader.readNext()) != null) {
                    Industrialist i = new Industrialist();
                    i.setId(indId());
                    i.setFirstName(line[0]);
                    i.setLastName(line[1] );
                    i.setEmail(line[2]);
                    i.setCompany(line[3]);
                    i.setDesignation(line[4]);

                   industrialistRepository.save(i);
                }
                try{

                    File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\" +
                            "static\\dbfiles\\student.csv");

                    file1.delete();
                  /*  if(file1.delete()){
                        System.out.println(file1.getName() + " is deleted!");
                    }else{
                        System.out.println("Delete operation is failed.");
                    }*/

                }catch(Exception e){

                    e.printStackTrace();

                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "/DeptAdmin/industrialist";
    }

    @RequestMapping("/DeptAdmin/industrialist")
    public String industrialists(Model model) {

        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        return "/DeptAdmin/industrialist";
    }

    @RequestMapping("/DeptAdmin/industrialistDetails")
    public String industrialistDetails(Model model) {
        Department department1 = departmentRepository.findOne(DeptId);
        model.addAttribute("department", department1);
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        return "/DeptAdmin/industrialistDetails";
    }

    /*MultiPart file Convert*/
    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File ConvertFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(ConvertFile);
        return ConvertFile;
    }

    public String studentId()
    {
        String Id="S";

        List<Student> list1=studentRepository.findAll();
        int i=0;
        while (i<list1.size())
        {
            i++;
        }
        String s=String.format("%05d",(i+1));
        Id=Id+s;


        return Id;
    }
    public String lecturerId()
    {
        String Id="L";

        List<Lecturer> list1=lecturerRepository.findAll();
        int i=0;
        while (i<list1.size())
        {
            i++;
        }
        String s=String.format("%05d",(i+1));
        Id=Id+s;


        return Id;
    }
    public String indId()
    {
        String Id="I";

        List<Industrialist> list1=industrialistRepository.findAll();
        int i=0;
        while (i<list1.size())
        {
            i++;
        }
        String s=String.format("%05d",(i+1));
        Id=Id+s;


        return Id;
    }
}
