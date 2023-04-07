package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042G {

	static long arr[] = new long[1000001];
	static long fenwick[] = new long[1000001];
	static void add(long n, long i, long num)
	{
		while(i <= n)
		{
			fenwick[(int)i] += num;
			i += (i & -i);
		}
	}
	
	static long sum(long n, long i)
	{
		long ret = 0;
		while(i > 0)
		{
			ret += fenwick[(int)i];
			i -= (i & -i);
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		for(int i = 1; i <= n; i++)
			arr[i] = Long.parseLong(br.readLine());
		for(int i = 1; i <= n; i++)
			add(n, i, arr[i]);
		
		for(int i = 0; i < m + k; i++)
		{
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1)
			{
				add(n, b, -arr[(int)b]);
				arr[(int)b] = c;
				add(n, b, c);
			}
			else if(a == 2)
				sb.append(sum(n, c) - sum(n, b - 1) + "\n");
		}
		System.out.println(sb.toString());
	}
}
