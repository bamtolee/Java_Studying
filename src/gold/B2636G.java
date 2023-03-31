package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636G {

	static class Co{
		int r;
		int c;
		
		public Co(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int map[][] = new int[101][101];
	static boolean flag;
	static int ret;
	
	static void bfs(int h, int w)
	{
		int copyMap[][] = new int[h][w];
		int tmpSum = 0;
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				copyMap[i][j] = map[i][j];
				tmpSum += map[i][j];
			}
		}
		if(tmpSum == 0)
		{
			flag = true;
			return;
		}
		ret = tmpSum;
		int visit[][] = new int[h][w];
		Queue<Co> q = new ArrayDeque<>();
		q.offer(new Co(0, 0));
		visit[0][0] = 1;
		
		while(!q.isEmpty())
		{
			Co cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for(int i = 0; i < 4; i++)
			{
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || visit[nr][nc] == 1) continue;
				visit[nr][nc] = 1;
				if(map[nr][nc] == 0)
					q.offer(new Co(nr, nc));
				else
					copyMap[nr][nc] = 0;
			}
		}
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				map[i][j] = copyMap[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		for(int i = 0; i < h; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		while(true)
		{
			bfs(h, w);
			if(flag) break;
			time++;
		}
		System.out.println(time + "\n" + ret);
	}
}
