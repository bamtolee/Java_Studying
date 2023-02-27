package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3344P {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		if(n % 6 == 3)
		{
			for(int i = 2; i <= n / 2; i++)
				sb.append((i * 2) + "\n");
			sb.append(2 + "\n");
		}
		else
			for(int i = 1; i <= n / 2; i++)
				sb.append((i * 2) + "\n");
		
		if(n % 6 == 2)
		{
			sb.append(3 + "\n" + 1 + "\n");
			for(int i = 3; i < n / 2; i++)
				sb.append((i * 2 + 1) + "\n");
			sb.append(5 + "\n");
		}
		else if(n % 6 == 3)
		{
			for(int i = 2; i <= n / 2; i++)
				sb.append((i * 2 + 1) + "\n");
			sb.append(1 + "\n" + 3 + "\n");
		}
		else
		{
			for(int i = 0; i < n / 2; i++)
				sb.append((i * 2 + 1) + "\n");
			if(n % 2 == 1) sb.append(n + "\n");
		}
		System.out.println(sb.toString());
	}
}
