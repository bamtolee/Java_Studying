package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class tCo {
	int r;
	int c;
	public tCo(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class B7576G {

	public static int tomato[][];
	public static int visit[][];
	public static int dr[] = {1, 0, -1, 0};
	public static int dc[] = {0, 1, 0, -1};
	
	public static void bfs(int n, int m)
	{
		Queue<tCo> tq = new ArrayDeque<>();
		visit = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(tomato[i][j] == 1)
				{
					tq.offer(new tCo(i, j));
					visit[i][j] = 1;
				}
			}
		}
		
		while(!tq.isEmpty())
		{
			tCo cur = tq.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			for(int i = 0; i < 4; i++)
			{
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] == 0)
				{
					if(tomato[nr][nc] == 0)
					{
						tomato[nr][nc] = tomato[cr][cc] + 1;
						tq.offer(new tCo(nr, nc));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				tomato[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs(n, m);
		
		int ret = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(tomato[i][j] == 0)
				{
					ret = -1;
					break;
				}
				else if(tomato[i][j] - 1 > ret)
					ret = tomato[i][j] - 1;
			}
			if(ret == -1) break;
		}
		System.out.println(ret);
	}
}
