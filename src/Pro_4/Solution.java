package Pro_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss = br.readLine();
		int num = Integer.parseInt(ss);
		int[] ar = new int[num];
		for(int i = 0; i < num; i++) {
			String s = br.readLine();
			ar[i] = Integer.parseInt(s);
		}
		
		int ans = 0;
		
		for(int i = 1; i < num; ) {
			for(int j = i+1; j < num; j++) {
				if(ar[i] <= ar[j]) {
					int rope = j - i;
					if(rope > ans) {
						ans = rope;
					}
					i = j;
					
				}
			}
			if(i == num - 1) {
				break;
			}
		}
		System.out.println(ans);
	}
}
