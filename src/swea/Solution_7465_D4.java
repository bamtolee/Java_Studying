package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_D4 {

	public static int p[];
	
	public static void makeSet(int x)
	{
		p[x] = x;
	}
	
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void union(int x, int y)
	{
		x = findSet(x);
		y = findSet(y);
		if(x != y)
		{
			if(x > y) p[x] = y;
			else p[y] = x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());	
			int ret = 0;
			p = new int[n + 1];
			for(int i = 1; i <= n; i++)
				makeSet(i);
			
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
			for(int i = 1; i <= n; i++)
				findSet(i);
			
			int visit[] = new int[n + 1];
			for(int i = 1; i <= n; i++)
			{
				if(visit[p[i]] == 0)
				{
					visit[p[i]] = 1;
					ret++;
				}
			}
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
