package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_D6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int inf = 10000000;
		
		for(int tc = 1; tc <= t; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d[][] = new int[n + 1][n + 1];
			for(int i = 1; i <= n; i++)
			{
				for(int j = 1; j <= n; j++)
				{
					d[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && d[i][j] == 0) d[i][j] = inf;
				}
			}
			
			for(int k = 1; k <= n; k++)
			{
				for(int i = 1; i <= n; i++)
				{
					if(i == k) continue;
					for(int j = 1; j <= n; j++)
					{
						if(j == k || i == j) continue;
						if(d[i][j] > d[i][k] + d[k][j])
							d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
			
			int min = inf;
			for(int i = 1; i <= n; i++)
			{
				int tmpSum = 0;
				for(int j = 1; j <= n; j++)
					tmpSum += d[i][j];
				if(tmpSum < min)
					min = tmpSum;
			}
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
}
