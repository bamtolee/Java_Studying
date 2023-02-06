package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17478S
{
	public static void recursion(StringBuilder sb, int n, int count)
	{
		if(n == 0)
		{
			for(int i = 0; i < count * 4; i++) sb.append("_");
			sb.append("\"재귀함수가 뭔가요?\"\n");
			for(int i = 0; i < count * 4; i++) sb.append("_");
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int i = 0; i < count * 4; i++) sb.append("_");
			sb.append("라고 답변하였지.\n");
			return;
		}
		for(int i = 0; i < count * 4; i++) sb.append("_");
		sb.append("\"재귀함수가 뭔가요?\"\n");
		for(int i = 0; i < count * 4; i++) sb.append("_");
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		for(int i = 0; i < count * 4; i++) sb.append("_");
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		for(int i = 0; i < count * 4; i++) sb.append("_");
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		count++;
		recursion(sb, n - 1, count);
		count--;
		for(int i = 0; i < count * 4; i++) sb.append("_");
		sb.append("라고 답변하였지.\n");
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursion(sb, n, count);
		System.out.println(sb.toString());
	}
}
