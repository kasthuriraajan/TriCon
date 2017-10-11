package TriCon.model;

import org.springframework.data.annotation.Id;

public class KeyTable {
    @Id



    private String Id;
    private String UserName;
    private String PrivateKeyPath;
    private String PublicKeyPath;
    private String KeyWord;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPrivateKeyPath() {
        return PrivateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        PrivateKeyPath = privateKeyPath;
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
