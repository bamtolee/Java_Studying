package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2805_D3
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			String s;
			int ret = 0, side = 0, term = 2;
			
			for(int i = 0; i < n; i++)
			{
				s = br.readLine();
				for(int j = 0; j < n; j++)
				{
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			
			for(int i = n / 2; i < n; i++)
			{
				for(int j = 0 + side; j < n - side; j++)
					ret += arr[i][j];
				if(i != n / 2)
				{
					for(int j = 0 + side; j < n - side; j++)
						ret += arr[i - term][j];
					term += 2;
				}
				side += 1;
			}
			sb.append("#").append(test_case).append(" ").append(ret).append("\n");
		}
		System.out.println(sb.toString());
	}
}