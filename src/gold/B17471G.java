package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471G {

	public static int pop[];
	public static List<Integer> Adj[];
	public static int visit[];
	public static int totPop;
	public static int min = 2100000000;
	
	public static boolean bfsDivideDistrict0(int n, int check, int start)
	{
		int tmpSum = 0;
		int tmpVisit[] = new int[n + 1];
		tmpVisit = Arrays.copyOf(visit, n + 1);
		Queue<Integer> q = new LinkedList<>();
		
		tmpVisit[start] = 0;
		q.offer(start);
		tmpSum += pop[start];
		while(!q.isEmpty())
		{
			int tmp = q.poll();
			for(int i = 0; i < Adj[tmp].size(); i++)
			{
				int next = Adj[tmp].get(i);
				if(tmpVisit[next] == 1)
				{
					tmpVisit[next] = 0;
					q.offer(next);
					tmpSum += pop[next];
				}
			}
		}
		if(tmpSum != check) return false;
		else return true;
	}
	
	public static boolean bfsDivideDistrict1(int n, int check, int start)
	{
		int tmpSum = 0;
		int tmpVisit[] = new int[n + 1];
		tmpVisit = Arrays.copyOf(visit, n + 1);
		Queue<Integer> q = new LinkedList<>();
		
		tmpVisit[start] = 1;
		q.offer(start);
		tmpSum += pop[start];
		while(!q.isEmpty())
		{
			int tmp = q.poll();
			for(int i = 0; i < Adj[tmp].size(); i++)
			{
				int next = Adj[tmp].get(i);
				if(tmpVisit[next] == 0)
				{
					tmpVisit[next] = 1;
					q.offer(next);
					tmpSum += pop[next];
				}
			}
		}
		if(tmpSum != check) return false;
		else return true;
	}
	
	public static void subset(int n)
	{
		for(int i = 1; i < (1 << n) - 1; i++)
		{
			Arrays.fill(visit, 0);
			int tmpSum = 0, tmpSum2 = 0, start = -1, start2 = -1;
			boolean flag1 = false, flag2 = false;
			
			for(int j = 0; j < n; j++)
			{
				if((i & (1 << j)) != 0 && start == -1)
					start = j + 1;
				if((i & (1 << j)) == 0)
				{
					if(start2 == -1) start2 = j + 1;
					visit[j + 1] = 1;
					tmpSum += pop[j + 1];
				}
			}
			tmpSum2 = totPop - tmpSum;
			flag1 = bfsDivideDistrict1(n, tmpSum2, start);
			flag2 = bfsDivideDistrict0(n, tmpSum, start2);
			if(flag1 && flag2)
				if(min > Math.abs(tmpSum2 - tmpSum)) min = Math.abs(tmpSum2 - tmpSum);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pop = new int[n + 1];
		Adj = new ArrayList[n + 1];
		visit = new int[n + 1];
		for(int i = 1; i <= n; i++)
		{
			pop[i] = Integer.parseInt(st.nextToken());
			totPop += pop[i];
			Adj[i] = new ArrayList<>();
		}
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(st.nextToken());
			
			for(int k = 0; k < aNum; k++)
			{
				int to = Integer.parseInt(st.nextToken());
				Adj[i].add(to);
				Adj[to].add(i);
			}
		}
		
		subset(n);
		if(min == 2100000000) System.out.println(-1);
		else System.out.println(min);
	}
}
