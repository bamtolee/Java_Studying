package silver;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B1874S {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		ArrayList<Character> ret = new ArrayList<>();
		int n, max = 0;
		boolean flag = true;
		n = sc.nextInt();
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			if(ar[i] < max)
			{
				while(true)
				{
					if(!s.empty() && s.peek() == ar[i])
					{
						s.pop();
						ret.add('-');
						break;
					}
					else if(!s.empty())
					{
						s.pop();
						ret.add('-');
					}
					
					if(s.empty())
					{
						flag = false;
						break;
					}
				}
			}
			else
			{
				for(int j = max + 1; j <= ar[i]; j++)
				{
					s.push(j);
					ret.add('+');
				}
				max = ar[i];
				s.pop();
				ret.add('-');
			}
		}
		if(flag)
		{
			for(Character c : ret)
				System.out.println(c);
		}
		else
			System.out.println("NO");
		sc.close();
	}
}
