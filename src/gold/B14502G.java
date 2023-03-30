package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502G {

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
	static int dc[] = {0, -1, 0, 1};
	static int visit[][];
	static int map[][];
	static int comb[] = new int[3];
	static List<Co> list = new ArrayList<>();
	static int ret;
	
	public static void calBFS(int n, int m)
	{
		int copyMap[][] = new int[n][m];
		Queue<Co> q = new ArrayDeque<>();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				visit[i][j] = 0;
				copyMap[i][j] = map[i][j];
				if(copyMap[i][j] == 2)
					q.offer(new Co(i, j));
			}
		}
		for(int i = 0; i < 3; i++)
			copyMap[list.get(comb[i]).r][list.get(comb[i]).c] = 1;

		while(!q.isEmpty())
		{
			Co cur = q.poll();
			for(int i = 0; i < 4; i++)
			{
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] == 0
						&& copyMap[nr][nc] == 0)
				{
					copyMap[nr][nc] = 3;
					visit[nr][nc] = 1;
					q.offer(new Co(nr, nc));
				}
			}
		}
		int tmp = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
				if(copyMap[i][j] == 0) tmp++;
		}
		if(tmp > ret) ret = tmp;
	}
	
	public static void combination(int n, int m, int count, int start)
	{
		if(count == 3)
		{
			calBFS(n, m);
		}
		else
		{
			for(int i = start; i < list.size(); i++)
			{
				comb[count] = i;
				combination(n, m, count + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
				if(map[i][j] == 0) list.add(new Co(i, j));
		}
		combination(n, m, 0, 0);
		System.out.println(ret);
	}
}
