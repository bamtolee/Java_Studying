package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2567S {

	public static int dr[] = {0, 1, 0, -1};
	public static int dc[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s[][] = new int[101][101];
		int ret = 0;
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j = a; j < a + 10; j++)
				for(int k = b; k < b + 10; k++)
					s[j][k] = 1;
		}
		
		for(int i = 0; i <= 100; i++)
		{
			for(int j = 0; j <= 100; j++)
			{
				if(s[i][j] == 1)
				{
					for(int k = 0; k < 4; k++)
					{
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr >= 0 && nr <= 100 && nc >= 0 && nc <= 100)
							if(s[nr][nc] == 0) ret++;
					}
				}
			}
		}
		System.out.println(ret);
	}
}
