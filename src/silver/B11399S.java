package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer time[] = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);
		int ret = time[0];
		for(int i = 1; i < n; i++)
		{
			time[i] += time[i - 1];
			ret += time[i];
		}
		System.out.println(ret);
	}
}
