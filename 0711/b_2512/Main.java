package b_2512;

// 시간 복잡도 : O(N logN) / O(N log(max))
import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] yesan = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		for (int i=0; i<N; i++) {
			yesan[i] = Integer.parseInt(st.nextToken());
			sum += yesan[i];
		}
		int M = Integer.parseInt(br.readLine());
		
		if (sum <= M) {
			Arrays.sort(yesan);
			System.out.println(yesan[N-1]);
			return;
		}
		
		int max = M / N; // 121
		int tmp = 0;
		int cnt = 0; // 121보다 큰 요소의 개수
		for (int i=0; i<N; i++) {
			if (yesan[i] <= max) {
				tmp += max - yesan[i]; // tmp = 12
			} else cnt++;
		}
		for (int i=0; i<N; i++) {
			if (yesan[i] > max) {
				yesan[i] = max + tmp/cnt;
			}
		}
		
		Arrays.sort(yesan);
		System.out.println(yesan[N-1]);
	}
}
