package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV{
	int r;
	int c;
	int type;
	int direction;
	public CCTV(int r, int c, int type) {
		super();
		this.r = r;
		this.c = c;
		this.type = type;
	}
}

public class B15683G {

	public static int office[][] = new int[8][8];
	public static int monitor[][] = new int[8][8];
	public static List<CCTV> CCTVLi = new ArrayList<>();
	public static int dr[] = {0, -1, 0, 1};
	public static int dc[] = {1, 0, -1, 0};
	public static int n, m, ret;
	
	public static void monitorCal()
	{
		int notMSum = 0;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				monitor[i][j] = office[i][j];
		
		for(int i = 0; i < CCTVLi.size(); i++)
		{
			int r = CCTVLi.get(i).r;
			int c = CCTVLi.get(i).c;
			int d = CCTVLi.get(i).direction;
			int dir[] = {d, (d + 1) % 4, (d + 2) % 4, (d + 3) % 4};
			int nc[] = {c + dc[dir[0]], c + dc[dir[1]], c + dc[dir[2]], c + dc[dir[3]]};
			int nr[] = {r + dr[dir[0]], r + dr[dir[1]], r + dr[dir[2]], r + dr[dir[3]]};
			
			while(nc[0] >= 0 && nc[0] < m && nr[0] >= 0 && nr[0] < n)
			{
				if(monitor[nr[0]][nc[0]] == 6) break;
				monitor[nr[0]][nc[0]] = -1;
				nc[0] += dc[dir[0]];
				nr[0] += dr[dir[0]];
			}
			if(CCTVLi.get(i).type > 2)
			{
				while(nc[1] >= 0 && nc[1] < m && nr[1] >= 0 && nr[1] < n)
				{
					if(monitor[nr[1]][nc[1]] == 6) break;
					monitor[nr[1]][nc[1]] = -1;
					nc[1] += dc[dir[1]];
					nr[1] += dr[dir[1]];
				}
			}
			if(CCTVLi.get(i).type == 2 || CCTVLi.get(i).type > 3)
			{
				while(nc[2] >= 0 && nc[2] < m && nr[2] >= 0 && nr[2] < n)
				{
					if(monitor[nr[2]][nc[2]] == 6) break;
					monitor[nr[2]][nc[2]] = -1;
					nc[2] += dc[dir[2]];
					nr[2] += dr[dir[2]];
				}
			}
			if(CCTVLi.get(i).type == 5)
			{
				while(nc[3] >= 0 && nc[3] < m && nr[3] >= 0 && nr[3] < n)
				{
					if(monitor[nr[3]][nc[3]] == 6) break;
					monitor[nr[3]][nc[3]] = -1;
					nc[3] += dc[dir[3]];
					nr[3] += dr[dir[3]];
				}
			}
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(monitor[i][j] == 0) notMSum++;
		if(ret > notMSum) ret = notMSum;
	}
	
	public static void dfsCCTV(int v)
	{
		if(v + 1 > CCTVLi.size())
			monitorCal();
		else
		{
			switch(CCTVLi.get(v).type)
			{
			case 1 :
			case 3 :
			case 4 :
				for(int i = 0; i < 4; i++)
				{
					CCTVLi.get(v).direction = i;
					dfsCCTV(v + 1);
				}
				break;
			case 2 : 
				for(int i = 0; i < 2; i++)
				{
					CCTVLi.get(v).direction = i;
					dfsCCTV(v + 1);
				}
				break;
			case 5:
				CCTVLi.get(v).direction = 1;
				dfsCCTV(v + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ret = n * m;
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
			{
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] >= 1 && office[i][j] <= 5)
					CCTVLi.add(new CCTV(i, j, office[i][j]));
			}
		}
		dfsCCTV(0);
		System.out.println(ret);
	}
}
