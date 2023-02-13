package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2447G {
	
	static void starFill(int[][] star, int n, int x, int y)
	{
		if(x / n % 3 == 1 && y / n  % 3== 1)
			star[x][y] = 0;
		else if(n / 3 == 0)
			star[x][y] = 1;
		else
			starFill(star, n / 3, x, y);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int star[][] = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				starFill(star, n, i, j);
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(star[i][j] == 1) sb.append("*");
				else sb.append(" ");			
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
