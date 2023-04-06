package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_D4 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxD = Math.abs(Integer.parseInt(st.nextToken()))
					 + Math.abs(Integer.parseInt(st.nextToken()));
			int r = maxD % 2;
			for(int i = 1; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int sum = Math.abs(x) + Math.abs(y);
				if(sum % 2 != r)
				{
					maxD = -1;
					for(int j = i + 1; j < n; j++)
						br.readLine();
					break;
				}
				if(sum > maxD) maxD = sum;
			}
			
			if(maxD != -1)
			{
				int cnt = 0;
				while(maxD > 0)
				{
					cnt++;
					maxD -= cnt;
				}
				maxD = Math.abs(maxD);
				if(maxD % 2 == 1)
				{
					if(cnt % 2 == 1)
						cnt += 2;
					else
						cnt += 1;
				}
				maxD = cnt;
			}
			sb.append("#" + tc + " " + maxD + "\n");
		}
		System.out.println(sb.toString());
	}
}
