package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17069G {

	static long map[][] = new long[33][33];
	static long dp[][][] = new long[33][33][3];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				map[i][j] = Long.parseLong(st.nextToken());
		}
		
		dp[0][1][0] = 1;
		for(int i = 0; i < n; i++)
		{
			for(int j = 2; j < n; j++)
			{
				if(map[i][j] == 0)
				{
					dp[i][j][0] += dp[i][j - 1][0];
					if(i != 0) dp[i][j][0] += dp[i][j - 1][2];
				}
				if(map[i][j] == 0)
				{
					if(i != 0)
					{
						dp[i][j][1] += dp[i - 1][j][1];
						dp[i][j][1] += dp[i - 1][j][2];
					}
				}
				if(i != 0 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0)
				{
					dp[i][j][2] += dp[i - 1][j - 1][2];
					dp[i][j][2] += dp[i - 1][j - 1][1];
					dp[i][j][2] += dp[i - 1][j - 1][0];
				}
			}
		}
		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
}
