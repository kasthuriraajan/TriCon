package TriCon.controller;


import TriCon.crypto.KeyGenerator;
import TriCon.crypto.SignGenerator;
import TriCon.repo.KeyTableRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

import static TriCon.crypto.SignGenerator.generateDigitalSignature;
import static TriCon.crypto.SignGenerator.verifyDigitalSignature;

@Controller
public class SignController {

    @Autowired
    private KeyTableRepository keyRepository;

    @RequestMapping("/ss")
    public String users() {
        return "home";
    }

    @RequestMapping(value = "/ss", method = RequestMethod.POST)
    public String welcome(HttpServletRequest request) {

        KeyGenerator keygen1 = new KeyGenerator();
        String UserName = request.getParameter("username");
        String Code = request.getParameter("password");
        String Id = "0001";
        System.out.println(UserName + "'" + Id);
        /* String publickey=keygen1.
        System.out.println(publickey);
        System.out.println(privatekey);*/
        System.out.println("Private key and Public Keys generated successfully...");
        return "home";
    }

    @RequestMapping("/verify")
    public String user1() {
        return "Fragments/verification";
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public String wellDone(HttpServletRequest request) {
        String NewCode = request.getParameter("code");
        SignGenerator signgen = new SignGenerator();
        String privateKeyPath = "keys" + File.separator + "privatekey.key";
        // Use Private key and Secret message to generate digital signature
        byte[] signedBytes = generateDigitalSignature(NewCode, privateKeyPath);
        String digitalSignatureStr = new String(signedBytes);
        System.out.println("Digital Signature : \n" + digitalSignatureStr);
        // Verify Digital Signature
        boolean flag = verifyDigitalSignature(NewCode, signedBytes);
        System.out.println("Digital Signature Verification Status : " + flag);

        return "Fragments/verification";
    }

    @RequestMapping("/headers")
    public String headers() {
        return "Fragments/header";
    }

    @RequestMapping("/footers")
    public String footers() {

        return "Fragments/footer";
    }
}



