package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987G {
	
	public static char board[][] = new char[21][21];
	public static int visit[] = new int[26];
	public static int dr[] = {1, 0, -1, 0};
	public static int dc[] = {0, 1, 0, -1};
	public static int ret;

	public static void dfs(int r, int c, int curR, int curC, int tmpN)
	{
		visit[board[curR][curC] - 'A'] = 1;
		if(tmpN > ret) ret = tmpN;
		
		for(int i = 0; i < 4; i++)
		{
			int ncurR = curR + dr[i];
			int ncurC = curC + dc[i];
			if(ncurR >= 0 && ncurR < r && ncurC >= 0 && ncurC < c)
			{
				if(visit[board[ncurR][ncurC] - 'A'] != 1)
					dfs(r, c, ncurR, ncurC, tmpN + 1);
			}
		}
		visit[board[curR][curC] - 'A'] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int tmpN = 1;
		for(int i = 0; i < r; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < c; j++)
				board[i][j] = tmp.charAt(j);
		}
		
		dfs(r, c, 0, 0, tmpN);
		System.out.println(ret);
	}
}
