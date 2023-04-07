package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5604_D4 {

	static long cnt[] = new long[10];
	
	static void cal(long x, long digit)
	{
		while(x > 0)
		{
			long tmp = x % 10;
			cnt[(int)tmp] += digit;
			x /= 10;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++)
		{
			Arrays.fill(cnt, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long digit = 1;
			
			while(a <= b)
			{
				while(b % 10 != 9 && a <= b)
				{
					cal(b, digit);
					b--;
				}
				if(b < a) break;
				while(a % 10 != 0 && a <= b)
				{
					cal(a, digit);
					a++;
				}
				
				a /= 10;
				b /= 10;
				for(int i = 0; i <= 9; i++)
					cnt[i] += (b - a + 1) * digit;
				digit *= 10;
			}
			long ret = 0;
			for(int i = 0; i <= 9; i++)
				ret += cnt[i] * i;
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}