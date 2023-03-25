package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int to;
	int d;
	
	public Node(int to, int d) {
		super();
		this.to = to;
		this.d = d;
	}
	@Override
	public int compareTo(Node o) {
		return this.d - o.d;
	}
}

public class B1753G {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int inf = Integer.MAX_VALUE;
		List<Node> li[] = new ArrayList[v + 1];
		int d[] = new int[v + 1];
		for(int i = 1; i <= v; i++)
			li[i] = new ArrayList<>();
		Arrays.fill(d, inf);

		for(int i = 0; i < e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			li[from].add(new Node(to, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[k] = 0;
		pq.offer(new Node(k, 0));
		while(!pq.isEmpty())
		{
			Node tmp = pq.poll();
			int cur = tmp.to;
			if(tmp.d > d[cur]) continue;

			for(int j = 0; j < li[cur].size(); j++)
			{
				int to = li[cur].get(j).to;
				if(li[cur].get(j).d + tmp.d < d[to])
				{
					d[to] = li[cur].get(j).d + tmp.d;
					pq.offer(new Node(to, d[to]));
				}
			}
		}
		for(int i = 1; i <= v; i++)
			sb.append((d[i] == inf ? "INF" : d[i]) + "\n");
		System.out.println(sb.toString());
	}
}
