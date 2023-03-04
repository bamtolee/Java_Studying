package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class CoBlock
{
	int r;
	int c;
	int power;
	public CoBlock(int r, int c, int power) {
		super();
		this.r = r;
		this.c = c;
		this.power = power;
	}
}

public class Solution_5656 {

	public static int field[][] = new int[15][15];
	public static int cField[][] = new int[15][15];
	public static int min;
	public static int ballLocComb[];
	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static void autoDown(int h, int w)
	{
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int j = 0; j < w; j++)
		{
			for(int i = 0; i < h; i++)
				if(cField[i][j] >= 1) q.offer(cField[i][j]);
			int qs = h - q.size();
			for(int i = 0; i < qs; i++)
				cField[i][j] = 0;
			for(int i = qs; i < h; i++)
				cField[i][j] = q.poll();
		}
	}
	
	public static void boom(int h, int w, int r, int c)
	{
		Queue<CoBlock> q = new ArrayDeque<>();
		if(cField[r][c] > 1)
			q.offer(new CoBlock(r, c, cField[r][c]));
		cField[r][c] = 0;
		
		while(!q.isEmpty())
		{
			CoBlock tmp = q.poll();
			
			for(int i = 0; i < 4; i++)
			{
				int nr = tmp.r;
				int nc = tmp.c;
				
				for(int j = 1; j <= tmp.power - 1; j++)
				{
					nr += dr[i];
					nc += dc[i];
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && cField[nr][nc] > 0)
					{
						if(cField[nr][nc] > 1)
							q.offer(new CoBlock(nr, nc, cField[nr][nc]));
						cField[nr][nc] = 0;
					}
				}
			}
		}
	}
	
	public static void falling(int h, int w, int n)
	{
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				cField[i][j] = field[i][j];
		
		for(int i = 0; i < n; i++)
		{
			int loc = ballLocComb[i];
			
			for(int j = 0; j < h; j++)
			{
				if(cField[j][loc] >= 1)
				{
					boom(h, w, j, loc);
					autoDown(h, w);
					break;
				}
			}
		}
		
		int tmpMin = 0;
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				if(cField[i][j] >= 1) tmpMin++;
		if(tmpMin < min) min = tmpMin;
	}
	
	public static void ballPer(int h, int w, int n, int count)
	{
		if(count == n)
		{
			falling(h, w, n);
		}
		else
		{
			for(int i = 0; i < w; i++)
			{
				ballLocComb[count] = i;
				ballPer(h, w, n, count + 1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			ballLocComb = new int[n];
			for(int i = 0; i < h; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++)
					field[i][j] = Integer.parseInt(st.nextToken());
			}
			
			ballPer(h, w, n, 0);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
}
