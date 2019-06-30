package Pro_2;

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
			String s = br.readLine();
			int[] charnum = new int[s.length()];
			StringBuilder sb = new StringBuilder();
			int charidx = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				charnum[i] = s.charAt(i);
				if (charnum[i] < 58) {
					charidx = i;
				}
			}
			int numidx = charidx;

			for (int i = 0; i < charidx; i++) {
				sb.append((char) charnum[i]);
				if (charnum[i + 1] > 96) {
					sb.append((char)charnum[i + 1]);
					i++;
				}
				if(charnum[numidx] == 49) {
					numidx++;
					continue;
				}
				sb.append(charnum[numidx++] - 48);
			}
			bw.write(sb.toString() + "\n");
			bw.flush();
			bw.close();
		} catch (ArrayIndexOutOfBoundsException | IOException e)  {
			try {
				bw.write("error\n");
				bw.flush();
				bw.close();
			} catch (IOException e1) {
			}
		}
	}
}
