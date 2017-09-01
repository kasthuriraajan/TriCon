package TriCon.crypto;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SignGenerator
{
    public static byte[] generateDigitalSignature(String secretInfoStr, String privateKeyPath)
    {
        PrivateKey privateKey = KeyUtil.getStoredPrivateKey(privateKeyPath);
        byte[] signedDataBytes = DigitalSignatureUtil.getDigitalSignature(secretInfoStr, privateKey);
        return signedDataBytes;
    }
    public static boolean verifyDigitalSignature(String secretInfoStr, byte[] signedDataBytes)
    {
        PublicKey publicKey = KeyUtil.getStoredPublicKey("keys" + File.separator + "publickey.key");
        boolean flag = DigitalSignatureUtil.isTextAndSignatureValid(secretInfoStr, signedDataBytes, publicKey);
        return flag;
    }
}
