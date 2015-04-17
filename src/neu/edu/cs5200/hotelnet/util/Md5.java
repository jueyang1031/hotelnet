package neu.edu.cs5200.hotelnet.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Md5 {

	@Test
	public void generateSig() {
		String apikey = "2ub12hrr2hn7lt2qklvhniq0mt";
		String secret = "sjujeleod1fg";
		String sig = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			long timeInSeconds = (System.currentTimeMillis() / 1000);
			String input = apikey + secret + timeInSeconds;
			md.update(input.getBytes());
			sig = String.format("%032x", new BigInteger(1, md.digest()));
			System.out.println(sig);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return sig;
	}
}
