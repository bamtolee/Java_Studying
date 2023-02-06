package silver;

import java.util.Scanner;

public class B11729S {

	public static void hanoiReturn(int from, int dest, StringBuilder sb)
	{
		sb.append(from);
		sb.append(" ");
		sb.append(dest);
		sb.append("\n");
	}
	public static void hanoiRecur(int N, int from, int dest, int middle, StringBuilder sb)
	{
		if(N == 1)
		{
			hanoiReturn(from, dest, sb);
		}
		else
		{
			hanoiRecur(N - 1, from, middle, dest, sb);
			hanoiReturn(from, dest, sb);
			hanoiRecur(N - 1, middle, dest, from, sb);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		sb.append((int)Math.pow(2, n) - 1).append("\n");
		hanoiRecur(n, 1, 3, 2, sb);
		System.out.println(sb.toString());
	}
}
