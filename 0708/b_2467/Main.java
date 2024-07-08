package b_2467;

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
		int[] sol = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			sol[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		int min = Integer.MAX_VALUE;
		int pl = 0; // 두 용액 중 왼쪽 위치 저장
		int pr = 0; // 두 용액 중 오른쪽 위치 저장
		
		while (start<end) {
			int sum = sol[start] + sol[end];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				pl = start;
				pr = end;
			}
			if (sum >= 0) end--;
			else start++;
		
		}
		System.out.println(sol[pl]+" "+sol[pr]);
	}

}
