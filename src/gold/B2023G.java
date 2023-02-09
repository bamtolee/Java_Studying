package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2023G {

	public static boolean primeCheck(int n)
	{
		if(n == 1) return false;
		for(int i = 2; i * i <= n; i++)
			if(n % i == 0) return false;
		return true;
	}
	
	public static void interestingPrime(int n, int interestingPrimeCheck, int cur, StringBuilder sb)
	{
		if(cur < n)
		{
			for(int i = 0; i <= 9; i++)
			{
				if(primeCheck(interestingPrimeCheck))
					interestingPrime(n, interestingPrimeCheck * 10 + i, cur + 1, sb);
			}
		}
		else
		{
			if(primeCheck(interestingPrimeCheck))
				sb.append(interestingPrimeCheck).append("\n");
		}
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= 9; i++)
		{
			int cur = 1;
			interestingPrime(n, i, cur, sb);
		}
		System.out.println(sb.toString());
	}
}
