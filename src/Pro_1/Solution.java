package Pro_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {	

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			long n = Integer.parseInt(br.readLine());
			long ans = 0;
			for(int i = (int)Math.sqrt(n); i >= 0; i--) {
				if(i == 0) {
					break;
				}
				if(n % i == 0) {
					ans += i;
					ans -= (n / i);
					break;
				}
			}
			bw.write(Math.abs(ans)+"\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
		}
	}
}
