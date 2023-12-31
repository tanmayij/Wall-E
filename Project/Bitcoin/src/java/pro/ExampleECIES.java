import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

import de.flexiprovider.common.ies.IESParameterSpec;
import de.flexiprovider.core.FlexiCoreProvider;
import de.flexiprovider.ec.FlexiECProvider;
import de.flexiprovider.ec.parameters.CurveParams;
import de.flexiprovider.ec.parameters.CurveRegistry.BrainpoolP160r1;

public class ExampleECIES {

    public static void main(String[] args) throws Exception {

	Security.addProvider(new FlexiCoreProvider());
	Security.addProvider(new FlexiECProvider());

	KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECIES", "FlexiEC");

	CurveParams ecParams = new BrainpoolP160r1();

	kpg.initialize(ecParams, new SecureRandom());
	KeyPair keyPair = kpg.generateKeyPair();
	PublicKey pubKey = keyPair.getPublic();
	PrivateKey privKey = keyPair.getPrivate();

	// Encrypt

	Cipher cipher = Cipher.getInstance("ECIES", "FlexiEC");

	IESParameterSpec iesParams = new IESParameterSpec("AES128_CBC",
		"HmacSHA1", null, null);

	cipher.init(Cipher.ENCRYPT_MODE, pubKey, iesParams);

	String cleartextFile = "cleartext.txt";
	String ciphertextFile = "ciphertextECIES.txt";

	byte[] block = new byte[64];
	FileInputStream fis = new FileInputStream(cleartextFile);
	FileOutputStream fos = new FileOutputStream(ciphertextFile);
	CipherOutputStream cos = new CipherOutputStream(fos, cipher);

	int i;
	while ((i = fis.read(block)) != -1) {
	    cos.write(block, 0, i);
	}
	cos.close();

	// Decrypt

	String cleartextAgainFile = "cleartextAgainECIES.txt";

	cipher.init(Cipher.DECRYPT_MODE, privKey, iesParams);

	fis = new FileInputStream(ciphertextFile);
	CipherInputStream cis = new CipherInputStream(fis, cipher);
	fos = new FileOutputStream(cleartextAgainFile);

	while ((i = cis.read(block)) != -1) {
	    fos.write(block, 0, i);
	}
	fos.close();
    }

}
