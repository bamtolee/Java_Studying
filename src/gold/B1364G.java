package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1364G {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long ret = 0;
		int count = 1;
		
		for(int i = 1; i <= n; i++)
		{
			if(i >= 6 && i % 6 == 1) ret--;
			if(i % 6 == 0) count++;
			ret += (long)count;
		}
		System.out.println(ret);
	}
}
