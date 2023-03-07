package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096G {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int curVal[] = new int[3];
		int minS[] = new int[3];
		int maxS[] = new int[3];
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				curVal[j] = Integer.parseInt(st.nextToken());
				
			if(i == 0)
			{
				for(int j = 0; j < 3; j++)
				{
					minS[j] = curVal[j];
					maxS[j] = curVal[j];
				}
			}
			else
			{
				int tmp1, tmp2, tmp3;
				tmp1 = Math.max(curVal[0] + maxS[0], curVal[0] + maxS[1]);
				tmp2 = Math.max(Math.max(curVal[1] + maxS[0], curVal[1] + maxS[1]),
						curVal[1] + maxS[2]);
				tmp3 = Math.max(curVal[2] + maxS[1], curVal[2] + maxS[2]);
				maxS[0] = tmp1; maxS[1] = tmp2; maxS[2] = tmp3;
				
				tmp1 = Math.min(curVal[0] + minS[0], curVal[0] + minS[1]);
				tmp2 = Math.min(Math.min(curVal[1] + minS[0], curVal[1] + minS[1]),
						curVal[1] + minS[2]);
				tmp3 = Math.min(curVal[2] + minS[1], curVal[2] + minS[2]);
				minS[0] = tmp1; minS[1] = tmp2; minS[2] = tmp3;
			}
		}
		
		sb.append(Math.max(Math.max(maxS[0], maxS[1]), maxS[2]) + " " +
					Math.min(Math.min(minS[0], minS[1]), minS[2]));
		System.out.println(sb.toString());
	}
}
