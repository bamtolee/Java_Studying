package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_D4 {

	public static int roomMov(int[][] room, int i, int j, int n, int mov)
	{
		int dr[] = {1, 0, 0, -1};
		int dc[]= {0, 1, -1, 0};
		
		for(int d = 0; d < 4; d++)
		{
			if(i + dr[d] >= 0 && i + dr[d] < n && j + dc[d] >= 0 && j + dc[d] < n
					&& room[i + dr[d]][j + dc[d]] - room[i][j] == 1)
				mov = roomMov(room, i + dr[d], j + dc[d], n, ++mov);
		}
		return mov;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int room[][] = new int[n][n];
			int min = 1010, movMax = 0;
			for(int j = 0; j < n; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++)
					room[j][k] = Integer.parseInt(st.nextToken());
			}

			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < n; k++)
				{
					int tmpMov = roomMov(room, j, k, n, 1);
					if(tmpMov > movMax)
					{
						movMax = tmpMov;
						min = room[j][k];
					}
					else if(tmpMov == movMax)
						if(min > room[j][k]) min = room[j][k];
				}
			}
			sb.append("#" + i + " ").append(min + " " + movMax + "\n");
		}
		System.out.println(sb.toString());
	}
}
