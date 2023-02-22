package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int tankR = 0, tankC = 0;
			char map[][] = new char[h][w];
			for(int i = 0; i < h; i++)
			{
				String tmp = br.readLine();
				map[i] = tmp.toCharArray();
				if(tmp.contains("<") || tmp.contains("^") || tmp.contains(">") || tmp.contains("v"))
				{
					tankR = i;
					for(int j = 0; j < w; j++)
						if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v')
							tankC = j;
				}
			}
			
			int cmdN = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			
			for(int i = 0; i < cmdN; i++)
			{
				char tankD = map[tankR][tankC];
				switch(cmd.charAt(i))
				{
				case 'U' :
					map[tankR][tankC] = '^';
					if(tankR - 1 >= 0 && map[tankR - 1][tankC] == '.')
					{
						map[tankR][tankC] = '.';
						tankR--;
						map[tankR][tankC] = '^';
					}
					break;
				case 'D' :
					map[tankR][tankC] = 'v';
					if(tankR + 1 < h && map[tankR + 1][tankC] == '.')
					{
						map[tankR][tankC] = '.';
						tankR++;
						map[tankR][tankC] = 'v';
					}
					break;
				case 'L' :
					map[tankR][tankC] = '<';
					if(tankC - 1 >= 0 && map[tankR][tankC - 1] == '.')
					{
						map[tankR][tankC] = '.';
						tankC--;
						map[tankR][tankC] = '<';
					}
					break;
				case 'R' :
					map[tankR][tankC] = '>';
					if(tankC + 1 < w && map[tankR][tankC + 1] == '.')
					{
						map[tankR][tankC] = '.';
						tankC++;
						map[tankR][tankC] = '>';
					}
					break;
				default:
					int bombR = tankR;
					int bombC = tankC;
					switch(tankD)
					{
					case '<' :
						while(true)
						{
							bombC--;
							if(bombC < 0) break;
							else if(map[bombR][bombC] == '#') break;
							else if(map[bombR][bombC] == '*')
							{
								map[bombR][bombC] = '.';
								break;
							}
						}
						break;
					case '>' :
						while(true)
						{
							bombC++;
							if(bombC >= w) break;
							else if(map[bombR][bombC] == '#') break;
							else if(map[bombR][bombC] == '*')
							{
								map[bombR][bombC] = '.';
								break;
							}
						}
						break;
					case '^' :
						while(true)
						{
							bombR--;
							if(bombR < 0) break;
							else if(map[bombR][bombC] == '#') break;
							else if(map[bombR][bombC] == '*')
							{
								map[bombR][bombC] = '.';
								break;
							}
						}
						break;
					case 'v' :
						while(true)
						{
							bombR++;
							if(bombR >= h) break;
							else if(map[bombR][bombC] == '#') break;
							else if(map[bombR][bombC] == '*')
							{
								map[bombR][bombC] = '.';
								break;
							}
						}
					}
				}
			}
			sb.append("#" + tc + " ");
			for(int i = 0; i < h; i++)
			{
				for(int j = 0; j < w; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
