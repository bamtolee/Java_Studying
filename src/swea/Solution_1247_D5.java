package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Co{
	int x;
	int y;
	
	public Co(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class Solution_1247_D5 {
	
	static boolean nextPermu(int[] arr)
	{
		int a = arr.length - 1;
		int b = arr.length - 1;
		int tmp;
		
		while(a > 0 && arr[a - 1] >= arr[a]) a--;
		if(a == 0) return false;
		while(arr[a - 1] > arr[b]) b--;
		tmp = arr[a - 1];
		arr[a - 1] = arr[b];
		arr[b] = tmp;
		
		b = arr.length - 1;
		for(; a < b; a++, b--)
		{
			tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
		return true;
	}
	
	public static int dist(Co co1, Co co2)
	{
		return Math.abs(co1.x - co2.x) + Math.abs(co1.y - co2.y);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			int min = 10000000;
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Co office = new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Co home = new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Co customer[] = new Co[n];
			for(int i = 0; i < n; i++)
				customer[i] = new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int perm[] = new int[n];
			for(int i = 0; i < n; i++)
				perm[i] = i;
			boolean flag = true;
			
			while(flag)
			{
				int tmpD = dist(office, customer[perm[0]]);
				int f = 0;
				
				for(int i = 1; i < n; i++)
				{
					if(tmpD > min)
					{
						f = 1;
						continue;
					}
					tmpD += dist(customer[perm[i - 1]], customer[perm[i]]);
				}
				if(f == 1)
				{
					flag = nextPermu(perm);
					continue;
				}
				tmpD += dist(customer[perm[n - 1]], home);
				if(tmpD < min) min = tmpD;
				flag = nextPermu(perm);
			}
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
}
