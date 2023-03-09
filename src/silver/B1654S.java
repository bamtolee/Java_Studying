package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654S {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		long lan[] = new long[k];
		long lenMax = 0;
		for(int i = 0; i < k; i++)
		{
			lan[i] = Long.parseLong(br.readLine());
			if(lenMax < lan[i]) lenMax = lan[i];
		}
		
		long left = 1;
		long right = lenMax;
		long ret = 0;
		while(left <= right)
		{
			long mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < k; i++)
			{
				sum += lan[i] / mid;
				if(sum > n) break;
			}
			if(sum >= n)
			{
				if(ret < mid) ret = mid;
				left = mid + 1;
			}
			else
				right = mid - 1;
		}
		System.out.println(ret);
	}
}
