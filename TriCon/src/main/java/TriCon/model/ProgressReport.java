package TriCon.model;


import org.springframework.data.annotation.Id;

public class ProgressReport {
    @Id

    private String Id;
    private String IndId;
    private String AuthLeave;
    private String UnAuthLeave;
    private String Attitude;
    private String Conduct;
    private String IndSign;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIndId() {
        return IndId;
    }

    public void setIndId(String indId) {
        IndId = indId;
    }

    public String getAuthLeave() {
        return AuthLeave;
    }

    public void setAuthLeave(String authLeave) {
        AuthLeave = authLeave;
    }

    public String getUnAuthLeave() {
        return UnAuthLeave;
    }

    public void setUnAuthLeave(String unAuthLeave) {
        UnAuthLeave = unAuthLeave;
    }

    public String getAttitude() {
        return Attitude;
    }

    public void setAttitude(String attitude) {
        Attitude = attitude;
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

