package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sharka{
	int r;
	int c;
	int speed;
	int dir;
	int size;
	int live;
	
	public Sharka(int r, int c, int speed, int dir, int size, int live) {
		super();
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
		this.live = live;
	}
}

public class B17143G_2 {

	public static int field[][];
	public static Sharka[] SL;
	public static int copyField[][];
	public static int dr[] = {0, -1, 1, 0, 0};
	public static int dc[] = {0, 0, 0, 1, -1};
	public static int ret;
	
	public static void sharkMove(int r, int c, int m)
	{
		copyField = new int[r + 1][c + 1];
		
		for(int i = 0; i < m; i++)
		{
			if(SL[i].live == 0) continue;
			int curSpeed = SL[i].speed;
			int nsr = SL[i].r;
			int nsc = SL[i].c;
			int curDir = SL[i].dir;
			if(curDir == 1 || curDir == 2)
			{
				curSpeed = curSpeed % (r * 2 - 2);
				for(int j = 0; j < curSpeed; j++)
				{
					if(nsr == 1)
						curDir = 2;
					else if(nsr == r)
						curDir = 1;
					nsr += dr[curDir];
				}
				SL[i].r = nsr;
				SL[i].dir = curDir;
			}
			else if(curDir == 3 || curDir == 4)
			{
				curSpeed = curSpeed % (c * 2 - 2);
				for(int j = 0; j < curSpeed; j++)
				{
					if(nsc == 1)
						curDir = 3;
					else if(nsc == c)
						curDir = 4;
					nsc += dc[curDir];
				}
				SL[i].c = nsc;
				SL[i].dir = curDir;
			}
			SL[i].r = nsr;
			SL[i].c = nsc;
			if(copyField[nsr][nsc] == 0)
				copyField[nsr][nsc] = i + 1;
			else
			{
				int cpIndex = copyField[nsr][nsc] - 1;
				if(SL[cpIndex].size < SL[i].size)
				{
					copyField[nsr][nsc] = i + 1;
					SL[cpIndex].live = 0;
				}
				else
					SL[i].live = 0;
			}
		}
		
		for(int i = 0; i <= r; i++)
			for(int j = 0; j <= c; j++)
				field[i][j] = copyField[i][j];
	}
	
	public static void fishing(int c, int m)
	{
		int min = 105;
		int killIndex = -1;
		
		for(int i = 0; i < m; i++)
		{
			if(SL[i].c == c && SL[i].live == 1)
			{
				if(min > SL[i].r)
				{
					min = SL[i].r;
					killIndex = i;
				}
			}
		}
		if(killIndex == -1) return;
		else
		{
			SL[killIndex].live = 0;
			ret += SL[killIndex].size;
			field[SL[killIndex].r][SL[killIndex].c] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[r + 1][c + 1];
		SL = new Sharka[m];
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			SL[i] = new Sharka(sr, sc, speed, dir, z, 1);
			field[sr][sc] = i + 1;
		}
		
		for(int i = 1; i <= c; i++)
		{
			fishing(i, m);
			sharkMove(r, c, m);
		}
		System.out.println(ret);
	}
}