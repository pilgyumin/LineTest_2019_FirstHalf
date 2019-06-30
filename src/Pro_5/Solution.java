package Pro_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
	
	static class Brown{
		int x;
		int time;
		
		public Brown(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args)  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] cb = br.readLine().split(" ");
			int c = Integer.parseInt(cb[0]);
			int b = Integer.parseInt(cb[1]);
			
			int[] cony = new int[200001];
			int[] brown = new int[200001];
			int plus = 0;
			for(int i = c; i <= 200000; i+=plus) {
				cony[i] = plus;
				plus++;
			}
			Arrays.fill(brown, 2000000000);
			Deque<Brown> dq = new ArrayDeque<>();
			dq.add(new Brown(b, 0));
			while(!dq.isEmpty()) {
				Brown bro = dq.pollFirst();
				if(bro.x < 0 || bro.x > 200000) {
					continue;
				}
				if(brown[bro.x] <= bro.time) {
					continue;
				}
				
				dq.add(new Brown(bro.x-1, bro.time+1));
				dq.add(new Brown(bro.x+1, bro.time+1));
				dq.add(new Brown(bro.x*2, bro.time+1));
				
				if(brown[bro.x] > bro.time) {
					brown[bro.x] = bro.time;
				}
			}
			int ans = 2000000000;
			boolean find = false;
			for(int i = b; i <= 200000; i++) {
				if(cony[i] == brown[i] && brown[i] > 0) {
					if(ans > brown[i]) {
						ans = brown[i];
						find = true;
					}
				}
			}
			if(find) {
				System.out.println(ans);
			}
			else {
				System.out.println("-1");
			}
			
		} catch (IOException e) {
		}
	}
}
