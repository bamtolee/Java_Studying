package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493G {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> tower = new Stack<>();
		Stack<Integer> index = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> ret = new ArrayList<>();
		
		for(int i = 1; i <= n; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			if(tower.isEmpty())
			{
				tower.push(tmp);
				index.push(i);
				ret.add(0);
				continue;
			}
			if(tower.peek() < tmp)
			{
				while(!tower.isEmpty())
				{
					if(tmp > tower.peek())
					{
						tower.pop();
						index.pop();
					}
					else break;
				}
				tower.push(tmp);
				if(index.isEmpty()) ret.add(0);
				else ret.add(index.peek());
				index.push(i);
			}
			else
			{
				tower.push(tmp);
				ret.add(index.peek());
				index.push(i);
			}
		}
		if(Collections.max(ret) == 0) sb.append(0);
		else
			for(Integer i : ret)
				sb.append(i).append(" ");
		System.out.println(sb.toString());
	}
}
