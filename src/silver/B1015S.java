package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class NumNum implements Comparable<NumNum>{
	int index;
	int num;
	
	public NumNum(int index, int num)
	{
		this.index = index;
		this.num = num;
	}

	@Override
	public int compareTo(NumNum o) {
		if(this.num - o.num == 0) return this.index - o.index;
		return this.num - o.num;
	}
}

public class B1015S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		NumNum a[] = new NumNum[n];
		int ret[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			a[i] = new NumNum(i, tmp);
		}
		
		Arrays.sort(a);
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			ret[a[i].index] = count;
			count++;
		}
		for(int i = 0; i < n; i++)
			sb.append(ret[i] + " ");
		System.out.println(sb.toString());
	}
}
