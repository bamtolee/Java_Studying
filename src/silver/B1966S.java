package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966S {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int docImportant[] = new int[10];
			int docInd[] = new int[n];
			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
			{
				int imp = Integer.parseInt(st.nextToken());
				docImportant[imp]++;
				docInd[i] = imp;
				q.offer(i);
			}
			
			int seq = 1;
			while(!q.isEmpty())
			{
				int tmpMax = 0;
				for(int i = 1; i <= 9; i++)
					if(tmpMax < i && docImportant[i] > 0) tmpMax = i;
				int cur = q.poll();
				
				if(docInd[cur] < tmpMax)
					q.offer(cur);
				else if(docInd[cur] == tmpMax)
				{
					if(cur == m)
					{
						sb.append(seq + "\n");
						break;
					}
					else
					{
						seq++;
						docImportant[docInd[cur]]--;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
