package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865G {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int knapsack[][] = new int[n + 1][k + 1];
		int weight[] = new int[n + 1];
		int value[] = new int[n + 1];
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= k; j++)
			{
				if(j >= weight[i])
					knapsack[i][j] = Math.max(knapsack[i - 1][j - weight[i]] + value[i], knapsack[i - 1][j]);
				else
					knapsack[i][j] = knapsack[i - 1][j];
			}
		}
		System.out.println(knapsack[n][k]);
	}
}
