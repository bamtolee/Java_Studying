package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3307_D3 {
	
	static int lower_bound(List<Integer> list, int k)
	{
		int left = 0;
		int right = list.size();
		while(left < right)
		{
			int mid = (left + right) / 2;
			int cur = list.get(mid);
			if(cur < k) left = mid + 1;
			else right = mid;
		}
		return right;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n + 1];
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			list.add(arr[0]);
			for(int i = 1; i < n; i++)
			{
				if(arr[i] > list.get(list.size() - 1))
					list.add(arr[i]);
				else
				{
					int tmp = lower_bound(list, arr[i]);
					list.set(tmp, arr[i]);
				}
			}
			sb.append("#" + tc + " " + list.size() + "\n");
		}
		System.out.println(sb.toString());
	}
}
