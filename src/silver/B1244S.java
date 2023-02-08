package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int sch[] = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			sch[i] = Integer.parseInt(st.nextToken());
		
		int personN = Integer.parseInt(br.readLine());
		int personI[][] = new int[personN][2];
		for(int i = 0; i < personN; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++)
				personI[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < personN; i++)
		{
			if(personI[i][0] == 1)
			{
				for(int j = personI[i][1]; j <= n; j++)
					if(j % personI[i][1] == 0) sch[j] = 1 - sch[j];
			}
			else if(personI[i][0] == 2)
			{
				int tmp = 0;
	
				while(personI[i][1] - tmp >= 1 && personI[i][1] + tmp <= n)
				{
					if(sch[personI[i][1] - tmp] == sch[personI[i][1] + tmp])
					{
						if(tmp == 0) sch[personI[i][1]] = 1 - sch[personI[i][1]];
						else
						{
							sch[personI[i][1] - tmp] = 1 - sch[personI[i][1] - tmp];
							sch[personI[i][1] + tmp] = 1 - sch[personI[i][1] + tmp];
						}
					}
					else break;
					tmp++;
				}
			}
		}
		for(int i = 1; i <= n; i++)
			if(i % 20 == 0)
				sb.append(sch[i]).append("\n");
			else sb.append(sch[i]).append(" ");
		System.out.println(sb.toString());
	}
}
