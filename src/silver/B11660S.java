package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][n];
		int pre_sum[][] = new int[n][n + 1];
		
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++)
		{
			pre_sum[i][0] = 0;
			pre_sum[i][1] = arr[i][0];
			for(int j = 2; j < n + 1; j++)
				pre_sum[i][j] = pre_sum[i][j - 1] + arr[i][j - 1];
		}
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ret = 0;
			
			for(int j = x1 - 1; j <= x2 - 1; j++)
				ret += pre_sum[j][y2] - pre_sum[j][y1 - 1];
			
			sb.append(ret).append("\n");
		}
		System.out.println(sb.toString());
	}
}
