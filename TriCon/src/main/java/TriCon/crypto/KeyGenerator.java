
/*
 *  Copyright 2017 copyright to triconnect2017@gmail.com
 *
 *
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *
 *    you may not use this file except in compliance with the License.
 *
 *    You may obtain a copy of the License at
 *
 *
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *    See the License for the specific language governing permissions and
 *
 *    limitations under the License
 */

package TriCon.crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.*;

/**
 * The Class KeyGenerator is used to generate both private and public keys.
 *
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class KeyGenerator {

    /**
     * Generate key pairs.
     *
     * @return the key pair
     */
    private KeyPair generateKeyPairs() {

        KeyPair keyPair = null;
        KeyPairGenerator keyGen;
        try
        {
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            keyPair = keyGen.genKeyPair();
            System.out.println("meru");
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return keyPair;
    }

    /**
     * Store key pairs.
     *
     * @param dirPath
     *            the dir path
     */
    public void storeKeyPairs(String dirPath) {
        KeyPair keyPair = generateKeyPairs();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        storeKeys(dirPath + File.separator + "publickey.key", publicKey);
        storeKeys(dirPath + File.separator + "privatekey.key", privateKey);
    }

    /**
     * Store keys.
     *
     * @param filePath
     *            the file path
     * @param key
     *            the key
     */
    private void storeKeys(String filePath, Key key) {
        byte[] keyBytes = key.getEncoded();
        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            out.write(keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
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


}
