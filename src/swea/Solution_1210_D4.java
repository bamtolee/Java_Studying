package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_D4
{
	public static void main(String args[]) throws Exception
	{
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			int visited[][] = new int[100][100];
			int coY = -1;
			int coX = -1;
			
			for(int i = 0; i < 100; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2)
					{
						coY = i;
						coX = j;
					}
				}
			}
			
			visited[coY][coX] = 1;
			while(coY != 0)
			{
				if(coX - 1 >= 0 && visited[coY][coX - 1] != 1 && arr[coY][coX - 1] == 1)
					coX = coX - 1;
				else if(coX + 1 < 100 && visited[coY][coX + 1] != 1 && arr[coY][coX + 1] == 1)
					coX = coX + 1;
				else coY--;
				visited[coY][coX] = 1;
			}
			sb.append("#").append(tc).append(" ").append(coX).append("\n");
		}
		System.out.println(sb.toString());
	}
}