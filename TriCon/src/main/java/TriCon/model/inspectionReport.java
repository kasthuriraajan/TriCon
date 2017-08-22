package TriCon.model;

public class inspectionReport
{
    private String inspectionlId;
    private String journalId;
    private String lecturerId;
    private String date;
    private String review ;
    private String lecturerSignature;

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getInspectionlId() {
        return inspectionlId;
    }

    public void setInspectionlId(String inspectionlId) {
        this.inspectionlId = inspectionlId;
    }

    public String getLecturerSignature() {
        return lecturerSignature;
    }

    public void setLecturerSignature(String lecturerSignature) {
        this.lecturerSignature = lecturerSignature;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
