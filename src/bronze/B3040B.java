package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3040B {

	public static boolean combination(int arr[], int ret[], int count, int start, boolean flag)
	{
		if(count == ret.length)
		{
			int tmp = 0;
			for(int i : ret)
				tmp += i;
			if(tmp == 100)
				flag = true;
			return flag;
		}
		else
		{
			for(int i = start; i < arr.length; i++)
			{
				ret[count] = arr[i];
				if(!flag)
					flag = combination(arr, ret, ++count, ++start, flag);
				count--;
				if(flag) break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[9];
		int ret[] = new int[7];
		boolean flag = false;
		
		for(int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 3; i++)
		{
			flag = combination(arr, ret, 0, i, flag);
			if(flag) break;
		}
		for(int i = 0; i < 7; i++)
			sb.append(ret[i]).append("\n");
		System.out.println(sb.toString());
	}
}