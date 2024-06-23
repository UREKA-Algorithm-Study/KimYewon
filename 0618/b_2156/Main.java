package b_2156;

// Silver 1, DP

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] wines = new int[n];
		
		for (int i=0; i<wines.length; i++) {
			wines[i] = sc.nextInt();
		}
		int[] max = new int[n];
		sc.close();
		
		// n==1 or n==2이면 모든 값의 합을 출력한 후 실행 종료 (예외)
		if (n==1) {
			System.out.println(wines[0]);
			return;
		}
		
		if (n==2) {
			System.out.println(wines[0]+wines[1]);
			return;
		}
		
		max[0] = wines[0];
		max[1] = wines[0] + wines[1];
		max[2] = Math.max(max[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));
		
		for (int i=3; i<max.length; i++) {
			max[i] = Math.max(max[i-1], Math.max(max[i-2]+wines[i], max[i-3] + wines[i-1] + wines[i]));
		}
		
		System.out.println(max[n-1]);
		
	}

}
