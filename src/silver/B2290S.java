package silver;

import java.util.Scanner;

public class B2290S{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		String n = sc.next();
		
		for(int i = 0; i < 2 * s + 3; i++)
		{
			for(int j = 0; j < n.length(); j++)
			{
				if(i == 0 || i == 2 * s + 2)
				{
					if(n.charAt(j) == '1' || n.charAt(j) == '4')
						for(int t = 0; t < s + 2; t++) System.out.print(" ");
					else if(n.charAt(j) == '7' && i == 0)
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t != 0 && t != s + 1) System.out.print("-");
							else System.out.print(" ");
						}
					}
					else if(n.charAt(j) == '7' && i == 2 * s + 2)
						for(int t = 0; t < s + 2; t++) System.out.print(" ");
					else
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t != 0 && t != s + 1) System.out.print("-");
							else System.out.print(" ");
						}
					}
				}
				else if(i == (2 * s + 3) / 2)
				{
					if(n.charAt(j) == '1' || n.charAt(j) == '7' || n.charAt(j) == '0')
						for(int t = 0; t < s + 2; t++) System.out.print(" ");
					else
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t != 0 && t != s + 1) System.out.print("-");
							else System.out.print(" ");
						}
					}
				}
				else if(i > 0 && i < (2 * s + 3) / 2)
				{
					if((n.charAt(j) >= '1' && n.charAt(j) <= '3') || n.charAt(j) == '7')
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == s + 1) System.out.print("|");
							else System.out.print(" ");
						}
					}
					else if(n.charAt(j) == '0' || n.charAt(j) == '4' || n.charAt(j) == '8' || n.charAt(j) == '9')
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == 0 || t == s + 1) System.out.print("|");
							else System.out.print(" ");
						}
					}
					else
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == 0) System.out.print("|");
							else System.out.print(" ");
						}
					}
				}
				else
				{
					if((n.charAt(j) == '1' || n.charAt(j) == '3') || n.charAt(j) == '4' || n.charAt(j) == '5' || n.charAt(j) == '7' || n.charAt(j) == '9')
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == s + 1) System.out.print("|");
							else System.out.print(" ");
						}
					}
					else if(n.charAt(j) == '2')
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == 0) System.out.print("|");
							else System.out.print(" ");
						}
					}
					else
					{
						for(int t = 0; t < s + 2; t++)
						{
							if(t == 0 || t == s + 1) System.out.print("|");
							else System.out.print(" ");
						}
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
