package b_1932;

// Silver 1, Dynamic Programming

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n x n 크기의 배열 생성 (2D)
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<i+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i=n-2; i>=0; i--) {
			for (int j=0; j<i+1; j++) {
				arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
			}
		}
		
		System.out.println(arr[0][0]);
		sc.close();
	}

}
