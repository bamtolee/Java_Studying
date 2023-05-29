package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1019G {

	static long cnt[] = new long[10];
	
	static void cal(int x, long digit)
	{
		while(x > 0)
		{
			int tmp = x % 10;
			cnt[tmp] += digit;
			x /= 10;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 1;
		long digit = 1;
		
		while(n >= a)
		{
			while(n % 10 != 9 && n >= a)
			{
				cal(n, digit);
				n--;
			}
			if(n < 1) break;
			while(a % 10 != 0 && n >= a)
			{
				cal(a, digit);
				a++;
			}
			
			a /= 10;
			n /= 10;
			for(int i = 0; i <= 9; i++)
				cnt[i] += (long)(n - a + 1) * digit;
			digit *= 10;
		}
		
		for(int i = 0; i <= 9; i++)
			System.out.print(cnt[i] + " ");
	}
}
