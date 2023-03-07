package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16953S {

	public static int ret = 1;
	
	public static void bfs(int a, int b)
	{
		boolean retFlag = false;
		Queue<Long> q = new ArrayDeque<>();
		q.offer((long)a);
		
		while(true)
		{
			int qSize = q.size();
			long min = 2000000000;
			ret++;
			
			for(int i = 0; i < qSize; i++)
			{
				long tmp = q.poll();
				
				if(tmp > 1000000000) continue;
				if(min > tmp)
					min = tmp;
				long t1 = tmp * 2;
				long t2 = tmp * 10 + 1;
				if(t1 == b || t2 == b)
				{
					retFlag = true;
					break;
				}
				q.offer(t1);
				q.offer(t2);
			}
			if(min > (long)b)
			{
				ret = -1;
				break;
			}
			if(retFlag) break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		bfs(a, b);
		System.out.println(ret);
	}
}
