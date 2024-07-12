package b_2512_bs;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] yesan = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		
		for (int i=0; i<N; i++) {
			yesan[i] = Integer.parseInt(st.nextToken());
			sum += yesan[i];
			if (max < yesan[i]) max = yesan[i];
		}
		int M = Integer.parseInt(br.readLine());
		
		// 예산 요청 총합이 M보다 작으면 요청한 만큼 배정할 수 있다는 의미이므로 바로 최댓값 출력
		if (sum <= M) {
			System.out.println(max);
			return;
		}
		
		int start = 0;
		int end = max;
		int ans = 0;
		while (start <= end) {
			int tmp = 0;
			int mid = (start + end) / 2;
			for (int i=0; i<N; i++) {
				if (mid < yesan[i]) {
					tmp+=mid;
					continue;
				}
				tmp += yesan[i];
			}
			if (tmp > M) {
				end = mid-1;
			} else if (tmp == M){
				ans = mid;
				break;
			} else {
				ans = mid;
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}

}
