package b_5557;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 숫자 개수 
		int N = Integer.parseInt(br.readLine());
		
		// N개의 숫자를 입력받아 long 타입 배열에 저장 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N-1][21];
		dp[0][arr[0]] = 1;
		
		for (int i=1; i<N-1; i++) {
			for (int j=0; j<21; j++) {
				if ((j-arr[i]) >= 0 ) {
					dp[i][j] += dp[i-1][j-arr[i]];
				}
				if ((j+arr[i]) <= 20 ) {
					dp[i][j] += dp[i-1][j+arr[i]];
				}
			}
		}
		System.out.println(dp[N-2][arr[N-1]]);
	
	}
	

}
