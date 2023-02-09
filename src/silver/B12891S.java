package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int DNAChar[] = new int[20];
		int canPwd[] = new int[20];
		int ret = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int pwdLen = Integer.parseInt(st.nextToken());
		String arbtString = br.readLine();
		st = new StringTokenizer(br.readLine());
		DNAChar[0] = Integer.parseInt(st.nextToken());
		DNAChar[2] = Integer.parseInt(st.nextToken());
		DNAChar[6] = Integer.parseInt(st.nextToken());
		DNAChar[19] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < pwdLen; i++)
			canPwd[arbtString.charAt(i) - 'A']++;
		if(canPwd[0] >= DNAChar[0] && canPwd[2] >= DNAChar[2] && canPwd[6] >= DNAChar[6]
				&& canPwd[19] >= DNAChar[19]) ret++;
		for(int i = pwdLen; i < len; i++)
		{
			canPwd[arbtString.charAt(i - pwdLen) - 'A']--;
			canPwd[arbtString.charAt(i) - 'A']++;
			if(canPwd[0] >= DNAChar[0] && canPwd[2] >= DNAChar[2] && canPwd[6] >= DNAChar[6]
					&& canPwd[19] >= DNAChar[19]) ret++;
		}
		System.out.println(ret);
	}
}
