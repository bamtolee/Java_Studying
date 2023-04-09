package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B14725G {

	static class Trie{
		boolean isEnd;
		TreeMap<String, Trie> child = new TreeMap<>();
		
		Trie(){
			isEnd = false;
		}
	}
	
	static Trie head = new Trie();
	static StringBuilder sb = new StringBuilder();
	
	static void dfsPrint(Trie cur, String level)
	{
		if(!cur.isEnd)
		{
			for(String key : cur.child.keySet())
			{
				sb.append(level + key + "\n");
				dfsPrint(cur.child.get(key), level + "--");
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			Trie indexT = head;
			for(int j = 0; j < k; j++)
			{
				String tmp = st.nextToken();
				
				if(!indexT.child.containsKey(tmp))
					indexT.child.put(tmp, new Trie());
				indexT = indexT.child.get(tmp);
			}
			indexT.isEnd = true;
		}
		
		dfsPrint(head, "");
		System.out.println(sb.toString());
	}
}
