package TriCon.model;

import org.springframework.data.annotation.Id;

public class Lecturer
{
    @Id
    private String lectId;
    private String LastName;
    private String Email;
    private String Address;
    private String University;
    private String DeptId;
    private String Linkedin;
    private String Twitter;
    private String Github;
    private String Facebook;
    private String Blog;
    private int MobileNo;
    private int TeleNo;
    private String LectSign;
    private String FirstName;


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
        LastName = lastName;
    }
    public String getLectId() {
        return lectId;
    }

    public void setLectId(String lectId) {
        this.lectId = lectId;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getLinkedin() {
        return Linkedin;
    }

    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getGithub() {
        return Github;
    }

    public void setGithub(String github) {
        Github = github;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getBlog() {
        return Blog;
    }

    public void setBlog(String blog) {
        Blog = blog;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }

    public int getTeleNo() {
        return TeleNo;
    }

    public void setTeleNo(int teleNo) {
        TeleNo = teleNo;
    }

    public String getLectSign() {
        return LectSign;
    }

    public void setLectSign(String lectSign) {
        LectSign = lectSign;
    }
}
