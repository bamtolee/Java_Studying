package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1439S {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int consecutive[] = new int[2];
		
		for(int i = 1; i < str.length(); i++)
		{
			if(str.charAt(i) != str.charAt(i - 1))
				consecutive[str.charAt(i - 1) - '0']++;
		}
		consecutive[str.charAt(str.length() - 1) - '0']++;
		System.out.println(consecutive[0] > consecutive[1] ? consecutive[1] : consecutive[0]);
	}
}

