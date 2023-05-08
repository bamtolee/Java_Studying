package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1938G {

	static class GidungInfor
	{
		int status;
		int centerR;
		int centerC;
		int count;
		
		public GidungInfor(int status, int centerR, int centerC, int count) {
			super();
			this.status = status;
			this.centerR = centerR;
			this.centerC = centerC;
			this.count = count;
		}
	}
	
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int statusZeroTurnCheckDR[] = {-1, -1, -1, 1, 1, 1};
	static int statusZeroTurnCheckDC[] = {-1, 0, 1, -1, 0, 1};
	static int statusOneTurnCheckDR[] = {-1, 0, 1, -1, 0, 1};
	static int statusOneTurnCheckDC[] = {-1, -1, -1, 1, 1, 1};
	static char field[][] = new char[51][51];
	static int visit[][][] = new int[51][51][2];
	static int ret;
	
	static void bfs(int startR, int startC, int startStatus, int n)
	{
		Queue<GidungInfor> q = new ArrayDeque<>();
		q.add(new GidungInfor(startStatus, startR, startC, 0));
		visit[startR][startC][startStatus] = 1;
		
		while(!q.isEmpty())
		{
			GidungInfor cur = q.poll();
			if(field[cur.centerR][cur.centerC] == 'E')
			{
				if(cur.status == 0)
				{
					if(field[cur.centerR][cur.centerC - 1] == 'E'
							&& field[cur.centerR][cur.centerC + 1] == 'E')
					{
						ret = cur.count;
						return;
					}
				}
				else if(cur.status == 1)
				{
					if(field[cur.centerR - 1][cur.centerC] == 'E'
							&& field[cur.centerR + 1][cur.centerC] == 'E')
					{
						ret = cur.count;
						return;
					}
				}
			}
			for(int i = 0; i < 4; i++)
			{
				int nr = cur.centerR + dr[i];
				int nc = cur.centerC + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc][cur.status] == 1)
					continue;
				if(cur.status == 1)
				{
					if(nr == 0 || nr == n - 1) continue;
					if(field[nr - 1][nc] == '1' || field[nr][nc] == '1' || field[nr + 1][nc] == '1')
						continue;
				}
				else if(cur.status == 0)
				{
					if(nc == 0 || nc == n - 1) continue;
					if(field[nr][nc - 1] == '1' || field[nr][nc] == '1' || field[nr][nc + 1] == '1')
						continue;
				}
				q.add(new GidungInfor(cur.status, nr, nc, cur.count + 1));
				visit[nr][nc][cur.status] = 1;
			}

			if(visit[cur.centerR][cur.centerC][1 - cur.status] == 1)
				continue;
			if(cur.status == 1)
			{
				int k = 0;
				for(; k < 6; k++)
				{
					int cr = cur.centerR + statusOneTurnCheckDR[k];
					int cc = cur.centerC + statusOneTurnCheckDC[k];
					if(cr < 0 || cr >= n || cc < 0 || cc >= n) break;
					if(field[cr][cc] == '1') break;
				}
				if(k == 6)
				{
					q.add(new GidungInfor(0, cur.centerR, cur.centerC, cur.count + 1));
					visit[cur.centerR][cur.centerC][0] = 1;
				}
			}
			else if(cur.status == 0)
			{
				int k = 0;
				for(; k < 6; k++)
				{
					int cr = cur.centerR + statusZeroTurnCheckDR[k];
					int cc = cur.centerC + statusZeroTurnCheckDC[k];
					if(cr < 0 || cr >= n || cc < 0 || cc >= n) break;
					if(field[cr][cc] == '1') break;
				}
				if(k == 6)
				{
					q.add(new GidungInfor(1, cur.centerR, cur.centerC, cur.count + 1));
					visit[cur.centerR][cur.centerC][1] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int startR = -1, startC = 0, startStatus = 0;
		for(int i = 0; i < n; i++)
		{
			String str = br.readLine();
			for(int j = 0; j < n; j++)
			{
				field[i][j] = str.charAt(j);
				if(field[i][j] == 'B' && startR == -1)
				{
					if(i >= 1 && field[i - 1][j] == 'B')
					{
						startR = i;
						startC = j;
						startStatus = 1;
					}
					else if(j >= 1 && field[i][j - 1] == 'B')
					{
						startR = i;
						startC = j;
						startStatus = 0;
					}
				}
			}
		}
		
		bfs(startR, startC, startStatus, n);
		System.out.println(ret);
	}
}
