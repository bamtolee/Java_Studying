package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2448G {
	
	public static char star[][] = new char[3073][6146];
	
	public static void fillStar(int n, int r, int c)
	{
		if(n == 3)
		{
			star[r][c] = '*';
			star[r + 1][c - 1] = '*';
			star[r + 1][c + 1] = '*';
			for(int i = 0; i < 5; i++)
				star[r + 2][c - 2 + i] = '*';
		}
		else
		{
			fillStar(n / 2, r + n / 2, c - n / 2);
			fillStar(n / 2, r, c);
			fillStar(n / 2, r + n / 2, c + n / 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < 2 * n; j++)
				star[i][j] = ' ';
		fillStar(n, 0, n - 1);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < 2 * n; j++)
				sb.append(star[i][j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
