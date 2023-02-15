package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286S {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
			if(Math.abs(x) == Math.abs(y)) return x - y;
			else return Math.abs(x) - Math.abs(y);
					});
		
		for(int i = 0; i < n; i++)
		{
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) pq.add(x);
			else
			{
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
