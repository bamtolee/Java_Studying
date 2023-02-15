package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			while(n > 0)
			{
				int tmpMin = 101, tmpMax = 0;
				int minInd = -1, maxInd = -1;
				
				for(int i = 0; i < 100; i++)
				{
					if(arr[i] < tmpMin)
					{
						tmpMin = arr[i];
						minInd = i;
					}
					if(arr[i] > tmpMax)
					{
						tmpMax = arr[i];
						maxInd = i;
					}
				}
				arr[maxInd]--;
				arr[minInd]++;
				if(arr[maxInd] - arr[minInd] <= 1) break;
				n--;
			}
			Arrays.sort(arr);
			System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
		}
	}
}

