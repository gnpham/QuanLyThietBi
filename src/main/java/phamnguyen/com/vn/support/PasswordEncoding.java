package phamnguyen.com.vn.support;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class PasswordEncoding {
	public static String hashSHA256(String input){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(input.getBytes("UTF-8"));
			byte[] digest = md.digest();
			return DatatypeConverter.printHexBinary(digest);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
