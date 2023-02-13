package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650S {

	public static void combination(int[] arr, int[] ret, int count, int index, StringBuilder sb)
	{
		if(count == ret.length)
		{
			for(int i = 0; i < ret.length; i++)
				sb.append(ret[i]).append(" ");
			sb.append("\n");
			return;
		}
		else
		{
			for(int i = index + 1; i < arr.length; i++)
			{
				ret[count] = arr[i];
				count++;
				combination(arr, ret, count, i, sb);
				count--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int ret[] = new int[m];
		int count = 0;
		
		for(int i = 1; i <= n; i++)
			arr[i - 1] = i;
		for(int i = 0; i < n; i++)
		{
			count = 0;
			ret[count] = arr[i];
			count++;
			combination(arr, ret, count, i, sb);
		}
		System.out.println(sb.toString());
	}
}
