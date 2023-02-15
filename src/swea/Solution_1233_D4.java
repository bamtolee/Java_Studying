package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int i = 1; i <= T; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int ret = 1;
			
			for(int j = 1; j <= n / 2; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodNum = Integer.parseInt(st.nextToken());
				String arith = st.nextToken();
				int left = Integer.parseInt(st.nextToken());
				int right;
				if(j != n / 2)
					right = Integer.parseInt(st.nextToken());
				else if(j == n / 2 && n % 2 != 0)
					right = Integer.parseInt(st.nextToken());
				if(arith.charAt(0) >= '0' && arith.charAt(0) <= '9')
					ret = 0;
			}
			for(int j = n / 2 + 1; j <= n; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodNum = Integer.parseInt(st.nextToken());
				String arith = st.nextToken();
				if(!(arith.charAt(0) >= '0' && arith.charAt(0) <= '9'))
					ret = 0;
			}
			
			if(n % 2 == 0) ret = 0;
			
			sb.append("#" + i + " ").append(ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
