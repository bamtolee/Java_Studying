package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9205G {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int inf = 5000000;
		
		while(t-- > 0)	
		{
			int n = Integer.parseInt(br.readLine());
			int co[][] = new int[n + 2][2];
			int d[][] = new int[n + 2][n + 2];
			for(int i = 0; i < n + 2; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++)
					co[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n + 2; i++)
			{
				for(int j = 0; j < n + 2; j++)
				{
					if(i == j) continue;
					int tmp = Math.abs(co[i][0] - co[j][0]) + Math.abs(co[i][1] - co[j][1]);
					if(tmp <= 1000) d[i][j] = tmp / 50;
					else d[i][j] = inf;
				}
			}
			
			for(int k = 0; k < n + 2; k++)
			{
				for(int i = 0; i < n + 2; i++)
				{
					if(i == k) continue;
					for(int j = 0; j < n + 2; j++)
					{
						if(j == k || i == j) continue;
						if(d[i][j] > d[i][k] + d[k][j])
							d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
			if(d[0][n + 1] == inf) sb.append("sad\n");
			else sb.append("happy\n");
		}
		System.out.println(sb.toString());
	}
}
