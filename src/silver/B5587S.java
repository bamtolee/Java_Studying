package silver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B5587S{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp = 0, turn = 1, field = 0;
		List<Integer> s1 = new LinkedList<>();
		List<Integer> s2 = new LinkedList<>();
		
		for(int i = 0; i < n; i++)
		{
			tmp = sc.nextInt();
			s1.add(tmp);
		}
		for(int i = 1; i <= 2 * n; i++)
			if(!s1.contains(i)) s2.add(i);
		Collections.sort(s1);
		Collections.sort(s2);
		
		while(!s1.isEmpty() && !s2.isEmpty())
		{
			if(turn == 1 && field == 0)
			{
				field = s1.get(0);
				s1.remove(0);
			}
			else if(field == 0 && turn == 0)
			{
				field = s2.get(0);
				s2.remove(0);
			}
			else if(field != 0 && turn == 1)
			{
				for(int i = 0; i < s1.size(); i++)
				{
					if(field < s1.get(i))
					{
						field = s1.get(i);
						s1.remove(i);
						break;
					}
					if(i == s1.size() - 1) field = 0;
				}
			}
			else if(field != 0 && turn == 0)
			{
				for(int i = 0; i < s2.size(); i++)
				{
					if(field < s2.get(i))
					{
						field = s2.get(i);
						s2.remove(i);
						break;
					}
					if(i == s2.size() - 1) field = 0;
				}
			}
			turn = 1 - turn;
		}
		if(s1.isEmpty())
		{
			System.out.println(s2.size());
			System.out.println(0);
		}
		else
		{
			System.out.println(0);
			System.out.println(s1.size());
		}
		sc.close();
	}
}
