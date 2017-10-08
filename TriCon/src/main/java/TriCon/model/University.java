package TriCon.model;


import org.springframework.data.annotation.Id;

public class University {
    @Id

    private String id;
    private String UniName;
    private String ShortCut;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniName() {
        return UniName;
    }

    public void setUniName(String uniName) {
        UniName = uniName;
    }

    public String getShortCut() {
        return ShortCut;
    }

    public void setShortCut(String shortCut) {
        ShortCut = shortCut;
    }
}

