package TriCon.model;
import org.springframework.data.annotation.Id;
public class Student {
    @Id
    private String Id;
    private String FirstName;
    private String LastName;
    private String RegNo;
    private String DeptNo;
    private String DeptName;
    private String University;
    private String Email;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(String deptNo) {
        DeptNo = deptNo;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

