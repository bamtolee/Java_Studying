package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5549G {

	public static char map[][] = new char[1001][1001];
	public static int sum[][][] = new int[1001][1001][3];
	
	public static void calSum(int m, int n, char target)
	{
		int check;
		
		if(target == 'J') check = 0;
		else if(target == 'O') check = 1;
		else check = 2;
		
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				sum[i][j][check] = sum[i - 1][j][check] + sum[i][j - 1][check] - sum[i - 1][j - 1][check];
				if(target == map[i][j])
					sum[i][j][check]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		for(int i = 1; i <= m; i++)
		{
			String tmp = br.readLine();
			for(int j = 1; j <= n; j++)
				map[i][j] = tmp.charAt(j - 1);
		}
		
		calSum(m, n, 'J');
		calSum(m, n, 'O');
		calSum(m, n, 'I');
		
		while(k-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int preSum[] = new int[3];
			
			for(int i = 0; i < 3; i++)
				preSum[i] = sum[c][d][i] - sum[c][b - 1][i] - sum[a - 1][d][i] + sum[a - 1][b - 1][i];
			
			sb.append(preSum[0] + " " + preSum[1] + " " + preSum[2] + "\n");
		}
		System.out.println(sb.toString());
	}
}
