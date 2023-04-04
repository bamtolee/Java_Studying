package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1786P {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String t = br.readLine();
		String p = br.readLine();
		int tl = t.length(), pl = p.length();
		int pre[] = new int[pl];
		
		for(int i = 1, j = 0; i < pl; i++)
		{
			while(j > 0 && p.charAt(i)!= p.charAt(j)) j = pre[j - 1];
			
			if(p.charAt(i) == p.charAt(j)) pre[i] = ++j;
			else pre[i] = 0;
		}
		
		int count = 0;
		List<Integer> indexList = new ArrayList<>();
		for(int i = 0, j = 0; i < tl; i++)
		{
			while(j > 0 && t.charAt(i) != p.charAt(j)) j = pre[j - 1];
			if(t.charAt(i) == p.charAt(j))
			{
				if(j == pl - 1)
				{
					indexList.add(i - j + 1);
					j = pre[j];
					count++;
				}
				else j++;
			}
		}
		sb.append(count + "\n");
		if(count != 0)
			for(int i : indexList)
				sb.append(i + " ");
		System.out.println(sb.toString());
	}
}
