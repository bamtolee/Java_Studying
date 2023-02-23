package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class countTime{
	int n;
	int time;
	public countTime(int n, int time) {
		super();
		this.n = n;
		this.time = time;
	}
}

public class B1697S {

	public static int bfs(int n, int k)
	{
		if(n == k) return 0;
		int visit[] = new int[100001];
		int ret = 0;
		
		Queue<countTime> q = new ArrayDeque<>();
		visit[n] = 1;
		q.offer(new countTime(n, 0));
		while(!q.isEmpty())
		{
			countTime tmp = q.poll();
			
			if(tmp.n == k)
			{
				ret = tmp.time;
				break;
			}
			if(tmp.n * 2 <= 100000 && visit[tmp.n * 2] != 1)
			{
				q.offer(new countTime(tmp.n * 2, tmp.time + 1));
				visit[tmp.n * 2] = 1;
			}
			if(tmp.n - 1 >= 0 && visit[tmp.n - 1] != 1)
			{
				q.offer(new countTime(tmp.n - 1, tmp.time + 1));
				visit[tmp.n - 1] = 1;
			}
			if(tmp.n + 1 <= 100000 && visit[tmp.n + 1] != 1)
			{
				q.offer(new countTime(tmp.n + 1, tmp.time + 1));
				visit[tmp.n + 1] = 1;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ret = bfs(n, k);
		System.out.println(ret);
	}
}
