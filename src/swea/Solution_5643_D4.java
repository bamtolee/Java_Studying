package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_D4 {

	static int inf = 1000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int order[][] = new int[n + 1][n + 1];
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= n; j++)
					if(i != j)
						order[i][j] = inf;
			for(int i = 0; i < m; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				order[a][b] = 1;
			}
			
			for(int k = 1; k <= n; k++)
			{
				for(int i = 1; i <= n; i++)
				{
					if(i == k) continue;
					for(int j = 1; j <= n; j++)
					{
						if(i == j || j == k) continue;
						if(order[i][j] == inf && order[i][k] + order[k][j] == 2)
							order[i][j] = 1;
					}
				}
			}
			
			int ret = 0;
			for(int i = 1; i <= n; i++)
			{
				int tmpSum = 0;
				for(int j = 1; j <= n; j++)
				{
					if(i == j) continue;
					if(order[i][j] != inf)
						tmpSum += order[i][j];
					if(order[j][i] != inf)
						tmpSum += order[j][i];
				}
				if(tmpSum == n - 1) ret++;
			}
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}