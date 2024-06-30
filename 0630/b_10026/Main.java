package b_10026;

import java.io.*;
import java.util.*;
public class Main {
	
	static int N;
	
	// 방향(x[i],y[i]) -> 상(-1,0), 하(1,0), 좌(0,-1), 우(0,1)
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		// 정상
		int normal = 0; // dfs 호출 횟수 누적
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					normal++;
					dfs(i,j);
				}
			}
		}
		
		// 적록 색약 배열 (G를 R로 바꿈)
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		
		// 적록 색약일 때 dfs (visited 초기화 후 진행)
		int colorweak = 0;
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					colorweak++;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(normal+" "+colorweak);
	}

	private static void dfs(int x, int y) {
		if (visited[x][y]) return;
		visited[x][y] = true;
		char tmp = arr[x][y];
		
		// 상하좌우 탐색 
		for (int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX < 0 || newX >= N || newY < 0 || newY >= N ) {
				continue;
			}
			if ((!visited[newX][newY]) && (arr[newX][newY]==tmp)) {
				dfs(newX, newY);
			}
		}
	}
}
