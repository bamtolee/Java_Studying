package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Co{
	int r;
	int c;
	public Co(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class B2178S {

	public static int miro[][] = new int[101][101];
	public static int visit[][] = new int[101][101];
	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static void bfs(int startR, int startC, int n, int m)
	{
		Queue<Co> q = new LinkedList<>();
		q.offer(new Co(startR, startC));
		visit[startR][startC] = 1;
		
		while(!q.isEmpty())
		{
			Co tmp = q.poll();
			if(tmp.r == n && tmp.c == m)
				break;	
			for(int j = 0; j < 4; j++)
			{
				int nr = tmp.r + dr[j];
				int nc = tmp.c + dc[j];
				
				if(nr <= n && nr >= 1 && nc >= 1 && nc <= m && visit[nr][nc] != 1)
				{
					if(miro[nr][nc] >= 1)
					{
						q.offer(new Co(nr, nc));
						visit[nr][nc] = 1;
						miro[nr][nc] = miro[tmp.r][tmp.c] + 1; 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++)
		{
			String tmp = br.readLine();
			for(int j = 1; j <= m; j++)
				miro[i][j] = tmp.charAt(j - 1) - '0';
		}
		
		bfs(1, 1, n, m);
		System.out.println(miro[n][m]);
	}
}

/*
public class Main {

	public static int miro[][] = new int[101][101];
	public static int visit[][] = new int[101][101];
	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static int bfs(int startR, int startC, int n, int m)
	{
		int ret = 0;
		
		Queue<Co> q = new LinkedList<>();
		q.offer(new Co(startR, startC));
		visit[startR][startC] = 1;
		
		while(!q.isEmpty())
		{
			int qSize = q.size();
			boolean flag = false;
			ret++;

			for(int i = 0; i < qSize; i++)
			{
				Co tmp = q.poll();
				if(tmp.r == n && tmp.c == m)
				{
					flag = true;
					break;	
				}
				for(int j = 0; j < 4; j++)
				{
					int nr = tmp.r + dr[j];
					int nc = tmp.c + dc[j];
					
					if(nr <= n && nr >= 1 && nc >= 1 && nc <= m && visit[nr][nc] != 1)
					{
						if(miro[nr][nc] == 1)
						{
							q.offer(new Co(nr, nc));
							visit[nr][nc] = 1;
						}
					}
				}
			}
			if(flag) break;
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++)
		{
			String tmp = br.readLine();
			for(int j = 1; j <= m; j++)
				miro[i][j] = tmp.charAt(j - 1) - '0';
		}
		
		int ret = bfs(1, 1, n, m);
		System.out.println(ret);
	}
}
*/
