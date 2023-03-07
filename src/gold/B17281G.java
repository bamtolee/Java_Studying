package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17281G {

	public static int infor[][] = new int[50][9];
	public static int hitPer[] = new int[9];
	public static int visit[] = new int[9];
	public static int retScore;
	
	public static void scoreCal(int n)
	{
		int tmpScore = 0;
		int hitIndex = 0;
		
		for(int i = 0; i < n; i++)
		{
			int outCount = 0;
			int baseStat[] = new int[3];
			while(outCount < 3)
			{
				int cur = hitPer[hitIndex];
				if(infor[i][cur] == 0) outCount++;
				else if(infor[i][cur] == 1)
				{
					if(baseStat[2] == 1)
					{
						baseStat[2] = 0;
						tmpScore++;
					}
					if(baseStat[1] == 1)
					{
						baseStat[1] = 0;
						baseStat[2] = 1;
					}
					if(baseStat[0] == 1)
					{
						baseStat[1] = 1;
						baseStat[0] = 0;
					}
					baseStat[0] = 1;
				}
				else if(infor[i][cur] == 2)
				{
					tmpScore += baseStat[2] + baseStat[1];
					if(baseStat[0] == 1)
					{
						baseStat[0] = 0;
						baseStat[2] = 1;
					}
					else baseStat[2] = 0;
					baseStat[1] = 1;
				}
				else if(infor[i][cur] == 3)
				{
					tmpScore += baseStat[1] + baseStat[2] + baseStat[0];
					baseStat[2] = 1;
					baseStat[1] = 0;
					baseStat[0] = 0;
				}
				else
				{
					tmpScore += baseStat[0] + baseStat[1] + baseStat[2] + 1;
					for(int j = 0; j < 3; j++) baseStat[j] = 0;
				}
				hitIndex = (hitIndex + 1) % 9;
			}
		}
		if(tmpScore > retScore) retScore = tmpScore;
	}
	
	public static void permutation(int n, int count)
	{
		if(count == 9)
			scoreCal(n);
		else
		{
			for(int i = 1; i < 9; i++)
			{
				if(visit[i] == 0)
				{
					hitPer[count] = i;
					visit[i] = 1;
					if(count == 2)
						permutation(n, count + 2);
					else
						permutation(n, count + 1);
					visit[i] = 0;
				}	
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)
				infor[i][j] = Integer.parseInt(st.nextToken());
		}
		
		hitPer[3] = 0;
		visit[0] = 1;
		permutation(n, 0);
		System.out.println(retScore);
	}
}
