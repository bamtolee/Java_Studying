package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10026G {

	public static char grid[][] = new char[100][100];
	public static int visitRGB[][] = new int[100][100];
	public static int visitRB[][] = new int[100][100];
	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static void dfsRGB(int curR, int curC, int n, char colour)
	{
		visitRGB[curR][curC] = 1;
		
		for(int i = 0; i < 4; i++)
		{
			int ncurR = curR + dr[i];
			int ncurC = curC + dc[i];
			if(ncurR >= 0 && ncurR < n && ncurC >= 0 && ncurC < n && visitRGB[ncurR][ncurC] != 1)
			{
				if(grid[ncurR][ncurC] == colour)
					dfsRGB(ncurR, ncurC, n, colour);
			}
		}
	}
	
	public static void dfsRB(int curR, int curC, int n, char colour)
	{
		visitRB[curR][curC] = 1;
		
		for(int i = 0; i < 4; i++)
		{
			int ncurR = curR + dr[i];
			int ncurC = curC + dc[i];
			if(ncurR >= 0 && ncurR < n && ncurC >= 0 && ncurC < n && visitRB[ncurR][ncurC] != 1)
			{
				if(colour == 'R' || colour == 'G')
				{
					if(grid[ncurR][ncurC] == 'R' || grid[ncurR][ncurC] == 'G')
						dfsRB(ncurR, ncurC, n, colour);
				}
				else if(colour == 'B' && colour == grid[ncurR][ncurC])
					dfsRB(ncurR, ncurC, n, colour);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int retRGB = 0, retRB = 0;
		
		for(int i = 0; i < n; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < n; j++)
				grid[i][j] = tmp.charAt(j);
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(visitRGB[i][j] != 1)
				{
					dfsRGB(i, j, n, grid[i][j]);
					retRGB++;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(visitRB[i][j] != 1)
				{
					dfsRB(i, j, n, grid[i][j]);
					retRB++;
				}
			}
		}
		System.out.println(retRGB + " " + retRB);
	}
}
