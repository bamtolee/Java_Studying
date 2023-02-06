package silver;

import java.util.Scanner;

public class B14585S{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int co[][] = new int[301][301];
		int n = sc.nextInt();
		int m = sc.nextInt();
		int tmpx, tmpy, maxx = 0, maxy = 0;

		for(int i = 0; i < n; i++)
		{
			tmpx = sc.nextInt();
			tmpy = sc.nextInt();
			if(tmpx > maxx) maxx = tmpx;
			if(tmpy > maxy) maxy = tmpy;
			co[tmpx][tmpy] = m;
		}
		for(int i = 0; i <= maxx; i++)
		{
			for(int j = 0; j <= maxy; j++)
			{
				if(i == 0 && j > 0)
				{
					if(co[i][j] - (i + j) >= 0)
						co[i][j] = co[i][j - 1] + co[i][j] - (i + j);
					else
						co[i][j] = co[i][j - 1];
				}
				else if(i > 0 && j == 0)
				{
					if(co[i][j] - (i + j) > 0)
						co[i][j] = co[i - 1][j] + co[i][j] - (i + j);
					else
						co[i][j] = co[i - 1][j];
				}
				else if(i != 0 && j != 0)
				{
					if(co[i][j - 1] > co[i - 1][j])
					{
						if(co[i][j] - (i + j) >= 0)
							co[i][j] = co[i][j - 1] + co[i][j] - (i + j);
						else
							co[i][j] = co[i][j - 1];
					}
					else
					{
						if(co[i][j] - (i + j) > 0)
							co[i][j] = co[i - 1][j] + co[i][j] - (i + j);
						else
							co[i][j] = co[i - 1][j];
					}
				}
			}
		}
		System.out.println(co[maxx][maxy]);
		sc.close();
	}
}
