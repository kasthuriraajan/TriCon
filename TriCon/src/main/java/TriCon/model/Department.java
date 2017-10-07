package TriCon.model;

import org.springframework.data.annotation.Id;

public class Department {

    @Id
    private String id;
    private String UniId;
    private String DeptName;
    private String Email;
    private String ContactNo;
    private String AuthKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniId() {
        return UniId;
    }

    public void setUniId(String uniId) {
        UniId = uniId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String authKey) {
        AuthKey = authKey;
    }
}
