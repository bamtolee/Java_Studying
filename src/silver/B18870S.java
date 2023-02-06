package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B18870S {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tmp[] = new int[n];
		int tmp2[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> m = new HashMap<>();
		int count = 0;
		
		for(int i = 0; i < n; i++)
		{
			tmp[i] = Integer.parseInt(st.nextToken());
			tmp2[i] = tmp[i];
		}
		Arrays.sort(tmp2);
		for(int i = 0; i < n; i++)
		{
			if(i > 0 && tmp2[i] == tmp2[i - 1])
				count++;
			m.putIfAbsent(tmp2[i], i - count);
		}
		for(int i = 0; i < n; i++)
			sb.append(m.get(tmp[i])).append(" ");
		System.out.println(sb.toString());
	}
}
