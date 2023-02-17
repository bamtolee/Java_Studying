package silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1620S {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> pokemon = new HashMap<>();
 		int n = sc.nextInt();
		int m = sc.nextInt();
		String tmp1, tmp2;
		int itmp;
		
		for(int i = 0; i < n; i++)
		{
			tmp1 = sc.next();
			tmp2 = Integer.toString(i + 1);
			pokemon.put(tmp2, tmp1);
			pokemon.put(tmp1, tmp2);
		}
		for(int i = 0; i < m; i++)
		{
			itmp = -1;
			tmp1 = sc.next();
			if(tmp1.charAt(0) <= 57 && tmp1.charAt(0) >= 48) itmp = Integer.parseInt(tmp1);
			if(itmp == -1)
				System.out.println(pokemon.get(tmp1));
			else
				System.out.println(pokemon.get(Integer.toString(itmp)));
		}
		sc.close();
	}
}
