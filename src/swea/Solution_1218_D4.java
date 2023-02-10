package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= 10; i++)
		{
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> parenthesis = new Stack<>();
			boolean ret = true;
			
			for(int j = 0; j < n; j++)
			{
				if(str.charAt(j) == '(' || str.charAt(j) == '<' || str.charAt(j) == '['
						|| str.charAt(j) == '{') parenthesis.push(str.charAt(j));
				else if(str.charAt(j) == ')')
				{
					if(parenthesis.isEmpty() || parenthesis.peek() != '(') ret = false;
					else parenthesis.pop();
				}
				else if(str.charAt(j) == '}')
				{
					if(parenthesis.isEmpty() || parenthesis.peek() != '{') ret = false;
					else parenthesis.pop();
				}
				else if(str.charAt(j) == ']')
				{
					if(parenthesis.isEmpty() || parenthesis.peek() != '[') ret = false;
					else parenthesis.pop();
				}
				else if(str.charAt(j) == '>')
				{
					if(parenthesis.isEmpty() || parenthesis.peek() != '<') ret = false;
					else parenthesis.pop();
				}
				if(!ret) break;
			}
			if(!parenthesis.isEmpty()) ret = false;
			if(ret)
				sb.append("#" + i + " ").append(1);
			else
				sb.append("#" + i + " ").append(0);
			if(i != 10) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
