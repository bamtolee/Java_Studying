package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124P_D4 {
	
	static int V,E;
	static ArrayList<Edge>[] list;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			long result = 0;
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			
			list = new ArrayList[V+1]; //인접리스트
			
			for(int i=0; i<V+1; i++) {
				list[i] = new ArrayList<Edge>();
			}
			
			for(int i=0; i<E; i++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(tokens.nextToken());
				int B = Integer.parseInt(tokens.nextToken());
				int C = Integer.parseInt(tokens.nextToken());
				list[A].add(new Edge(B,C));
				list[B].add(new Edge(A,C));
			}
			
			result = prim();
			
			sb.append(result).append('\n');
		}
		System.out.println(sb.toString());

	}//main
	
	
	private static long prim() {
		long min = 0;
		boolean[] visit = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(!visit[cur.v]) {
				visit[cur.v] = true;
				min += cur.w;
				
				for(int i=0,size = list[cur.v].size(); i<size; i++) {
					Edge temp = list[cur.v].get(i);
					if(!visit[temp.to]) {
						pq.offer(new Node(temp.to,temp.len));
					}
				}
			}
		}
		
		return min;
	}//prim
	
	static class Edge{
		int to, len;
		public Edge(int to, int len) {
			this.to = to;
			this.len = len;
		}
	}
	
	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}//end class
