package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= T; i++)
		{
			int n = Integer.parseInt(br.readLine());
			List<Integer> pwdList = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				pwdList.add(Integer.parseInt(st.nextToken()));
			int commandNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < commandNum; j++)
			{
				st.nextToken();
				int addIndex = Integer.parseInt(st.nextToken());
				int addCount = Integer.parseInt(st.nextToken());
				for(int k = 0; k < addCount; k++)
					pwdList.add(addIndex + k, Integer.parseInt(st.nextToken()));
			}
			sb.append("#" + i + " ");
			for(int j = 0; j < 10; j++)
				sb.append(pwdList.get(j) + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
