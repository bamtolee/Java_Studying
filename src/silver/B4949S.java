package silver;

import java.util.Scanner;
import java.util.Stack;

public class B4949S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<>();
		String tmp;
		
		while(true)
		{
			boolean flag = true;
			tmp = sc.nextLine();
			if(tmp.equals(".")) break;
			for(int i = 0; i < tmp.length(); i++)
			{
				if(tmp.charAt(i) == '(') s.push('(');
				else if(tmp.charAt(i) == '[') s.push('[');
				else if(tmp.charAt(i) == ']')
				{
					if(s.empty())
					{
						flag = false;
						break;
					}
					else if(s.peek() != '[')
					{
						flag = false;
						break;
					}
					else s.pop();
				}
				else if(tmp.charAt(i) == ')')
				{
					if(s.empty())
					{
						flag = false;
						break;
					}
					else if(s.peek() != '(')
					{
						flag = false;
						break;
					}
					else s.pop();
				}
			}
			if(!s.empty()) flag = false;
			if(flag) System.out.println("yes");
			else System.out.println("no");
			s.clear();
		}
		sc.close();
	}
}
