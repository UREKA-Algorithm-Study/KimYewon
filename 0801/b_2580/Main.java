package b_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i=0; i<sudoku.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<sudoku[i].length; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0,0);
	}

	private static void sudoku(int row, int col) {
		
		// 0~8열 탐색하여 한 행이 다 채워졌을 경우 다음 행의 0번째 열부터 시작
		if (col == 9) {
			sudoku(row+1,0);
			return;
		}
		
		// 0~8행 모두 채워졌을 경우 스도쿠 출력
		if (row == 9) {
			for (int[] a : sudoku) {
				for (int num : a) {
					System.out.print(num+" ");
				}
				System.out.println();
			}
			System.exit(0); // return;쓰면 틀림.. 왜징 (시간초과 x 틀렸습니다 뜸)
		}
		
		if (sudoku[row][col] == 0) {
			// 1~9 중 가능한 수 탐색 (가로줄,세로줄, 3*3 정사각형 고려)
			for (int i=1; i<=9; i++) {
				boolean garo = Garo(row, col, i);
				boolean sero = Sero(row, col, i);
				boolean square = Square(row ,col, i);
				
				// 가로줄, 세로줄, 정사각형에서 모두 중복되지 않을 경우
				if (garo && sero && square) {
					sudoku[row][col] = i;
					sudoku(row,col+1);
				}
			}
			sudoku[row][col]=0; // 백트래킹
			return;
		}
		sudoku(row, col+1);
	}
	
	/** 가로줄 탐색 */
	private static boolean Garo(int row, int col, int val) {
		for (int i=0; i<9; i++) {
			if (sudoku[row][i] == val) {
				return false;
			}
		}
		return true;
	}
	
	/** 세로줄 탐색 */
	private static boolean Sero(int row, int col, int val) {
		for (int i=0; i<9; i++) {
			if (sudoku[i][col] == val) {
				return false;
			}
		}
		return true;
	}

	/** 3*3 정사각형 탐색 */
	private static boolean Square(int row, int col, int val) {
		/* 9개 정사각형의 시작점
		 * [0,0], [0,3], [0,6], [3,0], [3,3], [3,6], [6,0], [6,3], [6,6]
		 */
		int start_r = (row/3) * 3; // 탐색을 시작할 행 지정 ex. if row==2이면 0행이 탐색을 시작하는 행
		int start_c = (col/3) * 3;
		
		for (int i=start_r; i<start_r+3; i++) {
			for (int j=start_c; j<start_c+3; j++) {
				if (sudoku[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
}
