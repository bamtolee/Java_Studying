package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {

	public static boolean nextPermu(int[] arr)
	{
		int i = arr.length - 1;
		int j = arr.length - 1;
		int tmp;
		
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		if(i == 0) return false;
		while(arr[i - 1] >= arr[j]) j--;
		tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		j = arr.length - 1;
		for(; i < j; i++, j--)
		{
			tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			int retMin = 100000000;
			int ingredient[][] = new int[n][n];
			int combination[] = new int[n];
			boolean flag = true;
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(i >= n / 2) combination[i] = 1;
				for(int j = 0; j < n; j++)
					ingredient[i][j] = Integer.parseInt(st.nextToken());
			}
			
			while(flag)
			{
				int sum1 = 0, sum2 = 0;
				
				for(int i = 0; i < n; i++)
				{
					if(combination[i] == 1)
					{
						for(int j = 0; j < n; j++)
							if(combination[j] == 1) sum1 += ingredient[j][i];
					}
					else if(combination[i] == 0)
					{
						for(int j = 0; j < n; j++)
							if(combination[j] == 0) sum2 += ingredient[j][i];
					}
				}
				if((int)(Math.abs(sum2 - sum1)) < retMin) retMin = (int)(Math.abs(sum2 - sum1));
				flag = nextPermu(combination);
			}
			sb.append("#" + tc + " " + retMin + "\n");
		}
		System.out.println(sb.toString());
	}
}
