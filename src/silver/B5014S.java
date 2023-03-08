package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014S {
	
	public static int arr[] = new int[1000001];
	public static int visit[] = new int[1000001];
	public static int ret = -1;
	
	public static void bfs(int f, int s, int g, int u, int d)
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visit[s] = 1;
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(cur == g)
			{
				ret = arr[cur];
				break;
			}
			
			if(cur + u <= f && visit[cur + u] == 0)
			{
				visit[cur + u] = 1;
				q.offer(cur + u);
				arr[cur + u] = arr[cur] + 1;
			}
			if(cur - d >= 1 && visit[cur - d] == 0)
			{
				visit[cur - d] = 1;
				q.offer(cur - d);
				arr[cur - d] = arr[cur] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		bfs(f, s, g, u, d);
		if(ret == -1) System.out.println("use the stairs");
		else System.out.println(ret);
	}
}