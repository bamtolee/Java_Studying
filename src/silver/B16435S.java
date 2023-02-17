package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16435S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int h[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			h[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(h);
		for(int i = 0; i < n; i++)
		{
			if(h[i] <= l) l++;
			else break;
		}
		System.out.println(l);
	}
}
