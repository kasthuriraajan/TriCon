package TriCon.model;

import org.springframework.data.annotation.Id;

public class Industrialist {


    @Id
    private String id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Company;
    private String CompanyAddress;
    private String Designation;
    private String MobileNo;
    private String TPNo;
    private String Linkedin;
    private String Twitter;
    private String GitHub;
    private String Facebook;
    private String Blog;
    private String Signature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getTPNo() {
        return TPNo;
    }

    public void setTPNo(String TPNo) {
        this.TPNo = TPNo;
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

    public String getGitHub() {
        return GitHub;
    }

    public void setGitHub(String gitHub) {
        GitHub = gitHub;
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

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
