package TriCon.model;


import org.springframework.data.annotation.Id;

public class Journal
{
    @Id

    private String id;
    private String StuId;
    private String IndId;
    private String LecId;
    private String Company;
    private String Field;
    private String Category;
    private String ContractNo;
    private String From;
    private String To;
    private String Status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuId() {
        return StuId;
    }

    public void setStuId(String stuId) {
        StuId = stuId;
    }

    public String getIndId() {
        return IndId;
    }

    public void setIndId(String indId) {
        IndId = indId;
    }

    public String getLecId() {
        return LecId;
    }

    public void setLecId(String lecId) {
        LecId = lecId;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getContractNo() {
        return ContractNo;
    }

    public void setContractNo(String contractNo) {
        ContractNo = contractNo;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
