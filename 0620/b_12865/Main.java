package b_12865;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물품 수 (4)
		int K = sc.nextInt(); // 최대 무게 (7)
		int[][] dp = new int[N+1][K+1];
		int[] w = new int[N+1]; // 각 물건의 무게 
		int[] v = new int[N+1]; // 각 물건의 가치 
		
		// w = [0, 6, 4, 3, 5] / v = [0, 13, 8, 6, 12]
		for (int i=1; i<N+1; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for (int i=0; i<K+1; i++) { // i =1 i= 7
			if (i>=w[1]) { // i >= 6 => 6, 7
				dp[1][i] = v[1];
			}
		}
		
		for (int i=2; i<N+1; i++) {
			for (int j=0; j<K+1; j++) { // i=3 / j=7
				if (j < w[i]) { // 7 < 3
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
		sc.close();
	}

}
