package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17390S {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int sum[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		sum[0] = arr[0];
		for(int i = 1; i < n; i++)
			sum[i] = sum[i - 1] + arr[i];
		
		for(int i = 0; i < q; i++)
		{
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int tmp = sum[r - 1] - sum[l - 1] + arr[l - 1];
			sb.append(tmp + "\n");
		}
		System.out.println(sb.toString());
	}
}
