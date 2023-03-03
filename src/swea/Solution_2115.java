package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115 {

	public static int honeyField[][] = new int[10][10];
	public static int firstH[] = new int[2];
	public static int secondH[] = new int[2];
	public static int maxRet = 0;
	
	public static void profitCal(int n, int m, int c)
	{
		int f[] = new int[m];
		int s[] = new int[m];
		for(int i = 0; i < m; i++)
		{
			f[i] = honeyField[firstH[0]][firstH[1] + i];
			s[i] = honeyField[secondH[0]][secondH[1] + i]; 
		}
		
		int tMaxF = 0;
		int tMaxS = 0;
		for(int i = 1; i <= ((1 << m) - 1); i++)
		{
			int tmpSumF = 0;
			int tmpSumS = 0;
			int checkLimitF = 0;
			int checkLimitS = 0;
			
			for(int j = 0; j < m; j++)
			{
				if((i & (1 << j)) != 0)
				{
					tmpSumF += f[j] * f[j];
					tmpSumS += s[j] * s[j];
					checkLimitF += f[j];
					checkLimitS += s[j];
				}
			}
			if(checkLimitF <= c && tmpSumF > tMaxF) tMaxF = tmpSumF;
			if(checkLimitS <= c && tmpSumS > tMaxS) tMaxS = tmpSumS;
		}
		if(tMaxF + tMaxS > maxRet)
			maxRet = tMaxF + tMaxS;
	}
	
	public static void select(int n, int m, int c)
	{
		for(int i = 0; i < n; i++)
		{
			firstH[0] = i;
			for(int j = 0; j <= n - m; j++)
			{
				firstH[1] = j;
				
				for(int a = i; a < n; a++)
				{
					secondH[0] = a;
					for(int b = 0; b <= n - m; b++)
					{
						if(a == i && b < j + m) continue;
						else
						{
							secondH[1] = b;
							profitCal(n, m, c);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			maxRet = 0;
			
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					honeyField[i][j] = Integer.parseInt(st.nextToken());
			}
			
			select(n, m, c);
			sb.append("#" + tc + " " + maxRet + "\n");
		}
		System.out.println(sb.toString());
	}
}