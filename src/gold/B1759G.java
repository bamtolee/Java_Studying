package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759G {

	public static char password[] = new char[15];
	public static char input[];
	
	public static void combination(int l, int c, int count, int start, StringBuilder sb)
	{
		if(count == l)
		{
			boolean vflag = false;
			boolean cflag = false;
			int tmp = 0;
			for(int i = 0; i < l; i++)
			{
				if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i'
				|| password[i] == 'o' || password[i] == 'u')
					vflag = true;
				else
				{
					tmp++;
					if(tmp == 2) cflag = true;
				}
			}
			if(vflag && cflag)
			{
				for(int i = 0; i < l; i++)
					sb.append(password[i]);
				sb.append("\n");
			}
		}
		else
		{
			for(int i = start; i < c; i++)
			{
				password[count] = input[i];
				combination(l, c, count + 1, i + 1, sb);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new char[c];
		for(int i = 0; i < c; i++)
			input[i] = st.nextToken().charAt(0);
		
		Arrays.sort(input);
		combination(l, c, 0, 0, sb);
		System.out.println(sb.toString());
	}
}
