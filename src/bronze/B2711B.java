package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2711B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int miss = Integer.parseInt(st.nextToken());
			char str[] = st.nextToken().toCharArray();
			
			for(int j = 0; j < str.length; j++)
			{
				if(j == miss - 1) continue;
				sb.append(str[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
