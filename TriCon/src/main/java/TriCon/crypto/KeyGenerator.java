package TriCon.crypto;

import TriCon.model.Keytable;
import TriCon.repo.KeytableRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
	@Autowired
	private KeytableRepository keytableRepository;
	public void storeKeyPairs() {

		KeyPair keyPair = generateKeyPairs();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		storeKeys("kk","12");
		/*storeKeys(dirPath + File.separator + "publickey.key", publicKey);
		storeKeys(dirPath + File.separator + "privatekey.key", privateKey);*/
	}
	private void storeKeys(String UserName, String UserId/*,Key pubkey,Key prikey*/){
		Keytable key1=new Keytable();
		key1.setId(UserId);
		key1.setUserName(UserName);
		/*key1.setPublicKey(pubkey);
		key1.setPrivateKey(prikey);*/
		keytableRepository.save(key1);
	}

	/**
	 * Store keys.
	 *
	 * @param filePath
	 *            the file path
	 * @param key
	 *            the key
	 */
/*	private void storeKeys(String filePath, Key key) {
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
	}*/

}
