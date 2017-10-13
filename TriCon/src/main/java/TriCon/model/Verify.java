package TriCon.model;

import org.springframework.data.annotation.Id;

public class Verify
{
    @Id
    private String id;
    private String PublicKeyPath;
    private String KeyWord;



    public String getPublicKeyPath() {
        return PublicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        PublicKeyPath = publicKeyPath;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
