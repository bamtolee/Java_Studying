package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16564S {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long level[] = new long[n];
		for(int i = 0; i < n; i++)
			level[i] = Long.parseLong(br.readLine());
		
		long left = 0;
		long right = 2000000001;
		long t = 0;
		while(left + 1 < right)
		{
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(int i = 0; i < n; i++)
			{
				if(level[i] > mid) continue;
				sum += mid - level[i];
				if(sum > k) break;
			}
			if(sum <= k)
			{
				t = mid;
				left = mid;
			}
			else right = mid;
		}
		System.out.println(t);
	}
}
