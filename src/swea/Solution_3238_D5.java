package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_D5 {

	static long factorial[] = new long[100001];
	
	static long dqPow(long a, long b, long p)
	{
		long i = 1;
		while(b > 0)
		{
			if((b & 1) == 1)
			{
				i *= a;
				i %= p;
			}
			a *= a;
			a %= p;
			b = b >> 1;
		}
		return i;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			factorial[0] = 1;
			factorial[1] = 1;
			for(int i = 2; i <= p; i++)
				factorial[i] = factorial[i - 1] * (long)i % p;
			
			long ret = 1;
			while(n > 0 || r > 0)
			{
				long a = n % p;
				long b = r % p;
				if(a < b)
				{
					ret = 0;
					break;
				}
				long numer = factorial[(int)a];
				long denom = dqPow(factorial[(int)b], p - 2, p);
				denom *= dqPow(factorial[(int)(a - b)], p - 2, p);
				denom %= p;
				n /= p;
				r /= p;
				ret *= numer;
				ret %= p;
				ret *= denom;
				ret %= p;
			}
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
