package TriCon.controller;

import TriCon.model.Industrialist;
import TriCon.model.Lecturer;
import TriCon.model.Student;
import TriCon.repo.IndustrialistRepository;
import TriCon.repo.LecturerRepository;
import TriCon.repo.StudentRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
@Controller
public class DeptAdminController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;

    private static String UPLOADED_FOLDER = "G:\\GP2git\\TriCon\\TriCon\\src\\main\\resources\\static\\dbfiles\\";
    @RequestMapping(value="/DeptAdmin/student", method = RequestMethod.POST)
    public String student(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String RegNo = request.getParameter("RegNo");
        String DeptNo= request.getParameter("DeptNo");
        String DeptName = request.getParameter("DeptName");
        String University = request.getParameter("University");
        String Email = request.getParameter("Email");

        Student s1 = new Student();
        s1.setId(Id);
        s1.setFirstName(FirstName);
        s1.setLastName(LastName );
        s1.setRegNo(RegNo);
        s1.setDeptNo(DeptNo);
        s1.setDeptName(DeptName);
        s1.setUniversity(University);
        s1.setEmail(Email);
        studentRepository.save(s1);
        return "DeptAdmin/student";
    }
    @RequestMapping("/DeptAdmin/student")
    public String student(Map<String, Object> model) {
        return "/DeptAdmin/student";
    }
    @RequestMapping(value="/DeptAdmin/studentbulk", method= RequestMethod.POST)
    public String studentbulkadd(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes)
    {if (file.isEmpty()) {
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
                    s2.setId(line[0]);
                    s2.setFirstName(line[1]);
                    s2.setLastName(line[2] );
                    s2.setRegNo(line[3]);
                    s2.setDeptNo(line[4]);
                    s2.setDeptName(line[5]);
                    s2.setUniversity(line[6]);
                    s2.setEmail(line[7]);
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

    @RequestMapping("/DeptAdmin/studentdetails")
    public String studentdetails(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "/DeptAdmin/studentdetails";
    }
    @RequestMapping(value="/DeptAdmin/lecturer", method = RequestMethod.POST)
    public String lecturer(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String LectId = request.getParameter("LectId");
        String DeptId= request.getParameter("DeptId");
        String DeptName = request.getParameter("DeptName");
        String University = request.getParameter("University");
        String Email = request.getParameter("Email");

        Lecturer lec1 = new Lecturer();
        lec1.setId(Id);
        lec1.setFirstName(FirstName);
        lec1.setLastName(LastName);
        lec1.setLectId(LectId);
        lec1.setDeptId(DeptId );
        lec1.setDeptName(DeptName);
        lec1.setUniversity(University );
        lec1.setEmail(Email );

        lecturerRepository.save(lec1);
        return "DeptAdmin/lecturer";
    }
    @RequestMapping("/DeptAdmin/lecturer")
    public String lecturer(Map<String, Object> model) {
        return "/DeptAdmin/lecturer";
    }
    @RequestMapping("/DeptAdmin/lecturerdetails")
    public String lecturerdetails(Model model) {
        model.addAttribute("lecturer", lecturerRepository.findAll());
        return "/DeptAdmin/lecturerdetails";
    }
    @RequestMapping(value="/DeptAdmin/industrialist", method = RequestMethod.POST)
    public String industrialist(HttpServletRequest request) {
        String Id = request.getParameter("Id");
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String IndId = request.getParameter("IndId");
        String Company= request.getParameter("Company");
        String Designation = request.getParameter("Designation");

        String Email = request.getParameter("Email");

        Industrialist ind1 = new Industrialist();
        ind1.setId(Id);
        ind1.setFirstName(FirstName);
        ind1.setLastName(LastName );
        ind1.setIndId(IndId);
        ind1.setCompany(Company );
        ind1.setDesignation(Designation);

        ind1.setEmail(Email );

        industrialistRepository.save(ind1);
        return "DeptAdmin/industrialist";
    }
    @RequestMapping("/DeptAdmin/industrialist")
    public String industrialist(Map<String, Object> model) {
        return "/DeptAdmin/industrialist";
    }
    @RequestMapping("/DeptAdmin/industrialistdetails")
    public String industrialistdetails(Model model) {
        model.addAttribute("industrialist", industrialistRepository.findAll());
        return "/DeptAdmin/industrialistdetails";
    }

    /*public static void main(String[] args) {

        String csvFile = "/Users/mkyong/csv/country3.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Country [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
