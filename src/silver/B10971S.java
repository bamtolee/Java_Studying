package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971S {

	static int cost[][] = new int[11][11];
	static int perm[] = new int[11];
	static int visit[] = new int[11];
	static int minRet = Integer.MAX_VALUE;
	
	public static void minCal(int n)
	{
		int tempSum = 0;
		boolean flag = false;
		for(int i = 0; i < n - 1; i++)
		{
			if(cost[perm[i]][perm[i + 1]] == 0)
			{
				flag = true;
				break;
			}
			tempSum += cost[perm[i]][perm[i + 1]];
		}
		if(cost[perm[n - 1]][perm[0]] != 0 && !flag)
			tempSum += cost[perm[n - 1]][perm[0]];
		else if(cost[perm[n - 1]][perm[0]] == 0) flag = true;
		
		if(!flag && tempSum < minRet) minRet = tempSum;
	}
	
	public static void permutation(int n, int count)
	{
		if(count == n)
		{
			minCal(n);
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				if(visit[i] == 1) continue;
				perm[count] = i;
				visit[i] = 1;
				permutation(n, count + 1);
				visit[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		
		permutation(n, 0);
		System.out.println(minRet);
	}
}
