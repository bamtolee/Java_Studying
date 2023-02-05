package silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1421S {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int w = sc.nextInt();
		int tmp, cut_num, tree_num;
		long max_inc= 0, tmp_p;
		int len[] = new int[n];
		
		for(int i = 0; i < n; i++)
			len[i] = sc.nextInt();
		Arrays.sort(len);
		for(int i = 1; i <= len[n - 1]; i++)
		{
			tmp_p = 0;
			for(int j = 0; j < n; j++)
			{
				if(len[j] % i == 0)
				{
					tmp = len[j] / i - 1;
					tree_num = tmp + 1;
				}
				else
				{
					tmp = len[j] / i;
					tree_num = tmp;
				}
				cut_num = tmp;
				if(((long)tree_num * (long)i * (long)w - (long)cut_num * (long)c) > 0)
					tmp_p += (long)tree_num * (long)i * (long)w - (long)cut_num * (long)c;
			}
			if(tmp_p > max_inc) max_inc = tmp_p;
		}
		System.out.println(max_inc);
		sc.close();
	}
}
