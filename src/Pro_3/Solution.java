package Pro_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		String[] c1 = br.readLine().split(" ");
		HashMap<Integer,HashMap<String,String>> idmap = new HashMap<>();
		for(int i = 0; i < num-1; i++) {
			String[] s = br.readLine().split(" ");
			int id = Integer.parseInt(s[0]);
			HashMap<String,String> cmap = new HashMap<>();
			for(int j = 1; j < c1.length; j++) {
				cmap.put(c1[j], s[j]);
			}
			idmap.put(id, cmap);
		}
		
		int num2 = Integer.parseInt(br.readLine());
		String[] c2 = br.readLine().split(" ");
		HashMap<Integer,HashMap<String,String>> idmap2 = new HashMap<>();
		for(int i = 0; i < num2-1; i++) {
			String[] s = br.readLine().split(" ");
			int id = Integer.parseInt(s[0]);
			HashMap<String,String> cmap2 = new HashMap<>();
			for(int j = 1; j < c2.length; j++) {
				cmap2.put(c2[j], s[j]);
			}
			idmap2.put(id, cmap2);
		}

		for(int i = 0; i < c1.length; i++) {
			bw.write(c1[i] + " ");
		}
		for(int i = 1; i < c2.length; i++) {
			bw.write(c2[i] + " ");
		}
		bw.write("\n");
		
		int size = num < num2 ? num : num2;
		for (int i = 1; i <= num-1; i++) {
			bw.write(i + " ");
			for(int j = 1; j < c1.length; j++) {
				HashMap<String,String> cmap = idmap.get(i);
				bw.write(cmap.get(c1[j]) + " ");
			}
			for(int j = 1; j < c2.length; j++) {
				HashMap<String,String> cmap2 = idmap2.get(i);
				try {
					bw.write(cmap2.get(c2[j]) + " ");
				}
				catch(NullPointerException e) {
					bw.write(null + " ");
				}
				
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
