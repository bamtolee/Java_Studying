package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17136G {

	static int paper[][] = new int[11][11];
	static int check[][] = new int[11][11];
	static int colourPaper[] = new int[6];
	static int ret = 1000000;
	
	static void coverPaper(int r, int c)
	{
		if(r == 10)
		{
			int sum = 0;
			for(int i = 1; i <= 5; i++)
				sum += colourPaper[i];
			if(sum < ret) ret = sum;
		}
		else
		{
			if(paper[r][c] == 0)
			{
				if(c + 1 == 10)
					coverPaper(r + 1, 0);
				else
					coverPaper(r, c + 1);
			}
			else
			{
				if(check[r][c] == 1)
				{
					if(c + 1 == 10)
						coverPaper(r + 1, 0);
					else
						coverPaper(r, c + 1);
				}
				else
				{
					for(int i = 5; i >= 1; i--)
					{
						if(colourPaper[i] >= 5)
							continue;
						
						boolean flag = true;
						for(int j = r; j <= r + i - 1; j++)
							for(int k = c; k <= c + i - 1; k++)
								if(j >= 10 || k >= 10 ||
								paper[j][k] == 0 || check[j][k] == 1)
									flag = false;
						if(!flag) continue;
						colourPaper[i]++;
						for(int j = r; j <= r + i - 1; j++)
							for(int k = c; k <= c + i - 1; k++)
								check[j][k] = 1;
						if(c + 1 == 10)
							coverPaper(r + 1, 0);
						else
							coverPaper(r, c + 1);
						colourPaper[i]--;
						for(int j = r; j <= r + i - 1; j++)
							for(int k = c; k <= c + i - 1; k++)
								check[j][k] = 0;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		coverPaper(0, 0);
		if(ret == 1000000)
			System.out.println(-1);
		else
			System.out.println(ret);
	}
}
