package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992S {
	
	public static void quadTree(int arr[][], int n, int r, int c, StringBuilder sb)
	{
		int count = 0;
		for(int i = r; i < r + n; i++)
		{
			for(int j = c; j < c + n; j++)
				count += arr[i][j];
		}
		if(count == 0) sb.append("0");
		else if(count == n * n) sb.append("1");
		else
		{
			sb.append("(");
			quadTree(arr, n / 2, r, c, sb);
			quadTree(arr, n / 2, r, c + n / 2, sb);
			quadTree(arr, n / 2, r + n / 2, c, sb);
			quadTree(arr, n / 2, r + n / 2, c + n / 2, sb);
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		
		for(int i = 0; i < n; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < n; j++)
				arr[i][j] = tmp.charAt(j) - '0';
		}
		quadTree(arr, n, 0, 0, sb);
		System.out.println(sb.toString());
	}
}
