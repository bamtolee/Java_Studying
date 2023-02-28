package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_D4 {
	
	public static int visit[] = new int[101];
	
	public static int bfs(int start, List<Integer> contact[])
	{
		Arrays.fill(visit, 0);

		int lastMax = 0;
		int realMax = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = 1;
		
		while(!q.isEmpty())
		{
			int levelSize = q.size();
			realMax = lastMax;
			lastMax = 0;
			for(int i = 0; i < levelSize; i++)
			{
				int tmp = q.poll();
				for(int j = 0; j < contact[tmp].size(); j++)
				{
					int adj = contact[tmp].get(j);
					if(visit[adj] != 1)
					{
						q.offer(adj);
						visit[adj] = 1;
						if(adj > lastMax) lastMax = adj;
					}
				}
			}
		}
		return realMax;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++)
		{
			int ret = 0;
			List<Integer> contact[] = new ArrayList[101];
			for(int i = 1; i <= 100; i++)
				contact[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < l / 2; i++)
			{
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from].add(to);
			}
			ret = bfs(start, contact);
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}
