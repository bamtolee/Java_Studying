package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17406G_2 {
	
	static int minArr(int[][] arr)
	{
		int min = 2147483647;
		
		for(int i = 0; i < arr.length; i++)
		{
			int tmp_sum = 0;
			
			for(int j = 0; j < arr[i].length; j++)
				tmp_sum += arr[i][j];
			if(tmp_sum < min) min = tmp_sum;
		}
		return min;
	}
	
	static boolean next_permu(int[] arr)
	{
		int a = arr.length - 1;
		int b = arr.length - 1;
		int tmp;
		
		while(a > 0 && arr[a - 1] >= arr[a]) a--;
		if(a == 0) return false;
		while(arr[a - 1] > arr[b]) b--;
		tmp = arr[a - 1];
		arr[a - 1] = arr[b];
		arr[b] = tmp;
		
		b = arr.length - 1;
		for(; a < b; a++, b--)
		{
			tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
		return true;
	}
	
	static void arrRotation(int[][] arr, int[] rot)
	{
		int tmp1, tmp2, s = rot[2];
		int s_row = rot[0] - s - 1;
		int s_column = rot[1] - s - 1;
		int e_row = rot[0] + s - 1;
		int e_column = rot[1] + s - 1;
		
		for(int i = 0; i < s; i++)
		{
			tmp1 = arr[s_row][e_column];
			for(int j = e_column; j > s_column; j--)
				arr[s_row][j] = arr[s_row][j - 1];
			
			tmp2 = arr[e_row][e_column];
			for(int j = e_row; j > s_row; j--)
				arr[j][e_column] = arr[j - 1][e_column];
			arr[s_row + 1][e_column] = tmp1;
			
			tmp1 = arr[e_row][s_column];
			for(int j = s_column; j < e_column; j++)
				arr[e_row][j] = arr[e_row][j + 1];
			arr[e_row][e_column - 1] = tmp2;
			
			for(int j = s_row; j < e_row; j++)
				arr[j][s_column] = arr[j + 1][s_column];
			arr[e_row - 1][s_column] = tmp1;
			
			s_row++; s_column++; e_row--; e_column--;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ret = 2147483647;
		int arr[][] = new int[n][m];
		int tmp[][] = new int[n][m];
		int rot[][] = new int[k][3];
		int per[] = new int[k];
		boolean flag = true;

		for(int i = 0; i < n; i++)
		{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st2.nextToken());
		}
		for(int i = 0; i < k; i++)
		{
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				rot[i][j] = Integer.parseInt(st3.nextToken());
		}
		for(int i = 0; i < k; i++)
			per[i] = i;
		
		while(flag)
		{
			int tmp_ret;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					tmp[i][j] = arr[i][j];
			for(int i = 0; i < k; i++)
				arrRotation(tmp, rot[per[i]]);
			tmp_ret = minArr(tmp);
			if(tmp_ret < ret) ret = tmp_ret;
			flag = next_permu(per);
		}
		System.out.println(ret);
	}
}