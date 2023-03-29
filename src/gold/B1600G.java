package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600G {

	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int drHorse[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int dcHorse[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	static int map[][] = new int[201][201];
	static int visit[][][] = new int[201][201][31];
	static int ret[][] = new int[201][201];
	static class co{
		int r;
		int c;
		int k;
		
		public co(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	public static void bfs(int k, int w, int h)
	{
		Queue<co> q = new ArrayDeque<>();
		visit[0][0][0] = 1;
		ret[0][0] = 0;
		q.offer(new co(0, 0, 0));
		
		while(!q.isEmpty())
		{
			co cur = q.poll();
			
			for(int i = 0; i < 4; i++)
			{
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				int ck = cur.k;
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 0
						&& visit[nr][nc][ck] == 0)
				{
					visit[nr][nc][ck] = 1;
					ret[nr][nc] = ret[cur.r][cur.c] + 1;
					q.offer(new co(nr, nc, ck));
				}
			}
			if(cur.k < k)
			{
				for(int i = 0; i < 8; i++)
				{
					int nr = cur.r + drHorse[i];
					int nc = cur.c + dcHorse[i];
					int ck = cur.k + 1;
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 0
							&& visit[nr][nc][ck] == 0)
					{
						visit[nr][nc][ck] = 1;
						ret[nr][nc] = ret[cur.r][cur.c] + 1;
						q.offer(new co(nr, nc, ck));
					}
				}
			}
			if(ret[h - 1][w - 1] != 0) break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		for(int i = 0; i < h; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs(k, w, h);
		if(ret[h - 1][w - 1] == 0 && (h != 1 && w != 1)) System.out.println(-1);
		else System.out.println(ret[h - 1][w - 1]);
	}
}
