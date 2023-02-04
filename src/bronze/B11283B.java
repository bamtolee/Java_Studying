package bronze;

import java.util.Scanner;

public class B11283B {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String han = sc.next();
		char hangeul = han.charAt(0);
		int diff = hangeul - '가';
		System.out.println(diff + 1);
	}
}
