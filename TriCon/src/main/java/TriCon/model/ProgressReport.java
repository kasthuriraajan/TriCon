package TriCon.model;

/**
 * Created by hp on 8/11/2017.
 */
public class ProgressReport {
    private String industrialistId;
    private String journalId;
    private String progressId;
    private String authorized_Attendance;
    private String unauthorized_Attendance;
    private String attitudeToWork;
    private String conduct;
    private String industrialistSignature;



    public String getIndustrialistId() {
        return industrialistId;
    }

    public void setIndustrialistId(String industrialistId) {
        this.industrialistId = industrialistId;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public String getAuthorized_Attendance() {
        return authorized_Attendance;
    }

    public void setAuthorized_Attendance(String authorized_Attendance) {
        this.authorized_Attendance = authorized_Attendance;
    }

    public String getUnauthorized_Attendance() {
        return unauthorized_Attendance;
    }

    public void setUnauthorized_Attendance(String unauthorized_Attendance) {
        this.unauthorized_Attendance = unauthorized_Attendance;
    }

    public String getAttitudeToWork() {
        return attitudeToWork;
    }

    public void setAttitudeToWork(String attitudeToWork) {
        this.attitudeToWork = attitudeToWork;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getIndustrialistSignature() {
        return industrialistSignature;
    }

    public void setIndustrialistSignature(String industrialistSignature) {
        this.industrialistSignature = industrialistSignature;
    }
}
