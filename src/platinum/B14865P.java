package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Co{
	int x;
	int y;
	public Co(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Peak implements Comparable<Peak>{
	int num;
	int x;
	int ind;
	
	public Peak(int x, int num) {
		super();
		this.x = x;
		this.num = num;
	}

	public int compareTo(Peak a) {
		return this.x - a.x;
	}
}

public class B14865P {

	public static boolean find(Co start, Co last)
	{
		if(start.y > 0 && last.y > 0) return false;
		if(start.y < 0 && last.y < 0) return false;
		else return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Co> s = new ArrayList<>();
		List<Co> peakSide = new ArrayList<>();
		int ret1 = 0, ret2 = 0, startInd = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		s.add(new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		for(int i = 1; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			s.add(new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			if(s.get(startInd).x > s.get(i).x) startInd = i;
			else if(s.get(startInd).x == s.get(i).x && s.get(startInd).y > s.get(i).y)
				startInd = i;
		}
		
		Co start = s.get(startInd);
		Co last;
		for(int i = 0; i < n - 1; i++)
		{
			startInd = (startInd + 1) % n;
			last = s.get(startInd);
			if(find(start, last))
				peakSide.add(new Co(start.x, 0));
			start = last;
		}
		
		List<Peak> peakGather = new ArrayList<>();
		for(int i = 0; i < peakSide.size() / 2; i++)
		{
			int front = peakSide.get(i * 2).x;
			int back = peakSide.get(i * 2 + 1).x;
			if(front > back)
			{
				front = peakSide.get(i * 2 + 1).x;
				back = peakSide.get(i * 2).x;
			}
			peakGather.add(new Peak(front, i));
			peakGather.add(new Peak(back, i));
		}
		
		Collections.sort(peakGather);
		for(int i = 0; i < peakGather.size(); i++)
			peakGather.get(i).ind = i;
		Stack<Peak> cal = new Stack<>();
		for(int i = 0; i < peakGather.size(); i++)
		{
			if(cal.isEmpty() || peakGather.get(i).num != cal.peek().num)
				cal.push(peakGather.get(i));
			else if(peakGather.get(i).num == cal.peek().num)
			{
				if(peakGather.get(i).ind - cal.peek().ind == 1) ret2++;
				cal.pop();
				if(cal.isEmpty()) ret1++;
			}
		}
		System.out.println(ret1 + " " + ret2);
	}
}
