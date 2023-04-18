package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520G {

	static int field[][] = new int[501][501];
	static int road[][] = new int[501][501];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	static int dfs(int n, int m, int cr, int cc)
	{
		if(road[cr][cc] >= 0) return road[cr][cc];
		if(cr == n - 1 && cc == m - 1) return 1;
		
		road[cr][cc] = 0;
		for(int i = 0; i < 4; i++)
		{
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m)
				if(field[nr][nc] < field[cr][cc])
					road[cr][cc] = dfs(n, m, nr, nc) + road[cr][cc];
		}
		return road[cr][cc];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
			{
				road[i][j] = -1;
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(n, m, 0, 0));
	}
}
