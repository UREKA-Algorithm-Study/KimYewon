package b_2667;

import java.io.*;
import java.util.*;
public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int house = 0;
	static ArrayList<Integer> h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		h = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for (int j=0; j<tmp.length(); j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		int cnt = 0; // 단지 수
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j]==1 && !visited[i][j]) {
					house=0;
					cnt++;
					dfs(i,j);
					h.add(house);
				}
			}
		}
		Collections.sort(h);
		System.out.println(cnt);
		for (int i:h) {
			System.out.println(i);
		}
	}

	private static void dfs(int x, int y) {
		if (visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		house++;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (!visited[nx][ny] && map[nx][ny]==1) {
				dfs(nx,ny);
			}
		}
	}
}
