package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BC
{
	int r;
	int c;
	int cover;
	int p;
	
	public BC(int r, int c, int cover, int p) {
		super();
		this.r = r;
		this.c = c;
		this.cover = cover;
		this.p = p;
	}
}

public class Solution_5644 {
	
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	public static int dist(int r1, int r2, int c1, int c2)
	{
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int aMov[] = new int[m];
			int bMov[] = new int[m];
			BC BCInfor[] = new BC[a];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++)
				aMov[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++)
				bMov[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < a; i++)
			{
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				BCInfor[i] = new BC(r, c, cover, p);
			}
			
			int aCurR = 1, aCurC = 1;
			int bCurR = 10, bCurC = 10;
			int max = 0;
			for(int i = 0; i <= m; i++)
			{
				int tmpSum = 0;
				for(int j = 0; j < a; j++)
				{
					int tmpA = 0;
					int selecA = -1;
					if(dist(aCurR, BCInfor[j].r, aCurC, BCInfor[j].c) <= BCInfor[j].cover)
						selecA = j;
					for(int k = 0; k < a; k++)
					{
						int tmpB = 0;
						int selecB = -2;
						if(dist(bCurR, BCInfor[k].r, bCurC, BCInfor[k].c) <= BCInfor[k].cover)
							selecB = k;
						if(selecA == -1 && selecB == -2) continue;
						if(selecA == -1 && selecB != -2)
							tmpB = BCInfor[selecB].p;
						else if(selecA != -1 && selecB == -2)
							tmpA = BCInfor[selecA].p;
						else if(selecA == selecB)
						{
							tmpA = BCInfor[selecA].p / 2;
							tmpB = BCInfor[selecB].p / 2;
						}
						else if(selecA != selecB && selecA != -1 && selecB != -2)
						{
							tmpA = BCInfor[selecA].p;
							tmpB = BCInfor[selecB].p;
						}
						if(tmpSum < tmpA + tmpB) tmpSum = tmpA + tmpB;
					}
				}
				max += tmpSum;
				
				if(i == m) break;
				
				aCurR += dr[aMov[i]]; aCurC += dc[aMov[i]];
				bCurR += dr[bMov[i]]; bCurC += dc[bMov[i]];
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}
}
