package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16935S {

	public static void arrUpsideDown(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ret[i][j] = arr[n - 1 - i][j];
	}
	
	public static void arrMirror(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ret[i][j] = arr[i][m - 1 - j];
	}
	
	public static void arrRotateRight(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ret[j][n - 1 - i] = arr[i][j];
	}
	
	public static void arrRotateLeft(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ret[m - 1 - j][i] = arr[i][j];
	}
	
	public static void arrRotate5(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n / 2; i++)
			for(int j = 0; j < m / 2; j++)
				ret[i][j] = arr[i + n / 2][j];
		for(int i = 0; i < n / 2; i++)
			for(int j = m / 2; j < m; j++)
				ret[i][j] = arr[i][j - m / 2];
		for(int i = n / 2; i < n; i++)
			for(int j = m / 2; j < m; j++)
				ret[i][j] = arr[i - n / 2][j];
		for(int i = n / 2; i < n; i++)
			for(int j = 0; j < m / 2; j++)
				ret[i][j] = arr[i][j + m / 2];
	}
	
	public static void arrRotate6(int arr[][], int ret[][], int n, int m)
	{
		for(int i = 0; i < n / 2; i++)
			for(int j = 0; j < m / 2; j++)
				ret[i + n / 2][j] = arr[i][j];
		for(int i = 0; i < n / 2; i++)
			for(int j = m / 2; j < m; j++)
				ret[i][j - m / 2] = arr[i][j];
		for(int i = n / 2; i < n; i++)
			for(int j = m / 2; j < m; j++)
				ret[i - n / 2][j] = arr[i][j];
		for(int i = n / 2; i < n; i++)
			for(int j = 0; j < m / 2; j++)
				ret[i][j + m / 2] = arr[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][m];
		int rotation[] = new int[r];
		int ret[][];
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++)
			rotation[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; i++)
		{
			switch(rotation[i]) {
			case 1:
				ret = new int[n][m];
				arrUpsideDown(arr, ret, n, m);
				break;
			case 2:
				ret = new int[n][m];
				arrMirror(arr, ret, n, m);
				break;
			case 3:
				ret = new int[m][n];
				arrRotateRight(arr, ret, n, m);
				break;
			case 4:
				ret = new int[m][n];
				arrRotateLeft(arr, ret, n, m);
				break;
			case 5:
				ret = new int[n][m];
				arrRotate5(arr, ret, n, m);
				break;
			default:
				ret = new int[n][m];
				arrRotate6(arr, ret, n, m);
			}
			
			arr = ret;
			if(rotation[i] == 3 || rotation[i] == 4)
			{
				int tmp = m;
				m = n;
				n = tmp;
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
