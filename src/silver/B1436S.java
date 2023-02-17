package silver;

import java.util.Scanner;

public class B1436S {

	static boolean tripleSix(int num)
	{
		boolean ret = false;
		int con = 0;
		
		while(num != 0)
		{
			if(num % 10 == 6) con++;
			else con = 0;
			if(con >= 3)
			{
				ret = true;
				break;
			}
			num /= 10;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		int num = 666;
		
		while(true)
		{
			if(i == n) break;
			num++;
			if(tripleSix(num)) i++;
		}
		System.out.println(num);
		sc.close();
	}
}