package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Enemy{
	int r;
	int c;
	int live;
	public Enemy(int r, int c, int live) {
		super();
		this.r = r;
		this.c = c;
		this.live = live;
	}
}

public class B17135G {

	public static int field[][] = new int[16][16];
	public static int possibleArcher[] = new int[16];
	public static int curArcher[] = new int[3];
	public static int n, m, d, ret;
	
	public static int dist(int r1, int r2, int c1, int c2)
	{
		return Math.abs(r1- r2) + Math.abs(c1 - c2);
	}
	
	public static void killEnemy()
	{
		List<Enemy> e = new ArrayList<>();
		int tmpRet = 0;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(field[i][j] == 1) e.add(new Enemy(i, j, 1));
		
		for(int i = 0; i < n; i++)
		{
			int minArcher[] = {500, 500, 500};
			int minI[] = {-1, -1, -1};
			for(int j = 0; j < e.size(); j++)
			{
				for(int k = 0; k < 3; k++)
				{
					if(dist(n, e.get(j).r, curArcher[k], e.get(j).c) <= d && e.get(j).live != 0)
					{
						if(minArcher[k] > dist(n, e.get(j).r, curArcher[k], e.get(j).c))
						{
							minArcher[k] = dist(n, e.get(j).r, curArcher[k], e.get(j).c);
							minI[k] = j;
						}
						else if(minArcher[k] == dist(n, e.get(j).r, curArcher[k], e.get(j).c))
						{
							if(e.get(minI[k]).c > e.get(j).c) minI[k] = j;
						}
					}
				}
			}
			for(int j = 0; j < 3; j++)
			{
				if(minI[j] != -1)
				{
					if(e.get(minI[j]).live == 1)
					{
						tmpRet++;
						e.get(minI[j]).live = 0;
					}
				}
			}
			for(int j = 0; j < e.size(); j++)
			{
				e.get(j).r++;
				if(e.get(j).r >= n) e.get(j).live = 0;
			}
		}
		if(tmpRet > ret)
			ret = tmpRet;
	}
	
	public static void combination(int count, int start)
	{
		if(count == 3)
		{
			killEnemy();
			return;
		}
		else
		{
			for(int i = start; i < m; i++)
			{
				curArcher[count] = possibleArcher[i];
				combination(count + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				field[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < m; i++)
			possibleArcher[i] = i;
		combination(0, 0);
		System.out.println(ret);
	}
}
