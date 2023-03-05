package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B1914S {

	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoiPrint(int from, int to)
	{
		sb.append(from + " " + to + "\n");
	}
	
	public static void hanoiRecur(int start, int mid, int end, int n)
	{
		if(n == 1)
		{
			hanoiPrint(start, end);
		}
		else
		{
			hanoiRecur(start, end, mid, n - 1);
			hanoiPrint(start, end);
			hanoiRecur(mid, start, end, n - 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n <= 20)
		{
			sb.append((int)Math.pow(2, n) - 1 + "\n");
			hanoiRecur(1, 2, 3, n);
		}
		else
		{
			BigInteger bi = new BigInteger(Integer.toString(1));
			for(int i = 0; i < n; i++)
				bi = bi.multiply(BigInteger.valueOf(2));
			bi = bi.subtract(BigInteger.valueOf(1));
			sb.append(bi.toString());
		}
		System.out.println(sb.toString());
	}
}
