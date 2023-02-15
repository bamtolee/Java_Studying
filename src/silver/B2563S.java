package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563S {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int paper[][] = new int[101][101];
		int sum = 0;
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x + 10; j++)
				for(int k = y; k < y + 10; k++)
					paper[j][k] = 1;
		}
		
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				sum += paper[i][j];
		System.out.println(sum);
	}
}
