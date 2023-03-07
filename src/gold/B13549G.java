package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549G {
	
	public static int arr[] = new int[100001];
	public static int visit[] = new int[100001];
	public static int ret;
	
	public static void bfs(int n, int k)
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		visit[n] = 1;
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(cur == k)
			{
				ret = arr[cur];
				break;
			}
			
			if(cur * 2 <= 100000 && visit[cur * 2] == 0)
			{
				visit[cur * 2] = 1;
				q.offer(cur * 2);
				arr[cur * 2] = arr[cur];
			}
			if(cur - 1 >= 0 && visit[cur - 1] == 0)
			{
				visit[cur - 1] = 1;
				q.offer(cur - 1);
				arr[cur - 1] = arr[cur] + 1;
			}
			if(cur + 1 <= 100000 && visit[cur + 1] == 0)
			{
				visit[cur + 1] = 1;
				q.offer(cur + 1);
				arr[cur + 1] = arr[cur] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n, k);
		System.out.println(ret);
	}
}
