package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9996S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder regex = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String tmpReg = br.readLine();
		for(int i = 0; i < tmpReg.length(); i++)
		{
			if(tmpReg.charAt(i) != '*') regex.append(tmpReg.charAt(i));
			else
				regex.append("(.*)");
		}
		
		for(int i = 0; i < n; i++)
		{
			String tmp = br.readLine();
			
			boolean flag = tmp.matches(regex.toString());
			if(flag) sb.append("DA\n");
			else sb.append("NE\n");
		}
		System.out.println(sb.toString());
	}
}