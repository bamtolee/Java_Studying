package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B17472G {

	static class Bridge implements Comparable<Bridge>{
		int from;
		int to;
		int cost;
		
		public Bridge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.cost - o.cost;
		}
	}
	
	static List<Bridge> li = new ArrayList<>();
	static int map[][] = new int[11][11];
	static int dfsVisit[][] = new int[11][11];
	static int p[] = new int[7];
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int islandCount;
	
	static void makeSet(int a)
	{
		p[a] = a;
	}
	
	static int findSet(int a)
	{
		if(a == p[a]) return a;
		else return p[a] = findSet(p[a]);
	}
	
	static void unionSet(int a, int b)
	{
		a = findSet(a);
		b = findSet(b);
		if(a != b)
		{
			if(a > b) p[a] = b;
			else p[b] = a;
		}
	}
	
	static void makeBridge(int n, int m, int cr, int cc, int curLand)
	{
		for(int i = 0; i < 4; i++)
		{
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			int cost = 1;
			while(nr >= 0 && nr < n && nc >= 0 && nc < m)
			{
				if(map[nr][nc] == curLand) break;
				else if(map[nr][nc] > 0)
				{
					if(cost - 1 >= 2)
						li.add(new Bridge(curLand, map[nr][nc], cost - 1));
					break;
				}
				nr += dr[i];
				nc += dc[i];
				cost++;
			}
		}
	}
	
	static void dfs(int n, int m, int cr, int cc)
	{
		dfsVisit[cr][cc] = 1;
		map[cr][cc] = islandCount;
		for(int i = 0; i < 4; i++)
		{
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m
					&& dfsVisit[nr][nc] == 0 && map[nr][nc] == 1)
				dfs(n, m, nr, nc);
		}
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
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(dfsVisit[i][j] == 0 && map[i][j] == 1)
				{
					islandCount++;
					dfs(n, m, i, j);
				}
			}
		}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] != 0)
					makeBridge(n, m, i, j, map[i][j]);
		Collections.sort(li);
		
		for(int i = 1; i <= islandCount; i++)
			makeSet(i);
		int count = 0, ret = 0;
		for(int i = 0; i < li.size(); i++)
		{
			int from = li.get(i).from;
			int to = li.get(i).to;
			int cost = li.get(i).cost;
			if(findSet(from) != findSet(to))
			{
				unionSet(from, to);
				count++;
				ret += cost;
				if(count == islandCount - 1)
					break;
			}
		}
		if(count == islandCount - 1) System.out.println(ret);
		else System.out.println("-1");
	}
}