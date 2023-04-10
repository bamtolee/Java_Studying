package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2383 {

	static class Co{
		int r;
		int c;
		
		public Co(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int room[][] = new int[11][11];
	static Co stair[] = new Co[2];
	static Co human[] = new Co[11];
	static int humanNum;
	static int ret;
	
	static void powerSet(int n)
	{
		for(int i = 0; i < (1 << humanNum); i++)
		{
			int time0 = -1, time1 = -1;
			List<Integer> stair0 = new ArrayList<>();
			List<Integer> stair1 = new ArrayList<>();
			for(int j = 0; j < humanNum; j++)
			{
				if((i & (1 << j)) != 0)
				{
					int arrivalTime = Math.abs(human[j].r - stair[0].r)
							+ Math.abs(human[j].c - stair[0].c);
					stair0.add(arrivalTime);
				}
				else
				{
					int arrivalTime = Math.abs(human[j].r - stair[1].r)
							+ Math.abs(human[j].c - stair[1].c);
					stair1.add(arrivalTime);
				}
			}
			
			Collections.sort(stair0);
			Collections.sort(stair1);
			if(!stair0.isEmpty())
			{
				Queue<Integer> q = new ArrayDeque<>();
				int downTime = room[stair[0].r][stair[0].c] + 1;
				for(int j = 0; j < stair0.size(); j++)
				{
					if(q.size() < 3)
						q.offer(stair0.get(j) + downTime);
					else
					{
						int tmp = q.poll();
						if(tmp > stair0.get(j))
							q.offer(tmp + downTime - 1);
						else
							q.offer(stair0.get(j) + downTime);
					}
				}
				while(q.size() > 1)
					q.poll();
				time0 = q.poll();
			}
			if(!stair1.isEmpty())
			{
				Queue<Integer> q = new ArrayDeque<>();
				int downTime = room[stair[1].r][stair[1].c] + 1;
				for(int j = 0; j < stair1.size(); j++)
				{
					if(q.size() < 3)
						q.offer(stair1.get(j) + downTime);
					else
					{
						int tmp = q.poll();
						if(tmp > stair1.get(j))
							q.offer(tmp + downTime - 1);
						else
							q.offer(stair1.get(j) + downTime);
					}
				}
				while(q.size() > 1)
					q.poll();
				time1 = q.poll();
			}
			if(time0 < time1) time0 = time1;
			if(ret > time0) ret = time0;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			int stairCount = 0;
			humanNum = 0;
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
				{
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j] == 1)
					{
						human[humanNum] = new Co(i, j);
						humanNum++;
					}
					else if(room[i][j] >= 2)
					{
						stair[stairCount] = new Co(i, j);
						stairCount++;
					}
				}
			}
			
			ret = 1000000;
			powerSet(n);
			sb.append("#" + tc + " " + ret + "\n");
		}
		System.out.println(sb.toString());
	}
}