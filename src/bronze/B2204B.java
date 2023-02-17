package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B2204B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			String arr[] = new String[n];
			for(int i = 0; i < n; i++)
				arr[i] = br.readLine();
			
			Arrays.sort(arr, new Comparator<String>(){
				public int compare(String x, String y) {
					return x.toLowerCase().compareTo(y.toLowerCase());
				}
			});
			sb.append(arr[0] + "\n");
		}
		System.out.println(sb.toString());
	}
}
