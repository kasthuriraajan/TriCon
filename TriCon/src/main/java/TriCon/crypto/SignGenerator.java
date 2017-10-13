
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
