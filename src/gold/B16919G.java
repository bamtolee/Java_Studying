package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16919G {

	static char field[][] = new char[201][201];
	static char stat[][][] = new char[9][201][201];
	static int dr[] = {0, 1, 0, -1, 0};
	static int dc[] = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < r; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < c; j++)
			{
				field[i][j] = tmp.charAt(j);
				stat[0][i][j] = field[i][j];
				stat[1][i][j] = field[i][j];
				stat[2][i][j] = 'O';
			}
		}
		
		for(int i = 3; i <= 8; i++)
		{
			if(i % 2 == 1)
			{
				for(int a = 0; a < r; a++)
					for(int b = 0; b < c; b++)
						stat[i][a][b] = stat[i - 1][a][b];
				
				for(int a = 0; a < r; a++)
				{
					for(int b = 0; b < c; b++)
					{
						if(stat[i - 2][a][b] == 'O')
						{
							for(int j = 0; j < 5; j++)
							{
								int na = a + dr[j];
								int nb = b + dc[j];
								if(na >= 0 && na < r && nb >= 0 && nb < c)
									stat[i][na][nb] = '.';
							}
						}
					}
				}			
			}
			else
			{
				for(int a = 0; a < r; a++)
					for(int b = 0; b < c; b++)
						stat[i][a][b] = 'O';
			}
		}
		
		if(n >= 1 && n <= 8)
		{
			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
					sb.append(stat[n][i][j]);
				sb.append("\n");
			}
		}
		else
		{
			n %= 4;
			n += 4;
			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
					sb.append(stat[n][i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}