package TriCon.model;

import org.hibernate.validator.constraints.Email;

public class Student
{
    @Email
    private String email;
    private String studentId;
    private String departmentNo;
    private String registrationNo;
    private String firstName;
    private String lastName;
    private int mobileNo;
    private int telephoneNo;
    private String address;
    private String linkedin;
    private String twitter;
    private String github;
    private String facebook;
    private String blog;
    private String notificationId;
    private String studentSignature;

    public String getId()
    {
        return email;
    }

    public void setId(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getMobileNo()
    {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo)
    {
        this.mobileNo = mobileNo;
    }

    public int getTelephoneNo()
    {
        return telephoneNo;
    }

    public void setTelephoneNo(int telephoneNo)
    {
        this.telephoneNo = telephoneNo;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getLinkedin()
    {
        return linkedin;
    }

    public void setLinkedin(String linkedin)
    {
        this.linkedin = linkedin;
    }

    public String getTwitter()
    {
        return twitter;
    }

    public void setTwitter(String twitter)
    {
        this.twitter = twitter;
    }

    public String getGithub()
    {
        return github;
    }

    public void setGithub(String github)
    {
        this.github = github;
    }

    public String getFacebook()
    {
        return facebook;
    }

    public void setFacebook(String facebook)
    {
        this.facebook = facebook;
    }

    public String getBlog()
    {
        return blog;
    }

    public void setBlog(String blog)
    {
        this.blog = blog;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentSignature() {
        return studentSignature;
    }

    public void setStudentSignature(String studentSignature) {
        this.studentSignature = studentSignature;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
}
