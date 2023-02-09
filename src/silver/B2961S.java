package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961S {

	public static int taste(int[][] ingredient, int n)
	{
		int minDiff = Integer.MAX_VALUE;
		
		for(int i = 1; i < (1 << n); i++)
		{
			int tmpTasteS = 1;
			int tmpTasteB = 0;
			int tmpDiff = 0;
			for(int j = 0; j < n; j++)
			{
				if((i & (1 << j)) != 0)
				{
					tmpTasteS *= ingredient[j][0];
					tmpTasteB += ingredient[j][1];
				}
			}
			tmpDiff = Math.abs(tmpTasteS - tmpTasteB);
			if(tmpDiff < minDiff) minDiff = tmpDiff;
		}
		return minDiff;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ingredient[][] = new int[n][2];
		int ret;
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ingredient[i][0] = s;
			ingredient[i][1] = b;
		}
		ret = taste(ingredient, n);
		System.out.println(ret);
	}
}
