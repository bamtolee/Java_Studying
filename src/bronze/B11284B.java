package bronze;

import java.util.Scanner;

public class B11284B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char cho[] = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
		char joong[] = {'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'};
		char jong[] = {'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
		String han = sc.next();
		char c = han.charAt(0);
		int tmp;
		// UTF-8에서 한글은 44032번에서 시작한다.
		// 중성 21개 * 종성 28개이므로 초성 하나당 588개가 있음.
		tmp = ((c - 44032) / 588);
		System.out.println(cho[tmp]);
		// 중성 하나당 종성 28개를 가진다.
		tmp  = (((c - 44032) % 588) / 28);
		System.out.println(joong[tmp]);
		// 종성은 없으면 빈칸 출력
		tmp = ((c - 44032) % 28);
		if (tmp == 0) System.out.println();
		else System.out.println(jong[tmp - 1]);
		sc.close();
	}
}
