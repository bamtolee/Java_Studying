package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class QueueInfor {
	int index;
	int count;
	
	public QueueInfor(int index, int count)
	{
		this.index = index;
		this.count = count;
	}
}

public class B1389S {

	public static int bfsKV(int visited[], List<Integer> kv[], int start)
	{
		Queue<QueueInfor> q = new LinkedList<>();
		int kvSum = 0;
		
		q.add(new QueueInfor(start, 0));
		visited[start] = 1;
		while(!q.isEmpty())
		{
			int tmp = q.peek().index;
			int count = q.peek().count + 1;
			q.remove();
			for(int i : kv[tmp])
			{
				if(visited[i] == 0)
				{
					visited[i] = 1;
					kvSum += count;
					QueueInfor QI = new QueueInfor(i, count);
					q.add(QI);
				}
			}
		}
		return kvSum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> kv[] = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++)
			kv[i] = new ArrayList<>();
		int kvMin = Integer.MAX_VALUE, ret = -1;
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			kv[x].add(y);
			kv[y].add(x);
		}
		
		for(int i = 1; i <= n; i++)
		{
			int visited[] = new int[n + 1];
			int kvSum = bfsKV(visited, kv, i);
			if(kvSum < kvMin)
			{
				kvMin = kvSum;
				ret = i;
			}
		}
		System.out.println(ret);
	}
}
