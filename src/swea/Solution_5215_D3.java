package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_D3 {

	public static int maxTasteSubset(int taste[], int cal[], int n, int l)
	{
		int retMax = 0;
		int tmpSum;
		int curCal;
		
		for(int i = 0; i < (1 << n); i++)
		{
			tmpSum = 0;
			curCal = 0;
			for(int j = 0; j < n; j++)
			{
				if((i & (1 << j)) != 0)
				{
					curCal += cal[j];
					if(curCal > l) break;
					tmpSum += taste[j];
				}
			}
			if(curCal > l) continue;
			else if(tmpSum > retMax) retMax = tmpSum;
		}
		return retMax;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int ret = 0;
			int taste[] = new int[n];
			int cal[] = new int[n];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st2.nextToken());
				cal[i] = Integer.parseInt(st2.nextToken());
			}
			
			ret = maxTasteSubset(taste, cal, n, l);
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
