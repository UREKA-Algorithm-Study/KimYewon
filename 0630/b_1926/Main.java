package b_1926;

import java.io.*;
import java.util.*;
public class Main {
	
	static int n, m;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1}; // 좌우
	static int width;
	static int max; // 가장 넓은 그림의 넓이
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도화지 세로 크기
		m = Integer.parseInt(st.nextToken()); // 도화지 가로 크기
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 색칠되지 않은 부분(0)은 모두 방문 처리(true)
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] == 0) visited[i][j] = true;
			}
		}
		
		int cnt = 0; // 그림의 개수 (dfs 호출 횟수)
		max = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!visited[i][j]) {
					cnt++;
					bfs(i,j);
					if (max<width) {
						max = width;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new int[] {x,y});
		width = 1;
		
		while (!q.isEmpty()) {
			int tmp[] = q.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];
			
			for (int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}
				if (visited[nextX][nextY]) continue;
				
				q.add(new int[] {nextX, nextY});
				
				width++;
				visited[nextX][nextY] = true;
			}	
			
		}
	}

}
