package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805S {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long tree[] = new long[n];
		long treeMax = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		{
			tree[i] = Long.parseLong(st.nextToken());
			if(treeMax < tree[i]) treeMax = tree[i];
		}
		
		long left = 0;
		long right = treeMax;
		long ret = 0;
		while(left <= right)
		{
			long mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < n; i++)
			{
				if(tree[i] > mid)
					sum += tree[i] - mid;
				if(sum > m) break;
			}
			if(sum >= m)
			{
				if(ret < mid) ret = mid;
				left = mid + 1;
			}
			else right = mid - 1;
		}
		System.out.println(ret);
	}
}
