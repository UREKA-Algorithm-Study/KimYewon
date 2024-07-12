package b_3020;

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] seoksun = new int[N/2];
		int[] jongyuseok = new int[N/2];
		int[] obstacles = new int[H];
		
		int s_idx = 0;
		int j_idx = 0;
		for (int i=0; i<N; i++) {
			if (i%2==0) seoksun[s_idx++]=Integer.parseInt(br.readLine());
			else jongyuseok[j_idx++]=H-Integer.parseInt(br.readLine());
		}
		int min = Integer.MAX_VALUE;
		for (int i=1; i<=H; i++) {
			int tmp = 0;
			for (int j=0; j<N/2; j++) {
				if (seoksun[j] >= i) tmp++;
				if (jongyuseok[j] < i) tmp++;
			}
			if (min >= tmp) {
				min = tmp;
			}
			obstacles[i-1] = tmp;
		}
		int cnt = 0;
		for (int a : obstacles) {
			if (a==min) cnt++;
		}
		
		System.out.println(min+" "+cnt);
		
	}

}
