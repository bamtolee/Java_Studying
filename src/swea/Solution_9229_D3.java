package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= tc; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int snack[] = new int[n];
			int max = -1;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				snack[j] = Integer.parseInt(st.nextToken());

			Arrays.sort(snack);
			for(int j = n - 1; j >= 0; j--)
			{
				if(snack[j] > m) continue;
				for(int k = 0; k < j; k++)
				{
					if(snack[k] + snack[j] > m) break;
					if(snack[k] + snack[j] <= m && snack[k] + snack[j] > max)
						max = snack[k] + snack[j];
				}	
			}
			sb.append("#" + i + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}
}
