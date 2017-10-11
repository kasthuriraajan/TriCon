package TriCon.model;

import org.springframework.data.annotation.Id;

public class AccessTable
{
    @Id

    private String Id;
    private String KeyPassword;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getKeyPassword() {
        return KeyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        KeyPassword = keyPassword;
    }
}
