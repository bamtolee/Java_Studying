package bronze;

import java.util.Scanner;

public class B11285B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char cho[] = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
		char joong[] = {'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'};
		char jong[] = {'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};

		int ret = 44032, i = 0;
		int tmp[] = new int[3];
		while(sc.hasNext())
		{
			String han = sc.next();
			tmp[i] = han.charAt(0);
			i++;
		}

		for(int j = 0; j < 19; j++)
		{
			if(cho[j] == tmp[0])
			{
				ret += j * 588;
				break;
			}
		}
		for(int j = 0; j < 21; j++)
		{
			if(joong[j] == tmp[1])
			{
				ret += j * 28;
				break;
			}
		}
		if(tmp[2] != 0)
		{
			for(int j = 0; j < 27; j++)
			{
				if(jong[j] == tmp[2])
				{
					ret += j + 1;
					break;
				}
			}
		}
		System.out.println((char)ret);
		sc.close();
	}
}
