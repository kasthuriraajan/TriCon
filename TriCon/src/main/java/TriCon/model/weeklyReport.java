package TriCon.model;

import org.springframework.data.annotation.Id;

public class weeklyReport
{
    @Id

    private String Id;
    private String JournalId;
    private String From;
    private String To;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;
    private String Sunday;
    private String Summary;
    private String Attachment;
    private String Review;
    private String Remark;
    private String Status;
    private String StuSign;
    private String LectSign;
    private String IndSign;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getJournalId() {
        return JournalId;
    }

    public void setJournalId(String journalId) {
        JournalId = journalId;
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

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String wednesday) {
        Wednesday = wednesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getAttachment() {
        return Attachment;
    }

    public void setAttachment(String attachment) {
        Attachment = attachment;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStuSign() {
        return StuSign;
    }

    public void setStuSign(String stuSign) {
        StuSign = stuSign;
    }

    public String getLectSign() {
        return LectSign;
    }

    public void setLectSign(String lectSign) {
        LectSign = lectSign;
    }

    public String getIndSign() {
        return IndSign;
    }

    public void setIndSign(String indSign) {
        IndSign = indSign;
    }
}
