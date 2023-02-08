package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B2338B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger bi1 = new BigInteger(br.readLine());
		BigInteger bi2 = new BigInteger(br.readLine());
		
		BigInteger ad = bi1.add(bi2);
		BigInteger su = bi1.subtract(bi2);
		BigInteger mul = bi1.multiply(bi2);
		System.out.println(ad.toString());
		System.out.println(su.toString());
		System.out.println(mul.toString());
	}
}