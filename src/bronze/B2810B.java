package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2810B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seatN = Integer.parseInt(br.readLine());
		String seatArrange = br.readLine();
		int cupN = 1;
		
		for(int i = 0; i < seatArrange.length(); i++)
		{
			if(seatArrange.charAt(i) == 'S') cupN++;
			else
			{
				i++;
				cupN++;
			}
		}
		if(cupN > seatN) cupN = seatN;
		System.out.println(cupN);
	}
}
