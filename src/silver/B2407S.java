package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		BigInteger ret = new BigInteger("1");
		
		int cnt = 1;
		while(true)
		{
			ret = ret.multiply(n);
			ret = ret.divide(BigInteger.valueOf(cnt));
			if(cnt == m.intValue()) break;
			cnt++;
			n = n.subtract(BigInteger.valueOf(1));
		}
		
		System.out.println(ret.toString());
	}
}
