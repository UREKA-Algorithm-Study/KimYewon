package b_2295;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] U = new int[N];
		
		for (int i=0; i<N; i++) {
			U[i] = sc.nextInt();
		}
		Arrays.sort(U);
		int[] hap = new int[N*N];
		
		int idx = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				hap[idx] = U[i] + U[j];
				idx++;
			}
		}
		Arrays.sort(hap);
		int ans = 0;
		
		outer :
		for (int i=N-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				int result = U[i] - U[j];
				if (Arrays.binarySearch(hap, result) >= 0) {
					ans = U[i];
					break outer;
				}
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	
}
