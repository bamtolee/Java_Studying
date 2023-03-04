package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class acCo {
	int r;
	int c;
	public acCo(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class B17144G {

	public static int cField[][] = new int[51][51];
	public static int field[][] = new int[51][51];
	public static int dr[] = {1, 0, -1, 0};
	public static int dc[] = {0, 1, 0, -1};
	public static acCo upAC;
	public static acCo boAC;
	
	public static void airRot(int r, int c)
	{
		Queue<Integer> uq = new ArrayDeque<>();
		Queue<Integer> dq = new ArrayDeque<>();

		for(int i = 1; i < c; i++)
		{
			uq.offer(field[upAC.r][i]);
			dq.offer(field[boAC.r][i]);
		}
		for(int i = upAC.r - 1; i >= 0; i--)
			uq.offer(field[i][c - 1]);
		for(int i = boAC.r + 1; i < r; i++)
			dq.offer(field[i][c - 1]);
		for(int i = c - 2; i >= 0; i--)
		{
			uq.offer(field[0][i]);
			dq.offer(field[r - 1][i]);
		}
		for(int i = 1; i < upAC.r; i++)
			uq.offer(field[i][0]);
		for(int i = r - 2; i > boAC.r; i--)
			dq.offer(field[i][0]);
		
		field[upAC.r][1] = 0;
		field[boAC.r][1] = 0;
		
		for(int i = 2; i < c; i++)
		{
			field[upAC.r][i] = uq.poll();
			field[boAC.r][i] = dq.poll();
		}
		for(int i = upAC.r - 1; i >= 0; i--)
			field[i][c - 1] = uq.poll();
		for(int i = boAC.r + 1; i < r; i++)
			field[i][c - 1] = dq.poll();
		for(int i = c - 2; i >= 0; i--)
		{
			field[0][i] = uq.poll();
			field[r - 1][i] = dq.poll();
		}
		for(int i = 1; i < upAC.r; i++)
			field[i][0] = uq.poll();
		for(int i = r - 2; i > boAC.r; i--)
			field[i][0] = dq.poll();
	}
	
	public static void diffusion(int r, int c)
	{
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				cField[i][j] = 0;
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(field[i][j] >= 1)
				{
					int count = 0;
					for(int k = 0; k < 4; k++)
					{
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr >= 0 && nr < r && nc >= 0 && nc < c && field[nr][nc] != -1)
						{
							cField[nr][nc] += field[i][j] / 5;
							count++;
						}
					}
					cField[i][j] += field[i][j] - (field[i][j] / 5 * count);
				}
			}
		}
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(field[i][j] == -1) continue;
				field[i][j] = cField[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int tmp = 0, ret = 0;
		for(int i = 0; i < r; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++)
			{
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == -1 && tmp == 0) 
				{
					upAC = new acCo(i, j);
					tmp++;
				}
				else if(field[i][j] == -1 && tmp == 1) boAC = new acCo(i, j);
			}
		}
		
		for(int i = 0; i < t; i++)
		{
			diffusion(r, c);
			airRot(r, c);
		}
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(field[i][j] == -1) continue;
				ret += field[i][j];
			}
		}
		System.out.println(ret);
	}
}
