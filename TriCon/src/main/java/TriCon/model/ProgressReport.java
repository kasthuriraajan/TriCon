package TriCon.model;

/**
 * Created by hp on 8/11/2017.
 */
public class ProgressReport {
    private String IndId;
    private String JournalId;
    private String ProgressId;
    private String Authorized_Attendance;
    private String Unauthorized_Attendance;
    private String AttitudeToWork;
    private String Conduct;
    private String IndSign;


    public String getIndId() {
        return IndId;
    }

    public void setIndId(String indId) {
        IndId = indId;
    }

    public String getJournalId() {
        return JournalId;
    }

    public void setJournalId(String journalId) {
        JournalId = journalId;
    }

    public String getProgressId() {
        return ProgressId;
    }

    public void setProgressId(String progressId) {
        ProgressId = progressId;
    }

    public String getAuthorized_Attendance() {
        return Authorized_Attendance;
    }

    public void setAuthorized_Attendance(String authorized_Attendance) {
        Authorized_Attendance = authorized_Attendance;
    }

    public String getUnauthorized_Attendance() {
        return Unauthorized_Attendance;
    }

    public void setUnauthorized_Attendance(String unauthorized_Attendance) {
        Unauthorized_Attendance = unauthorized_Attendance;
    }

    public String getAttitudeToWork() {
        return AttitudeToWork;
    }

    public void setAttitudeToWork(String attitudeToWork) {
        AttitudeToWork = attitudeToWork;
    }

    public String getConduct() {
        return Conduct;
    }

    public void setConduct(String conduct) {
        Conduct = conduct;
    }

    public String getIndSign() {
        return IndSign;
    }

    public void setIndSign(String indSign) {
        IndSign = indSign;
    }
}
