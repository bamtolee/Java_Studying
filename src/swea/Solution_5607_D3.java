package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_D3 {

	static long mod = 1234567891;
	static long factorial[] = new long[1000001];
	
	static long dqPow(long a, long b)
	{
		long i = 1;
		while(b > 0)
		{
			if((b & 1) == 1)
			{
				i *= a;
				i %= mod;
			}
			a *= a;
			a %= mod;
			b = b >> 1;
		}
		return i;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		factorial[1] = 1;
		for(int i = 2; i <= 1000000; i++)
			factorial[i] = factorial[i - 1] * (long)i % mod;
		
		for(int tc = 1; tc <= t; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			long numer = factorial[n];
			long denom = dqPow(factorial[r], mod - 2);
			denom *= dqPow(factorial[n - r], mod - 2);
			denom %= mod;
			long ret = numer * denom % mod;
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
