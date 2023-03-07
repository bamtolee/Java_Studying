package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int tmpInd = 0;
		int arithInd = 0;
		int num[] = new int[25];
		int arith[] = new int[25];
		boolean subFlag = false;
		
		for(int i = 0; i < input.length(); i++)
		{
			int tmpNum = 0;
			while(i < input.length() && (input.charAt(i) != '+' && input.charAt(i) != '-'))
			{
				tmpNum *= 10;
				tmpNum += input.charAt(i) - '0';
				i++;
			}
			num[tmpInd] = tmpNum;
			tmpInd++;
			if(i != input.length())
			{
				if(input.charAt(i) == '+') arith[arithInd] = 0;
				else arith[arithInd] = 1;
				arithInd++;
			}
		}

		int ret = num[0];
		int tmpSum = 0;
		for(int i = 0; i < arithInd; i++)
		{
			if(arith[i] == 1 && !subFlag) subFlag = true;
			else if(arith[i] == 1 && subFlag)
			{
				ret -= tmpSum;
				tmpSum = 0;
			}
			
			if(!subFlag) ret += num[i + 1];
			else if(subFlag)
				tmpSum += num[i + 1];
		}
		if(subFlag) ret -= tmpSum;
		System.out.println(ret);
	}
}
