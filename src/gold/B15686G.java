package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15686G {

	public static int minRet = 100000000;
	
	public static int twoPointDistance(int r1, int c1, int r2, int c2)
	{
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	
	public static void combination(int start, int[] combSave, int[][] chicken, int[][] home, int totalC, int totalH, int m, int cnt)
	{
		if(cnt == m)
		{
			int ret = 0;
			for(int i = 0; i < totalH; i++)
			{
				int tmpMin = 100000000;
				for(int j = 0; j < m; j++)
				{
					int tmpD = twoPointDistance(chicken[combSave[j]][0], chicken[combSave[j]][1], home[i][0], home[i][1]);
					if (tmpD < tmpMin) tmpMin = tmpD;
				}
				ret += tmpMin;
			}
			if(ret < minRet) minRet = ret;
		}
		else
		{
			for(int i = start; i < totalC; i++)
			{
				combSave[cnt] = i;
				combination(i + 1, combSave, chicken, home, totalC, totalH, m, cnt + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int chicken[][] = new int[13][2];
		int home[][] = new int[2 * n][2];
		int combSave[] = new int[m];
		int totalC = 0;
		int totalH = 0;
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
			{
				int tmp = Integer.parseInt(st2.nextToken());
				if(tmp == 2)
				{
					chicken[totalC][0] = i;
					chicken[totalC][1] = j;
					totalC++;
				}
				else if(tmp == 1)
				{
					home[totalH][0] = i;
					home[totalH][1] = j;
					totalH++;
				}
			}
		}
		
		combination(0, combSave, chicken, home, totalC, totalH, m, 0);
		System.out.println(minRet);
	}
}
