package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018S {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ret = 1;
		int j = 1, tmpSum = 1;
		
		for(int i = 1; i <= n / 2; i++)
		{
			while(true)
			{
				if(tmpSum > n) break;
				if(tmpSum == n)
				{
					ret++;
					break;
				}
				j++;
				tmpSum += j;
			}
			tmpSum -= i;
		}
		System.out.println(ret);
	}
}
