package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074S {

	public static int findZ(int n, int r, int c, int ret)
	{
		if(n == 2)
		{
			if(r == 0 && c == 0) return ret;
			else if(r == 0 && c == 1) return ret + 1;
			else if(r == 1 && c == 0) return ret + 2;
			else return ret + 3;
		}
		if(r < n / 2 && c < n / 2)
			ret = findZ(n / 2, r, c, ret);
		else if(r < n / 2 && c >= n / 2)
			ret = findZ(n / 2, r, c - n / 2, ret + ((n / 2) * (n / 2)));
		else if(r >= n / 2 && c < n / 2)
			ret = findZ(n / 2, r - n / 2, c, ret + 2 * ((n / 2) * (n / 2)));
		else
			ret = findZ(n / 2, r - n / 2, c - n / 2, ret + 3 * ((n / 2) * (n / 2)));
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int i = 1, a = 2, ret = 0;
		while(n > 0)
		{
			if(n % 2 == 1) 
				i *= a;
			a *= a;
			n /= 2;
		}
		
		ret = findZ(i, r, c, ret);
		System.out.println(ret);
	}
}
