package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {

	static int map[][] = new int[21][21];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int ret = 0;
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int seqRowMap[][] = new int[n][n];
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(j == 0) seqRowMap[i][j] = 1;
					else
					{
						if(map[i][j] == map[i][j - 1])
							seqRowMap[i][j] = seqRowMap[i][j - 1] + 1;
						else
						{
							int k = seqRowMap[i][j - 1];
							for(int l = j - k; l < j; l++)
								seqRowMap[i][l] = k;
							seqRowMap[i][j] = 1;
						}
					}
					if(j == n - 1)
					{
						int k = seqRowMap[i][j];
						for(int l = j - k + 1; l <= j; l++)
							seqRowMap[i][l] = k;
					}
				}
			}
			int seqColMap[][] = new int[n][n];
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(j == 0) seqColMap[j][i] = 1;
					else
					{
						if(map[j][i] == map[j - 1][i])
							seqColMap[j][i] = seqColMap[j - 1][i] + 1;
						else
						{
							int k = seqColMap[j - 1][i];
							for(int l = j - k; l < j; l++)
								seqColMap[l][i] = k;
							seqColMap[j][i] = 1;
						}
					}
					if(j == n - 1)
					{
						int k = seqColMap[j][i];
						for(int l = j - k + 1; l <= j; l++)
							seqColMap[l][i] = k;
					}
				}
			}
			
			for(int i = 0; i < n; i++)
			{
				boolean flag = true;
				for(int j = 0; j < n; j++)
				{
					if(j == 0) continue;
					if(map[i][j] == map[i][j - 1]) continue;
					else
					{
						if(Math.abs(map[i][j] - map[i][j - 1]) >= 2)
						{
							flag = false;
							break;
						}
						else if(map[i][j] + 1 == map[i][j - 1])
						{
							if(seqRowMap[i][j] < x)
							{
								flag = false;
								break;
							}
							int k = map[i][j];
							int l = j;
							while(l < n && map[i][l] == k)
							{
								seqRowMap[i][l] -= x;
								l++;
							}
						}
						else if(map[i][j] == map[i][j - 1] + 1)
						{
							if(seqRowMap[i][j - 1] < x)
							{
								flag = false;
								break;
							}
						}
					}
				}
				if(flag) ret++;
			}
			for(int i = 0; i < n; i++)
			{
				boolean flag = true;
				for(int j = 0; j < n; j++)
				{
					if(j == 0) continue;
					if(map[j][i] == map[j - 1][i]) continue;
					else
					{
						if(Math.abs(map[j][i] - map[j - 1][i]) >= 2)
						{
							flag = false;
							break;
						}
						else if(map[j][i] + 1 == map[j - 1][i])
						{
							if(seqColMap[j][i] < x)
							{
								flag = false;
								break;
							}
							int k = map[j][i];
							int l = j;
							while(l < n && map[l][i] == k)
							{
								seqColMap[l][i] -= x;
								l++;
							}
						}
						else if(map[j][i] == map[j - 1][i] + 1)
						{
							if(seqColMap[j - 1][i] < x)
							{
								flag = false;
								break;
							}
						}
					}
				}
				if(flag) ret++;
			}
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
