package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_D2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			int snail[][] = new int[n][n];
			int sRow = 0, sCol = 0;
			int eRow = n - 1, eCol = n - 1;
			int value = 1;

			sb.append("#").append(test_case).append("\n");
			for(int i = 0; i < n / 2; i++)
			{
				for(int j = sCol; j <= eCol; j++)
				{
					snail[sRow][j] = value;
					value++;
				}
				for(int j = sRow + 1; j <= eRow; j++)
				{
					snail[j][eCol] = value;
					value++;
				}
				for(int j = eCol - 1; j >= sCol; j--)
				{
					snail[eRow][j] = value;
					value++;
				}
				for(int j = eRow - 1; j > sRow; j--)
				{
					snail[j][sCol] = value;
					value++;
				}
				sRow++; eRow--; sCol++; eCol--;
			}
			if(n % 2 != 0) snail[n / 2][n / 2] = value;
			
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
					sb.append(snail[i][j]).append(" ");
				if(i != n - 1) sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}
}
