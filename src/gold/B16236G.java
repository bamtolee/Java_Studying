package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class sCo implements Comparable<sCo>{
	int r;
	int c;
	public sCo(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	@Override
	public int compareTo(sCo o) {
		if(this.r == o.r) return this.c - o.c;
		else return this.r - o.r;
	}
}

class FishInfor {
	int r;
	int c;
	int size;
	int count;
	public FishInfor(int r, int c, int size, int count) {
		super();
		this.r = r;
		this.c = c;
		this.size = size;
		this.count = count;
	}
}

public class B16236G {

	public static int cField[][] = new int[21][21];
	public static int field[][] = new int[21][21];
	public static FishInfor shark;
	public static int dr[] = {-1, 0, 0, 1};
	public static int dc[] = {0, -1, 1, 0};
	public static int retTime = 0;
	
	public static int sharkBFS(int n)
	{
		int visit[][] = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				cField[i][j] = 0;
		int tmpRet = -1;
		
		Queue<sCo> q = new ArrayDeque<>();
		PriorityQueue<sCo> pq = new PriorityQueue<>();
		q.offer(new sCo(shark.r, shark.c));
		visit[shark.r][shark.c] = 1;
		while(!q.isEmpty())
		{
			int qs = q.size();
			
			for(int l = 0; l < qs; l++)
			{
				sCo cur = q.poll();
				int tr = cur.r;
				int tc = cur.c;
				
				for(int i = 0; i < 4; i++)
				{
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					if(nr >= 0 && nr < n && nc >= 0 && nc < n && visit[nr][nc] == 0)
					{
						if(field[nr][nc] <= shark.size || field[nr][nc] == 0)
						{
							visit[nr][nc] = 1;
							cField[nr][nc] = cField[tr][tc] + 1;
							pq.offer(new sCo(nr, nc));
						}
					}
				}
			}
			int tmpSize = pq.size();
			for(int i = 0; i < tmpSize; i++)
			{
				sCo tmp = pq.poll();
				if(field[tmp.r][tmp.c] != 0 && tmpRet == -1 && field[tmp.r][tmp.c] < shark.size)
				{
					field[tmp.r][tmp.c] = 9;
					field[shark.r][shark.c] = 0;
					shark.r = tmp.r;
					shark.c = tmp.c;
					shark.count++;
					if(shark.size == shark.count)
					{
						shark.count = 0;
						shark.size++;
					}
					tmpRet = cField[tmp.r][tmp.c];
				}		
				q.offer(tmp);
			}
			if(tmpRet != -1) break;
		}
		return tmpRet;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
			{
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == 9)
					shark = new FishInfor(i, j, 2, 0);
			}
		}
		
		while(true)
		{
			int tmp = sharkBFS(n);
			if(tmp == -1) break;
			else retTime += tmp;
		}
		System.out.println(retTime);
	}
}
