package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15961G {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sushi[] = new int[2 * n];
		int countSushi[] = new int[d + 1];
		for(int i = 0; i < n; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < n - 1; i++)
			sushi[n + i] = sushi[i];
		
		int ret = 0;
		for(int i = 0; i < k; i++)
		{
			if(countSushi[sushi[i]] == 0) ret++;
			countSushi[sushi[i]]++;
		}
		if(countSushi[c] == 0) ret++;
		countSushi[c]++;
		int tmp = ret;
		for(int i = k; i < n + k; i++)
		{
			countSushi[sushi[i - k]]--;
			if(countSushi[sushi[i - k]] == 0) tmp--;
			if(countSushi[sushi[i]] == 0) tmp++;
			countSushi[sushi[i]]++;
			if(tmp > ret) ret = tmp;
		}
		System.out.println(ret);
	}
}