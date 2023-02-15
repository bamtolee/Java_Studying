package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10163B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int lx, ly, w, h;
		int ret[] = new int[n + 1];
		int colorPaper[][] = new int[1002][1002];
		
		for(int i = 0; i < n; i++)
		{			
			st = new StringTokenizer(br.readLine());
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			for(int j = ly; j < ly + h; j++)
				for(int k = lx; k < lx + w; k++)
					colorPaper[j][k] = i + 1;
		}
		for(int i = 0; i < 1002; i++)
			for(int j = 0; j < 1002; j++)
				ret[colorPaper[i][j]]++;
		for(int i = 1; i <= n; i++)
			System.out.println(ret[i]);
	}
}
