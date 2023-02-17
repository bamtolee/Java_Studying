package silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B14425S {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> s = new HashSet<>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ret = 0;
		
		for(int i = 0; i < n; i++)
			s.add(sc.next());
		for(int i = 0; i < m; i++)
		{
			if(s.contains(sc.next())) ret++;
		}
		System.out.println(ret);
		sc.close();
	}
}