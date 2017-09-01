package TriCon.model;

import org.springframework.data.annotation.Id;

public class Department {
    @Id
    private String Id;
    private String Email;
    private String UniId;
    private String University;
    private String DeptId;
    private String Department;
    private String AuthKey;
    private String ContactNo;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUniId() {
        return UniId;
    }

    public void setUniId(String uniId) {
        UniId = uniId;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getDeptId() {
        return DeptId;
    }

    public void setDeptId(String deptId) {
        DeptId = deptId;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String authKey) {
        AuthKey = authKey;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }
}
