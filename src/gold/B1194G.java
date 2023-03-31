package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194G {

	static class Co{
		int r;
		int c;
		int keySet;
		
		public Co(int r, int c, int keySet) {
			super();
			this.r = r;
			this.c = c;
			this.keySet = keySet;
		}
	}
	
	static char map[][] = new char[51][51];
	static int visit[][][] = new int[51][51][64];
	static int d[][] = new int[51][51];
	static Queue<Co> q = new ArrayDeque<>();
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean flag;
	
	static void bfs(int n, int m)
	{
		while(!q.isEmpty())
		{
			Co cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int curK = cur.keySet;
			for(int i = 0; i < 4; i++)
			{
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if(map[nr][nc] == '#' || visit[nr][nc][curK] == 1)
					continue;
				
				if(map[nr][nc] == '0' || map[nr][nc] == '.')
				{
					visit[nr][nc][curK] = 1;
					d[nr][nc] = d[r][c] + 1;
					q.offer(new Co(nr, nc, curK));
				}
				else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f')
				{
					visit[nr][nc][curK] = 1;
					int check = map[nr][nc] - 'a';
					int nk = curK;
					if((curK & (1 << check)) == 0)
					{
						nk |= (1 << check);
						if(visit[nr][nc][nk] == 1) continue;
					}
					visit[nr][nc][nk] = 1;
					d[nr][nc] = d[r][c] + 1;
					q.offer(new Co(nr, nc, nk));
				}
				else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F')
				{
					int check = map[nr][nc] - 'A';
					if(((1 << check) & curK) != 0)
					{
						visit[nr][nc][curK] = 1;
						d[nr][nc] = d[r][c] + 1;
						q.offer(new Co(nr, nc, curK));
					}
				}
				else if(map[nr][nc] == '1')
				{
					d[nr][nc] = d[r][c] + 1;
					System.out.println(d[nr][nc]);
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < m; j++)
			{
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '0')
				{
					q.offer(new Co(i, j, 0));
					visit[i][j][0] = 1;
					d[0][0] = 0;
				}
			}
		}
		
		bfs(n, m);
		if(!flag) System.out.println("-1");
	}
}
