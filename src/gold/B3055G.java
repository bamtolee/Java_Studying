package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055G {

	static class Co{
		int r;
		int c;
		
		public Co(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Co> q = new ArrayDeque<>();
	static Queue<Co> waterQ = new ArrayDeque<>();
	static char map[][] = new char[51][51];
	static int visit[][] = new int[51][51];
	static int waterVisit[][] = new int[51][51];
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int ret;
	
	static void bfs(int r, int c)
	{
		while(!q.isEmpty())
		{
			int qs = q.size();
			ret++;
			for(int i = 0; i < qs; i++)
			{
				Co cur = q.poll();
				if(map[cur.r][cur.c] == '*') continue;
				for(int j = 0; j < 4; j++)
				{
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					if(nr < 0 || nr >= r || nc < 0 || nc >= c
							|| visit[nr][nc] == 1)
						continue;
					if(map[nr][nc] == 'D')
					{
						System.out.println(ret);
						return;
					}
					else if(map[nr][nc] == '.')
					{
						visit[nr][nc] = 1;
						q.offer(new Co(nr, nc));
					}
				}
			}
			
			int ws = waterQ.size();
			for(int i = 0; i < ws; i++)
			{
				Co cur = waterQ.poll();
				for(int j = 0; j < 4; j++)
				{
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					if(nr < 0 || nr >= r || nc < 0 || nc >= c
							|| waterVisit[nr][nc] == 1)
						continue;
					if(map[nr][nc] == '.' || map[nr][nc] == 'S')
					{
						waterVisit[nr][nc] = 1;
						map[nr][nc] = '*';
						waterQ.offer(new Co(nr, nc));
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for(int i = 0; i < r; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < c; j++)
			{
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'S')
				{
					visit[i][j] = 1;
					q.offer(new Co(i, j));
				}
				else if(map[i][j] == '*')
				{
					waterVisit[i][j] = 1;
					waterQ.offer(new Co(i, j));
				}
			}
		}
		
		bfs(r, c);
	}
}
