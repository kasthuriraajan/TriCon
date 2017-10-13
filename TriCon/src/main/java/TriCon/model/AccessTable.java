package TriCon.model;

import org.springframework.data.annotation.Id;

public class AccessTable
{
    @Id

    private String id;
    private String KeyPassword;



    public String getKeyPassword() {
        return KeyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        KeyPassword = keyPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
