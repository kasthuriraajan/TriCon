package TriCon.model;

import org.springframework.data.annotation.Id;

public class Keytable {
    @org.springframework.data.annotation.Id



    private String Id;
    private String UserName;
    private String PrivateKey;
    private String PublicKey;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPrivateKey() {
        return PrivateKey;
    }

    public void setPrivateKey(String privateKey) {
        PrivateKey = privateKey;
    }

    public String getPublicKey() {
        return PublicKey;
    }

    public void setPublicKey(String publicKey) {
        PublicKey = publicKey;
    }
}
