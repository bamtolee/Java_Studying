package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15917B {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; i++)
		{
			int a = Integer.parseInt(br.readLine());
			int sum = 0;
			
			while(a != 0)
			{
				if((a & 1) == 1) sum++;
				a = a >> 1;
			}
			if(sum == 1) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		System.out.println(sb.toString());
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; i++)
		{
			int a = Integer.parseInt(br.readLine());
			int sum = 0;
			
			while(a != 0)
			{
				if((a & 1) == 1) sum++;
				a = a >> 1;
			}
			if(sum == 1) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		System.out.println(sb.toString());
		*/
	}
}
