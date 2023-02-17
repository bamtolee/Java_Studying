package silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B10815S {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> s = new HashSet<>();
		int n = sc.nextInt();
		int tmp;
		for(int i = 0; i < n; i++)
			s.add(sc.nextInt());
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++)
		{
			tmp = sc.nextInt();
			if (s.contains(tmp)) System.out.print("1 ");
			else System.out.print("0 ");
		}
		sc.close();
	}
}