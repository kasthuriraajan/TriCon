package TriCon.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/**
 * The Class DigitalSignatureUtil is used to generate and verify digital
 * signature.
 *
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class DigitalSignatureUtil
{

    /** The Constant ALGORITHM. */
    private static final String ALGORITHM = "MD5withRSA";

    /**
     * Gets the digital signature.
     *
     * @param text
     *            the text
     * @param privateKey
     *            the private key
     * @return the digital signature
     */
    public static byte[] getDigitalSignature(String text, PrivateKey privateKey)
    {

        byte[] signedData = null;
        byte[] textBuffer = null;

        //text = "Hello world";

        try
        {
            textBuffer = text.getBytes("UTF8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        Signature sig = null;
        try
        {
            sig = Signature.getInstance(ALGORITHM);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        try
        {
            sig.initSign(privateKey);
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        try
        {
            sig.update(textBuffer);
        }
        catch (SignatureException e)
        {
            e.printStackTrace();
        }

        try
        {
            signedData = sig.sign();
        }
        catch (SignatureException e)
        {
            e.printStackTrace();
        }
        return signedData;
    }

    /**
     * Checks if is text and signature valid.
     *
     * @param originalContents
     *            the original contents
     * @param signedData
     *            the signed data
     * @param publicKey
     *            the public key
     * @return true, if is text and signature valid
     */
    public static boolean isTextAndSignatureValid(String originalContents, byte[] signedData, PublicKey publicKey)
    {
        boolean isSignOk = false;
        Signature sig = null;
        try
        {
            sig = Signature.getInstance(ALGORITHM);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        try
        {
            sig.initVerify(publicKey);
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }

        byte[] sigBuffer = null;
        try
        {
            sigBuffer = originalContents.getBytes("UTF8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        try
        {
            sig.update(sigBuffer);
            isSignOk = sig.verify(signedData);
        }
        catch (SignatureException e)
        {
            e.printStackTrace();
        }
        return isSignOk;
    }
}
