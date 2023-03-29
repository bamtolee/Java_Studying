package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463S {

	static int dp[] = new int[1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp[1] = 0;
		for(int i = 2; i <= n; i++)
		{
			int tmp1 = dp[i - 1] + 1;
			int tmp2 = Integer.MAX_VALUE;
			int tmp3 = Integer.MAX_VALUE;
			
			if(i % 2 == 0)
				tmp2 = dp[i / 2] + 1;
			if(i % 3 == 0)
				tmp3 = dp[i / 3] + 1;
			dp[i] = Math.min(Math.min(tmp1, tmp2), tmp3);
		}
		System.out.println(dp[n]);
	}
}
