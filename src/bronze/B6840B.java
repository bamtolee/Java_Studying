package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6840B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bearOne = Integer.parseInt(br.readLine());
		int bearTwo = Integer.parseInt(br.readLine());
		int bearThree = Integer.parseInt(br.readLine());
		int ret;
		
		if(bearOne > bearTwo)
		{
			if(bearTwo > bearThree) ret = bearTwo;
			else ret = bearThree > bearOne ? bearOne : bearThree;
		}
		else
		{
			if(bearTwo < bearThree) ret = bearTwo;
			else ret = bearThree < bearOne ? bearOne : bearThree;
		}
		System.out.println(ret);
	}
}
