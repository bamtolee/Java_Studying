package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2477S {
	
	public static int dy[] = {0, 0, 0, -1, 1};
	public static int dx[] = {0, 1, -1, 0, 0};
	
	static class Co{
		int x;
		int y;
		public Co(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int yMax = 0, yMin = 0, xMax = 0, xMin = 0, area = 0;
		Co li[] = new Co[7];
		li[0] = new Co(0, 0);
		for(int i = 0; i < 6; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			li[i + 1] = new Co(li[i].x + dx[tmp1] * tmp2, li[i].y + dy[tmp1] * tmp2);
			if(tmp1 >= 3 && li[i + 1].y > yMax) yMax = li[i + 1].y;
			if(tmp1 >= 3 && li[i + 1].y < yMin) yMin = li[i + 1].y;
			if(tmp1 < 3 && li[i + 1].x > xMax) xMax = li[i + 1].x;
			if(tmp1 < 3 && li[i + 1].x < xMin) xMin = li[i + 1].x;
		}
		
		area = (yMax - yMin) * (xMax - xMin);
		for(int i = 1; i <= 6; i++)
		{
			if(li[i].x != xMax && li[i].x != xMin
				&& li[i].y != yMax && li[i].y != yMin)
			{
				int al = Math.abs(li[i].x - li[i - 1].x + li[i].y - li[i - 1].y);
				int bl = Math.abs(li[i].x - li[(i + 1) % 6].x + li[i].y - li[(i + 1) % 6].y);
				area -= al * bl;
				break;
			}
		}
		area *= k;
		System.out.println(area);
	}
}
