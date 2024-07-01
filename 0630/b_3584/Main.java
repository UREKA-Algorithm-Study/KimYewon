package b_3584;

import java.io.*;
import java.util.*;
public class Main {
	
	static int T, N;
	static ArrayList<Integer>[] parent;
	static ArrayList<Integer> pArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t=0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			parent = new ArrayList[N+1];
			for (int i=1; i<=N; i++) {
				parent[i] = new ArrayList<Integer>();
			}
			
			for (int i=0; i<N-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				parent[B].add(A);
			}
			
			int nodeA = Integer.parseInt(br.readLine());
			int nodeB = Integer.parseInt(br.readLine());
			
			// 각 노드의 깊이 계산
			calculateDepth(nodeA);
			calculateDepth(nodeB);
		}
	}

	private static void calculateDepth(int node) {
		
	}


}
