package TriCon.controller;


import TriCon.crypto.KeyGenerator;
import TriCon.crypto.SignGenerator;
import TriCon.model.Keytable;
import TriCon.repo.KeytableRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.io.File;
import java.util.Map;

import static TriCon.crypto.SignGenerator.generateDigitalSignature;
import static TriCon.crypto.SignGenerator.verifyDigitalSignature;

@Controller
public class SignController {

    @Autowired
    private KeytableRepository keyRepository;

    @RequestMapping("/ss")
    public String user()
    {
        return "home";
    }

    @RequestMapping(value="/ss", method = RequestMethod.POST)
    public String welcome(HttpServletRequest request)
    {

        KeyGenerator keygen1=new KeyGenerator();
       String UserName=request.getParameter("username");
       String Code =request.getParameter("password");
       String Id="0001";
       System.out.println(UserName+"'"+Id);
        /* String publickey=keygen1.
        System.out.println(publickey);
        System.out.println(privatekey);*/
         System.out.println("Private key and Public Keys generated successfully...");
        return "home";
    }

    @RequestMapping("/verify")
    public String user1()
    {
        return "fragments/verification";
    }

    @RequestMapping(value="/verify", method = RequestMethod.POST)
    public String welldone(HttpServletRequest request)
    {
        String NewCode =request.getParameter("code");
        SignGenerator signgen=new SignGenerator();
        String privateKeyPath = "keys" + File.separator + "privatekey.key";
        // Use Private key and Secret message to generate digital signature
        byte[] signedBytes = generateDigitalSignature(NewCode, privateKeyPath);
        String digitalSignatureStr = new String(signedBytes);
        System.out.println("Digital Signature : \n" + digitalSignatureStr);
        // Verify Digital Signature
        boolean flag = verifyDigitalSignature(NewCode, signedBytes);
        System.out.println("Digital Signature Verification Status : " + flag);

        return "fragments/verification";
    }

    @RequestMapping("/headers")
    public String header(Map<String, Object> model)
    {
        return "fragments/header";
    }

    @RequestMapping("/footers")
    public String footer(Map<String, Object> model)
    {

        return "fragments/footer";
    }
}



