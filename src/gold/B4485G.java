package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485G {

	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	static class Co implements Comparable<Co>{
		int r;
		int c;
		int cost;
		
		public Co(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Co o) {
			return this.cost - o.cost;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			int map[][] = new int[n + 1][n + 1];
			int d[][] = new int[n + 1][n + 1];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Co> pq = new PriorityQueue<>();
			d[0][0] = map[0][0];
			pq.offer(new Co(0, 0, d[0][0]));
			while(!pq.isEmpty())
			{
				Co cur = pq.poll();
				if(cur.cost > d[cur.r][cur.c]) continue;
				for(int i = 0; i < 4; i++)
				{
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					if(nr >= 0 && nr < n && nc >= 0 && nc < n)
					{
						if(cur.cost + map[nr][nc] < d[nr][nc])
						{
							d[nr][nc] = cur.cost + map[nr][nc];
							pq.offer(new Co(nr, nc, d[nr][nc]));
						}
					}
				}
			}
			sb.append("Problem " + t + ": " + d[n - 1][n - 1] + "\n");
			t++;
		}
		System.out.println(sb.toString());
	}
}
