package TriCon.model;

import org.springframework.data.annotation.Id;

public class Verify
{
    @Id
    private String Id;
    private String PublicKeyPath;
    private String KeyWord;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

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
}
