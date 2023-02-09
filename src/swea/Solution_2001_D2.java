package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_D2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
			
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int field[][] = new int[n][n];
			int maxKill = 0;
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					field[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i <= n - m; i++)
			{
				for(int j = 0; j <= n - m; j++)
				{
					int tmp = 0;
					for(int k = i; k < i + m; k++)
						for(int l = j; l < j + m; l++)
							tmp += field[k][l];
					if(tmp > maxKill) maxKill = tmp;
				}
			}
			sb.append("#").append(test_case).append(" ").append(maxKill).append("\n");
		}
		System.out.println(sb.toString());
	}
}
