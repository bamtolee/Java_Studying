package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_5658 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			List<Integer> q = new ArrayList<>();
			Set<Integer> s = new TreeSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String tmp = br.readLine();
			for(int i = 0; i < n; i++)
			{
				if(tmp.charAt(i) < 'A')
					q.add(tmp.charAt(i) - '0');
				else
					q.add(tmp.charAt(i) - 'A' + 10);
			}
			
			int ind1 = 0;
			int ind2 = n / 4;
			int ind3 = n / 2;
			int	ind4 = n / 4 * 3;
			for(int i = 0; i < n / 4; i++)
			{
				int num1 = q.get(ind1);
				int num2 = q.get(ind2);
				int num3 = q.get(ind3);
				int num4 = q.get(ind4);
				for(int j = 1; j < n / 4; j++)
				{
					num1 *= 16;
					num2 *= 16;
					num3 *= 16;
					num4 *= 16;
					num1 += q.get((ind1 + j) % n);
					num2 += q.get((ind2 + j) % n);
					num3 += q.get((ind3 + j) % n);
					num4 += q.get((ind4 + j) % n);
				}
				s.add(num1);
				s.add(num2);
				s.add(num3);
				s.add(num4);
				ind2--;
				ind3--;
				ind4--;
				if(ind1 == 0) ind1 = n - 1;
				else ind1--;
			}
			
			List<Integer> li = new ArrayList<>(s);
			
			sb.append("#" + tc + " " + li.get(li.size() - k) + "\n");
		}
		System.out.println(sb.toString());
	}
}
