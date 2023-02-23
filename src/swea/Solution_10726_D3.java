package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_10726_D3 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ret;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            n = (1 << n) - 1;
             
            if((n & m) == n) ret = "ON";
            else ret = "OFF";
            sb.append("#" + tc + " " + ret + "\n");     
        }
        System.out.println(sb.toString());
    }
}
