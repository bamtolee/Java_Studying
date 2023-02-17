package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20499B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		String ret[] = in.split("/");
		
		int k = Integer.parseInt(ret[0]);
		int d = Integer.parseInt(ret[1]);
		int a = Integer.parseInt(ret[2]);
		if((k + a) < d || d == 0) System.out.print("hasu");
		else System.out.print("gosu");
	}
}