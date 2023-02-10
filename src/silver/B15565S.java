package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15565S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dollInfor[] = new int[n];
		int rionNum = 0, minRet = 1000000;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		{
			dollInfor[i] = Integer.parseInt(st.nextToken());
			if(dollInfor[i] == 1) rionNum++;
		}
		
		if(rionNum < k) minRet = -1;
		else
		{
			int rionIndex[] = new int[rionNum];
			int tmpInd = 0;
			for(int i = 0; i < n; i++)
			{
				if(dollInfor[i] == 1)
				{
					rionIndex[tmpInd] = i;
					tmpInd++;
				}
			}
			for(int i = 0; i <= rionNum - k; i++)
			{
				int tmpMin = rionIndex[i + k - 1] - rionIndex[i] + 1;
				if(tmpMin < minRet) minRet = tmpMin;
			}
		}
		System.out.println(minRet);
	}
}

