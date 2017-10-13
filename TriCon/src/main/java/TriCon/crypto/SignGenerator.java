package TriCon.crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SignGenerator {
    public static byte[] generateDigitalSignature(String secretInfoStr, String privateKeyPath) {
        PrivateKey privateKey = KeyUtil.getStoredPrivateKey(privateKeyPath);
        byte[] signedDataBytes = DigitalSignatureUtil.getDigitalSignature(secretInfoStr, privateKey);
        return signedDataBytes;
    }

    public static boolean verifyDigitalSignature(String secretInfoStr, byte[] signedDataBytes, String path) {
        PublicKey publicKey = KeyUtil.getStoredPublicKey(path);
        boolean flag = DigitalSignatureUtil.isTextAndSignatureValid(secretInfoStr, signedDataBytes, publicKey);
        return flag;
    }

}
