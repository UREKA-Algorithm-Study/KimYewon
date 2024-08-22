package b_4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<int[]> graphs;
	static boolean[] inCycle;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 1; // 테스트케이스 개수
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n==0 && m==0) {
				break;
			}
			
			parents = new int[n+1]; // 1번 노드 ~ n번 노드
			inCycle = new boolean[n+1];
			
			for (int i=1; i<=n; i++) {
				parents[i] = i; // 부모를 자기 자신으로 초기화
			}
			
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				unionFind(u,v);
			}
			
			// 사이클이 발생한 그래프의 루트 노드 번호를 cycleIdx에 저장
			ArrayList<Integer> cycleIdx = new ArrayList<>();
			for (int i=1; i<=n; i++) {
				if (parents[i]==i && inCycle[i]) {
					cycleIdx.add(i);
				}
			}
			// 사이클이 발생한 집합에 속한 원소에 대해 inCycle true로 변환
			for (int i=1; i<=n; i++) {
				if (!inCycle[i]) {
					for (int j=0; j<cycleIdx.size(); j++) {
						if (parents[i] == cycleIdx.get(j)) {
							inCycle[i] = true;
						}
					}
				}
			}
			
			// 트리 개수 세기
			int cnt = 0;
			for (int i=1; i<=n; i++) {
				if (parents[i] == i && !inCycle[i]) {
					cnt++;
				}
			}
			
			// 출력
			System.out.print("Case "+T+": ");
			if (cnt == 0) {
				System.out.print("No trees.");
			} else if (cnt == 1) {
				System.out.print("There is one tree.");
			} else {
				System.out.print("A forest of "+cnt+" trees.");
			}
			System.out.println();
			T++;
			
		}
		
	}

	private static void unionFind(int u, int v) {
		u = findParent(u); // 루트 노드 찾기
		v = findParent(v);
		
		// u와 v의 루트 노드가 같을 경우 사이클이 발생한 것이므로 inCycle을 true로 변환한 후 이전 호출로 돌아가기
		if (u==v) {
			inCycle[u] = true;
			return;
		}
		
		// u와 v의 루트 노드가 다를 경우 더 작은 수로 루트 노드를 갱신
		if (u < v) {
			parents[v] = u;
		} else if (u > v) {
			parents[u]=v;
		}
	}

	private static int findParent(int x) {
		if (x == parents[x])
		 {
			return x; // 자기 자신이 루트 노드이면 자신의 값을 반환
		}
		return parents[x] = findParent(parents[x]); // 부모 노드의 부모 노드를 타고 올라가며 루트 노드를 찾기
	}

}
