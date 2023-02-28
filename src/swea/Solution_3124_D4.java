package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int u;
	int v;
	int weight;
	public Edge(int u, int v, int weight) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}

public class Solution_3124_D4 {

	public static int p[];
	
	public static void make(int x)
	{
		p[x] = x;
	}
	
	public static int find(int x)
	{
		if(p[x] == x) return x;
		else return p[x] = find(p[x]);
	}
	
	public static void union(int x, int y)
	{
		int xx = find(x);
		int yy = find(y);
		
		if(xx != yy)
		{
			if(xx > yy) p[xx] = yy;
			else p[yy] = xx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++)
		{
			List<Edge> el = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long ret = 0;
			p = new int[v + 1];
			for(int i = 1; i <= v; i++)
				make(i);
			
			for(int i = 0; i < e; i++)
			{
				st = new StringTokenizer(br.readLine());
				el.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			Collections.sort(el);
			int i = 0, ti = 0;
			while(true)
			{
				int a = find(el.get(i).u);
				int b = find(el.get(i).v);
				if(a != b)
				{
					union(a, b);
					ti++;
					ret += (long)el.get(i).weight;
				}
				if(ti == v - 1) break;
				i++;
			}
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
