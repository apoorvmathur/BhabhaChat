import java.io.IOException;
import java.util.Base64;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class Test {
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		
		KeyPair kp = Encryption.generateKey();
		String key = Base64.getEncoder().encodeToString(kp.getPublic().getEncoded());
		
		PubKey pubKey = new PubKey(key, "Dummy Address", "Mogambo");
		Beacon.sendBeacon(pubKey);
	}
}

