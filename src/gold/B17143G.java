package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
	int row_loc;
	int col_loc;
	int speed;
	int direction;
	int sharkSize;
	boolean life;

	public Shark()
	{
		
	}
	
	public Shark(int row_loc, int col_loc, int speed, int direction, int sharkSize, boolean life) {
		this.row_loc = row_loc;
		this.col_loc = col_loc;
		this.speed = speed;
		this.direction = direction;
		this.sharkSize = sharkSize;
		this.life = life;
	}
}

public class B17143G {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String tmp = bf.readLine();
		StringTokenizer st = new StringTokenizer(tmp);
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Shark sharks[] = new Shark[m];
		int field[][] = new int[r + 1][c + 1];
		int prev_field[][] = new int[r + 1][c + 1];
		int retSize = 0;
		
		for(int i = 0; i < m; i++)
		{
			tmp = bf.readLine();
			st = new StringTokenizer(tmp);
			int tmp_row = Integer.parseInt(st.nextToken());
			int tmp_col = Integer.parseInt(st.nextToken());
			int tmp_speed = Integer.parseInt(st.nextToken());
			int tmp_direction = Integer.parseInt(st.nextToken());
			int tmp_size = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(tmp_row, tmp_col, tmp_speed, tmp_direction, tmp_size, true);
			prev_field[tmp_row][tmp_col] = tmp_size;
		}
		// 0  낚시왕 한 칸 이동
		for(int i = 1; i <= c; i++)
		{
			// 1 낚시왕이 한 칸 이동 후 가장 가까운 상어를 잡는다.
			int tmp_min = 102, prevIndex = -1;
			for(int j = 0; j < m; j++)
			{
				if(sharks[j].col_loc == i && tmp_min > sharks[j].row_loc && sharks[j].life)
				{
					if(tmp_min != 102)
					{
						sharks[prevIndex].life = true;
						retSize -= sharks[prevIndex].sharkSize;
					}
					prevIndex = j;
					retSize += sharks[j].sharkSize;
					tmp_min = sharks[j].row_loc;
					sharks[j].life = false;
				}
			}
			// 2 상어가 이동한다.
			for(int j = 0; j < m; j++)
				if(!sharks[j].life)
					prev_field[sharks[j].row_loc][sharks[j].col_loc] = 0;
			for(int j = 0; j < m; j++)
			{
				if(sharks[j].life)
				{
					prev_field[sharks[j].row_loc][sharks[j].col_loc] = 0;
					if(sharks[j].direction == 1)
					{
						for(int k = 0; k < sharks[j].speed; k++)
						{
							if(sharks[j].row_loc == 1 && sharks[j].direction == 1)
								sharks[j].direction = 2;
							else if(sharks[j].row_loc == r && sharks[j].direction == 2)
								sharks[j].direction = 1;
							if(sharks[j].direction == 1)
								sharks[j].row_loc--;
							else if(sharks[j].direction == 2)
								sharks[j].row_loc++;
						}
					}
					else if(sharks[j].direction == 2)
					{
						for(int k = 0; k < sharks[j].speed; k++)
						{
							if(sharks[j].row_loc == 1 && sharks[j].direction == 1)
								sharks[j].direction = 2;
							else if(sharks[j].row_loc == r && sharks[j].direction == 2)
								sharks[j].direction = 1;
							if(sharks[j].direction == 1)
								sharks[j].row_loc--;
							else if(sharks[j].direction == 2)
								sharks[j].row_loc++;
						}
					}
					else if(sharks[j].direction == 3)
					{
						for(int k = 0; k < sharks[j].speed; k++)
						{
							if(sharks[j].col_loc == 1 && sharks[j].direction == 4)
								sharks[j].direction = 3;
							else if(sharks[j].col_loc == c && sharks[j].direction == 3)
								sharks[j].direction = 4;
							if(sharks[j].direction == 3)
								sharks[j].col_loc++;
							else if(sharks[j].direction == 4)
								sharks[j].col_loc--;
						}
					}
					else if(sharks[j].direction == 4)
					{
						for(int k = 0; k < sharks[j].speed; k++)
						{
							if(sharks[j].col_loc == 1 && sharks[j].direction == 4)
								sharks[j].direction = 3;
							else if(sharks[j].col_loc == c && sharks[j].direction == 3)
								sharks[j].direction = 4;
							if(sharks[j].direction == 3)
								sharks[j].col_loc++;
							else if(sharks[j].direction == 4)
								sharks[j].col_loc--;
						}
					}
					// 3. 같은 자리에 있는 상어는 둘 중 하나는 잡아먹힌다.
					if(field[sharks[j].row_loc][sharks[j].col_loc] == 0)
						field[sharks[j].row_loc][sharks[j].col_loc] = sharks[j].sharkSize;
					else
					{
						if(field[sharks[j].row_loc][sharks[j].col_loc] > sharks[j].sharkSize)
							sharks[j].life = false;
						else
						{
							for(int k = 0; k < j; k++)
							{
								if(field[sharks[j].row_loc][sharks[j].col_loc] == sharks[k].sharkSize)
								{
									sharks[k].life = false;
									field[sharks[j].row_loc][sharks[j].col_loc] = sharks[j].sharkSize;
									break;
								}
							}
						}
					}
				}
			}
			for(int j = 1; j <= r; j++)
			{
				for(int k = 1; k <= c; k++)
				{
					prev_field[j][k] = field[j][k];
					field[j][k] = 0;
				}
			}
		}
		System.out.println(retSize);
	}
}
