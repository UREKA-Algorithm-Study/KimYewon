package b_2636;

import java.util.*;
import java.io.*;
public class Main {
	
	static int N,M; // N : 세로, M : 가로
	static int[][] cheese;
	static boolean[][] visited;
	static int cnt = 0; // 한 시간 동안 치즈가 녹은 후 남은 개수 
	static int hour; // 치즈가 다 녹는데 걸린 시간		
	static ArrayList<Integer> count = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					cnt++; // 58
				}
			}
		}
		int initial = cnt; // 처음 치즈 개수 저장
		hour = 0;
		// 남은 치즈 개수가 0개가 될 때까지 반복문 실행 
		while (cnt!=0) {
			hour++;
			// 한 시간이 지나면 visited 값 모두 F로 초기화
			visited = new boolean[N][M];
			
			bfs(0,0);
			// 방문 처리가 되어 있고 1인 부분은 치즈가 녹은 부분이므로
			// 다음 bfs를 위해 1 -> 0으로 치환
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (cheese[i][j]==1 && visited[i][j]) {
						cnt--;
						cheese[i][j] = 0;
					}
				}
			}
			count.add(cnt);
		}
		System.out.println(hour);
		if (count.size()==1) {
			System.out.println(initial);
		} else {
			System.out.println(count.get(count.size()-2));
		}
	}

	private static void bfs(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				// 배열을 벗어나는 값이면 무시
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				// 이미 방문한 곳은 치즈가 있든 없든 무시
				if (visited[nx][ny]) continue;
				
				// 방문한 적이 없고 치즈가 있으면(1) 카운팅, 방문 처리 후 무시
				if (!visited[nx][ny] && cheese[nx][ny]==1) {
					visited[nx][ny] = true;
					continue;
				}
				
				// 아직 방문한 적 없는 치즈가 없는 곳은 q에 좌표 추가
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}
