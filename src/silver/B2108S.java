package silver;

import java.util.Arrays;
import java.util.Scanner;

public class B2108S {

	public static void main(String[] args) {
		int n, sum = 0, max_freq = 0, mf_ret = -4000;
		double avg;
		int a[], freq[];
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		a = new int[n];
		freq = new int[8001];
		for(int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
			sum += a[i];
			freq[a[i] + 4000]++;
		}
		for(int i = 0; i < 8001; i++)
		{
			if(freq[i] > max_freq)
			{
				max_freq = freq[i];
				mf_ret = i - 4000;
				flag = true;
			}
			else if(flag && max_freq == freq[i])
			{
				flag = false;
				mf_ret = i - 4000;
			}
		}
		Arrays.sort(a);
		avg = (double)sum / (double)n;
		System.out.println((int)(Math.round(avg)));
		System.out.println(a[n / 2]);
		System.out.println(mf_ret);
		System.out.println(a[n - 1] - a[0]);
		sc.close();
	}
}