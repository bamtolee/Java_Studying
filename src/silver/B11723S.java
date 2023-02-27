package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B11723S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> s = new HashSet<>();
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("add"))
			{
				int num = Integer.parseInt(st.nextToken());
				s.add(num);
			}
			else if(cmd.equals("remove"))
			{
				int num = Integer.parseInt(st.nextToken());
				s.remove(num);
			}
			else if(cmd.equals("toggle"))
			{
				int num = Integer.parseInt(st.nextToken());
				if(s.contains(num)) s.remove(num);
				else s.add(num);
			}
			else if(cmd.equals("empty")) s.clear();
			else if(cmd.equals("all"))
			{
				s.clear();
				for(int i = 1; i <= 20; i++)
					s.add(i);
			}
			else if(cmd.equals("check"))
			{
				int num = Integer.parseInt(st.nextToken());
				if(s.contains(num)) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
