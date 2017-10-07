package TriCon.model;

import org.springframework.data.annotation.Id;

import java.security.Key;

public class KeyTable {
    @Id



    private String Id;
    private String UserName;
    private Key PrivateKey;
    private Key PublicKey;

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

    public Key getPrivateKey() {
        return PrivateKey;
    }

    public void setPrivateKey(Key privateKey) {
        PrivateKey = privateKey;
    }

    public Key getPublicKey() {
        return PublicKey;
    }

    public void setPublicKey(Key publicKey) {
        PublicKey = publicKey;
    }
}
