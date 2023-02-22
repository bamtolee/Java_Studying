package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10812B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int basket[] = new int[n + 1];
		for(int i = 1; i <= n ; i++)
			basket[i] = i;
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			Queue<Integer> temp = new LinkedList<>();
			for(int j = mid; j <= end; j++)
				temp.add(basket[j]);
			for(int j = begin; j <= mid - 1; j++)
				temp.add(basket[j]);
			for(int j = begin; j <= end; j++)
				basket[j] = temp.poll();
		}
		for(int i = 1; i <= n; i++)
			sb.append(basket[i] + " ");
		System.out.println(sb.toString());
	}
}
