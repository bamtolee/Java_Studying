package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649S {
	static void nextP(int n, int[] ret, int m, StringBuilder sb, int[] isSelected, int arr_ind)
	{
		if(m == 1)
		{
			for(int i = 0; i < ret.length; i++)
				sb.append(ret[i]).append(" ");
			sb.append("\n");
			return;
		}	
		for(int j = 0; j < n; j++)
		{
			if(isSelected[j] == 1) continue;
			else
			{
				arr_ind++;
				ret[arr_ind] = j + 1;
				isSelected[j] = 1;
				nextP(n, ret, m - 1, sb, isSelected, arr_ind);
				isSelected[j] = 0;
				arr_ind--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ret[] = new int[m];
		
		for(int i = 0; i < n; i++)
		{
			int isSelected[] = new int[n];
			int arr_ind = 0;
			
			isSelected[i] = 1;
			ret[arr_ind] = i + 1;
			nextP(n, ret, m, sb, isSelected, arr_ind);
		}
		System.out.println(sb.toString());
	}
}
