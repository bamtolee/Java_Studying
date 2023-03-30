package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239G {

	static int sudoku[][] = new int[9][9];
	static int rowVisit[][] = new int[9][10];
	static int colVisit[][] = new int[9][10];
	static int threeVisit[][][] = new int[3][3][10];
	static boolean flag;
	
	static void playSudoku(int r, int c)
	{
		if(r == 9)
		{
			StringBuilder sb = new StringBuilder();
			flag = true;
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
					sb.append(sudoku[i][j]);
				sb.append("\n");
			}
			System.out.println(sb.toString());
			return;
		}
		else
		{
			if(sudoku[r][c] == 0)
			{
				for(int i = 1; i < 10; i++)
				{
					if(rowVisit[r][i] == 1) continue;
					if(colVisit[c][i] == 1) continue;
					if(threeVisit[r / 3][c / 3][i] == 1) continue;
					sudoku[r][c] = i;
					rowVisit[r][i] = 1;
					colVisit[c][i] = 1;
					threeVisit[r / 3][c / 3][i] = 1;
					if(c == 8) playSudoku(r + 1, 0);
					else playSudoku(r, c + 1);
					if(flag) return;
					rowVisit[r][i] = 0;
					colVisit[c][i] = 0;
					threeVisit[r / 3][c / 3][i] = 0;
					sudoku[r][c] = 0;
				}
			}
			else
			{
				if(c == 8) playSudoku(r + 1, 0);
				else playSudoku(r, c + 1);
				if(flag) return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++)
		{
			String tmp = br.readLine();
			for(int j = 0; j < 9; j++)
			{
				sudoku[i][j] = tmp.charAt(j) - '0';
				if(sudoku[i][j] != 0)
				{
					rowVisit[i][sudoku[i][j]] = 1;
					colVisit[j][sudoku[i][j]] = 1;
					threeVisit[i / 3][j / 3][sudoku[i][j]] = 1;
				}
			}
		}
		
		playSudoku(0, 0);
	}
}
