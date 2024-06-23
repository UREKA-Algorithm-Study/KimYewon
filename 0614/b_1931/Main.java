package b_1931;

// Silver 1, Greedy Algorithm

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for (int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b; // [[1,4],[3,5],[0,6], ...] 입력 값을 2D 배열에 저장 
		}		
		
		// 1차원 배열 정렬 : Arrays.sort(배열);
		// 2차원 배열 정렬 : java.util의 comparator 클래스 
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { // compare : 두 개의 1차원 배열을 넘겨 받음 -> 배열 내 요소 간 크기 비교
				if (o1[1] == o2[1]) { // 종료 시간이 같을 경우 시작 시간을 기준으로 오름차순 정렬 (빨리 시작하는 회의가 먼저 오도록)
					return o1[0] - o2[0];
					// [1,4] [5,7] [4,7] => 2 
					
					/* 시작 시간 기준으로 정렬하는 이유
					 * ex) [1,3] [8,8] [4,8] -> 종료 시간만을 기준으로 정렬 시 이처럼 정렬될 수 있고, 이 경우 회의 2번 
					 * but [1,3] [4,8] [8,8] 회의 총 3번까지 가능함 (문제 내 조건 : 시작 시간과 종료 시간이 같은 회의가 있을 수 있음) */
				}
				return o1[1] - o2[1]; // 종료 시각 기준 오름차순 정렬
			}
		});
		
		int total = 1; // 회의 개수 (가장 일찍 끝나는 회의부터 시작)
		int current = 0; // 현재 기준 가장 마지막 회의 인덱스 : 현재 기준 arr[0]([1,4])이 마지막 회의
		
		for (int i=1; i<N; i++) {
			if (arr[i][0] >= arr[current][1]) {
				total += 1;
				current = i;
			}
		}
		System.out.println(total);
		sc.close();
	}
}
