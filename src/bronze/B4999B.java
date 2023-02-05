package bronze;

import java.util.Scanner;

public class B4999B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		if(a.length() < b.length()) System.out.println("no");
		else System.out.println("go");
		sc.close();
	}
}
