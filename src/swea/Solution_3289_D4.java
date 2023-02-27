package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_D4 {

	public static int p[];
	
	public static void makeSet(int x)
	{
		p[x] = x;
	}
	
	public static int findSet(int x)
	{
		if(x == p[x]) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void union(int x, int y)
	{
		int a = findSet(x);
		int b = findSet(y);
		if(a != b)
		{
			if(a < b)
				p[b] = a;
			else
				p[a] = b;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#" + tc + " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n + 1];
			
			for(int i = 1; i <= n; i++)
				makeSet(i);
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cmd == 0)
					union(a, b);
				else if(cmd == 1)
				{
					int s1 = findSet(a);
					int s2 = findSet(b);
					if(s1 == s2) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
