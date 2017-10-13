package TriCon.controller;


//import TriCon.crypto.KeyGenerator;

import TriCon.crypto.KeyUtil;
import TriCon.crypto.SignGenerator;
import TriCon.model.AccessTable;
import TriCon.model.KeyTable;
import TriCon.model.User;
import TriCon.model.Verify;
import TriCon.repo.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.*;
import java.util.List;
import java.util.Map;

import static TriCon.crypto.SignGenerator.generateDigitalSignature;
//import static TriCon.crypto.SignGenerator.verifyDigitalSignature;

@Controller
public class SignController {

    @Autowired
    private KeyTableRepository keyTableRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private IndustrialistRepository industrialistRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private WeeklyReportRepository weeklyReportRepository;
    @Autowired
    private AccessTableRepository accessTableRepository;
    @Autowired
    private VerifyRepository verifyRepository;



    private KeyPair generateKeyPairs() {

        KeyPair keyPair = null;
        KeyPairGenerator keyGen;
        try
        {
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            keyPair = keyGen.genKeyPair();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return keyPair;
    }


    public void storeKeyPairs(String dirPath,String keypass, String keyword)
    {
        String userId="1";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                userId=user.get(i).getId();
            }
        }
        KeyPair keyPair = generateKeyPairs();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String privateKeyPath = dirPath + File.separator +"privatekey.key";
        String publicKeyPath = dirPath + File.separator +"publickey.key";

        KeyTable table1 = new KeyTable();
        table1.setId(userId);
        table1.setPrivateKeyPath(privateKeyPath);
        table1.setPublicKeyPath(publicKeyPath);
        table1.setKeyWord(keyword);
        keyTableRepository.save(table1);

        AccessTable a1 = new AccessTable();
        a1.setId(userId);
        a1.setKeyPassword(keypass);
        accessTableRepository.save(a1);

        Verify v1 = new Verify();
        v1.setId(userId);
        v1.setPublicKeyPath(publicKeyPath);
        v1.setKeyWord(keyword);
        verifyRepository.save(v1);

        storeKeys(publicKeyPath, publicKey);
        storeKeys(privateKeyPath, privateKey);
        System.out.println("Public key"+publicKey);
        System.out.println("Private key"+privateKey);
    }

    private void storeKeys(String filePath, Key key) {
        byte[] keyBytes = key.getEncoded();
        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            out.write(keyBytes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }

    private void storeKey(String filePath, byte[] keyByte)
    {
        byte[] keyBytes = keyByte;
        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            out.write(keyBytes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }


    @RequestMapping("/Stu/generate")
    public String signature(Map<String, Object> model)
    {
        return "Student/Index";
    }

    @RequestMapping(value="/Stu/generate", method = RequestMethod.POST)
    public String welcome(HttpServletRequest request, Model model)
    {
        String direct="1";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                direct=user.get(i).getId();
            }
        }
        File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\keys\\"+direct);
        String path = "G:\\GP2git\\TriCon\\TriCon\\keys\\";
        if (!file1.exists())
        {
            if (file1.mkdir())
            {
                System.out.println("Directory is created!");
            }
            else
            {
                System.out.println("Failed to create directory!");
            }
        }
        String Code=request.getParameter("SecreteCode");
        String ConfirmCode =request.getParameter("ConfirmCode");
        String KeyPassword=request.getParameter("KeyPassword");
        String ConfirmKey =request.getParameter("ConfirmKeyPassword");

        if (Code.equals(ConfirmCode) && KeyPassword.equals(ConfirmKey))
        {
            storeKeyPairs("keys\\"+direct,Code,KeyPassword);

            SignGenerator signgen=new SignGenerator();
            String privateKeyPath = "keys\\"+direct + File.separator +"privatekey.key";
            // Use Private key and Secret message to generate digital signature
            System.out.println(privateKeyPath);
            byte[] signedBytes = generateDigitalSignature(Code, privateKeyPath);
            String dirPath = "keys\\"+direct+File.separator+"stuSign.key";
            storeKey(dirPath , signedBytes);
            String digitalSignatureStr = new String(signedBytes);
            System.out.println("Digital Signature : \n" + digitalSignatureStr);

            String message = "Private key and Public Keys generated successfully...";  //assign the message
            model.addAttribute("message", message); // send the message

            System.out.println("Private key and Public Keys generated successfully...");
        }
        else
        {
            System.out.println("Codes are mismatching!");
            //alert("Codes are mismatching!");
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("users", studentRepository.findOne(direct));
        model.addAttribute("student", studentRepository.findAll());
        return "Student/index";
    }


    @RequestMapping("/Lec/generate")
    public String lecKey(Map<String, Object> model)
    {
        return "lecturer/generate";
    }

    @RequestMapping(value="/Lec/generate", method = RequestMethod.POST)
    public String genKey(HttpServletRequest request, Model model)
    {
        String direct="11";
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();

        String users1 = auth.getName();
        List<User> user = userRepository.findAll();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(users1)) {
                direct=user.get(i).getId();
            }
        }
        File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\keys\\"+direct);
        String path = "G:\\GP2git\\TriCon\\TriCon\\keys\\";
        if (!file1.exists())
        {
            if (file1.mkdir())
            {
                System.out.println("Directory is created!");
            }
            else
            {
                System.out.println("Failed to create directory!");
            }
        }
        String Code=request.getParameter("SecreteCode");
        String ConfirmCode =request.getParameter("ConfirmCode");
        String KeyPassword=request.getParameter("KeyPassword");
        String ConfirmKey =request.getParameter("ConfirmKeyPassword");

        if (Code.equals(ConfirmCode) && KeyPassword.equals(ConfirmKey))
        {
            storeKeyPairs("keys\\"+direct,Code,KeyPassword);

            SignGenerator signgen=new SignGenerator();
            String privateKeyPath = "keys\\"+direct + File.separator +"privatekey.key";
            // Use Private key and Secret message to generate digital signature
            System.out.println(privateKeyPath);
            byte[] signedBytes = generateDigitalSignature(Code, privateKeyPath);
            String dirPath = "keys\\"+direct+File.separator+"stuSign.key";
            storeKey(dirPath , signedBytes);
            String digitalSignatureStr = new String(signedBytes);
            System.out.println("Digital Signature : \n" + digitalSignatureStr);

            String message = "Private key and Public Keys generated successfully...";  //assign the message
            model.addAttribute("message", message); // send the message

            System.out.println("Private key and Public Keys generated successfully...");
        }
        else
        {
            System.out.println("Codes are mismatching!");
            //alert("Codes are mismatching!");
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", lecturerRepository.findOne(direct));
        return "Lecturer/index";
    }

    @RequestMapping("/Ind/generate")
    public String indKey(Map<String, Object> model)
    {
        return "Industrialist/generate";
    }

    @RequestMapping(value="/Ind/generate", method = RequestMethod.POST)
    public String genIndKey(HttpServletRequest request, Model model)
    {
        String direct="1";
            Authentication auth
                    = SecurityContextHolder.getContext().getAuthentication();

            String users1 = auth.getName();
            List<User> user = userRepository.findAll();
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getEmail().equals(users1)) {
                    direct=user.get(i).getId();
                }
            }

        File file1 = new File("G:\\GP2git\\TriCon\\TriCon\\keys\\"+direct);
        String path = "G:\\GP2git\\TriCon\\TriCon\\keys\\";
        if (!file1.exists())
        {
            if (file1.mkdir())
            {
                System.out.println("Directory is created!");
            }
            else
            {
                System.out.println("Failed to create directory!");
            }
        }
        String Code=request.getParameter("SecreteCode");
        String ConfirmCode =request.getParameter("ConfirmCode");
        String KeyPassword=request.getParameter("KeyPassword");
        String ConfirmKey =request.getParameter("ConfirmKeyPassword");

        if (Code.equals(ConfirmCode) && KeyPassword.equals(ConfirmKey))
        {
            storeKeyPairs("keys\\"+direct,Code,KeyPassword);

            SignGenerator signgen=new SignGenerator();
            String privateKeyPath = "keys\\"+direct + File.separator +"privatekey.key";
            // Use Private key and Secret message to generate digital signature
            System.out.println(privateKeyPath);
            byte[] signedBytes = generateDigitalSignature(Code, privateKeyPath);
            String dirPath = "keys\\"+direct+File.separator+"stuSign.key";
            storeKey(dirPath , signedBytes);
            String digitalSignatureStr = new String(signedBytes);
            System.out.println("Digital Signature : \n" + digitalSignatureStr);

            String message = "Private key and Public Keys generated successfully...";  //assign the message
            model.addAttribute("message", message); // send the message

            System.out.println("Private key and Public Keys generated successfully...");
        }
        else
        {
            System.out.println("Codes are mismatching!");
            //alert("Codes are mismatching!");
        }
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("university", universityRepository.findAll());
        model.addAttribute("industrialist", industrialistRepository.findAll());
        model.addAttribute("student", studentRepository.findAll());
        model.addAttribute("lecturer", lecturerRepository.findAll());
        model.addAttribute("users", industrialistRepository.findOne(direct));
        return "Industrialist/index";

    }

  /*  @RequestMapping("/Stu/summary")
    public String summary(Map<String, Object> model)
    {
        return "Student/summary";
    }

    @RequestMapping(value="/Stu/summary",method = RequestMethod.POST)
    public String signSummary(HttpServletRequest request,Model model)
    {
        String KeyPass = request.getParameter("KeyPassword");
        String file = request.getParameter("file");
        String summary = request.getParameter("summary");
        String keyword = request.getParameter("keyword");
        AccessTable a2 = new AccessTable();
        String direct="S00251";
        if(KeyPass.equals(a2.getKeyPassword()))
        {
            String stuSignPath = "keys\\"+direct + File.separator + "stuSign.key";
            byte[] signedBytes = KeyUtil.getStoredSign(stuSignPath);
            System.out.println(signedBytes);
            //boolean flag = verifyDigitalSignature(keyword, signedBytes);
            //System.out.println("Digital Signature Verification Status : " + flag);

//            WeeklyReport w1 = new WeeklyReport();
//            w1.setAttachment(file);
//            w1.setSummary(summary);
//            w1.setStudentSignature(flag);
//            weeklyReportRepository.save(w1);
        }
        return "Student/summary";
    }*/



}



