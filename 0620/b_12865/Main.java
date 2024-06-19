package b_12865;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물품 수 
		int K = sc.nextInt(); // 최대 무게 
		int[][] dp = new int[N+1][K+1];
		int[][] wv = new int[N][2];
		
		// [ [6,13], [4,8], [3,6], [5,12] ]
		for (int i=0; i<N; i++) {
			wv[i][0] = sc.nextInt();
			wv[i][1] = sc.nextInt();
		}
		
		for (int i=0; i<K+1; i++) {
			if (i>=wv[0][0]) {
				dp[0][i] = wv[0][1];
			}
		}
		
		for (int i=1; i<N; i++) {
			for (int j=0; j<K+1; j++) {
				if (j < wv[i][0]) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wv[i][0]]+wv[i][1]);
				}
			}
		}
		System.out.println(dp[N-1][K]);
		sc.close();
	}
}
