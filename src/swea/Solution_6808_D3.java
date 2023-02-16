package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_D3 {

	public static boolean nextPermu(int[] arr)
	{
		int i = arr.length - 1;
		int j = arr.length - 1;
		int tmp;
		
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		if(i == 0) return false;
		while(arr[i - 1] >= arr[j]) j--;
		tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		j = arr.length - 1;
		for(; i < j; i++, j--)
		{
			tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int allCard[] = new int[19];
			int cardKY[] = new int[9];
			int cardIY[] = new int[9];
			for(int i = 0; i < 9; i++)
				allCard[Integer.parseInt(st.nextToken())]++;
			int tmpIndexK = 0, tmpIndexI = 0;
			int KWin = 0, KLose = 0;
			boolean flag = true;
			for(int i = 1; i <= 18; i++)
			{
				if(allCard[i] == 1)
					cardKY[tmpIndexK++] = i;
				else if(allCard[i] == 0)
					cardIY[tmpIndexI++] = i;
			}
			
			while(flag)
			{
				int KScore = 0, IScore = 0;
				
				for(int i = 0; i < 9; i++)
				{
					if(cardKY[i] > cardIY[i]) KScore += cardKY[i] + cardIY[i];
					else if(cardKY[i] < cardIY[i]) IScore += cardKY[i] + cardIY[i];
				}
				if(KScore > IScore) KWin++;
				else if(IScore > KScore) KLose++;
				flag = nextPermu(cardIY);
			}
			
			sb.append("#" + tc + " " + KWin + " " + KLose + "\n");
		}
		System.out.println(sb.toString());
	}
}
