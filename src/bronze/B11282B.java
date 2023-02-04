package bronze;

import java.util.Scanner;

public class B11282B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char ret = (char)('가' + n - 1);
		
		System.out.println(ret);
	}
}
