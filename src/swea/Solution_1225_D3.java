package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++)
		{
			int tsc = Integer.parseInt(br.readLine());
			Queue<Integer> pwdQueue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 8; j++)
				pwdQueue.offer(Integer.parseInt(st.nextToken()));
			int subCount = 1;
			
			while(true)
			{
				int tmp = pwdQueue.poll();
				tmp -= subCount;
				if(tmp <= 0)
				{
					pwdQueue.offer(0);
					break;
				}
				pwdQueue.offer(tmp);
				subCount++;
				if(subCount >= 6) subCount = 1;
			}
			sb.append("#" + tsc + " ");
			for(int j = 0; j < 8; j++)
				sb.append(pwdQueue.poll() + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
