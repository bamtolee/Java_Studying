package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023G {

	public static List<Integer> friend[] = new ArrayList[2000];
	public static int depth, ret;
	public static int visit[] = new int [2000];
	
	public static void dfs(int v)
	{
		visit[v] = 1;
		depth++;
		if(depth == 5)
		{
			ret = 1;
			return;
		}
		for(int i = 0; i < friend[v].size(); i++)
		{
			if(ret == 1) break;
			if(visit[friend[v].get(i)] != 1)
				dfs(friend[v].get(i));
		}
		
		visit[v] = 0;
		depth--;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)
			friend[i] = new ArrayList<>();
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int fa = Integer.parseInt(st.nextToken());
			int fb = Integer.parseInt(st.nextToken());
			friend[fa].add(fb);
			friend[fb].add(fa);
		}
		
		for(int i = 0; i < n; i++)
		{
			dfs(i);
			if(ret == 1) break;
		}
		System.out.println(ret);
	}
}
