package Division;

public class ColoerdPaper {
	// count0, count1 로 색종이의 색을 구분한다.
	static int blue = 0;
	static int white = 0;

	public static void main(String[] args) {
		
		 int n = 8;
		 int[][] board = { { 1, 1, 0, 0, 0, 0, 1, 1 },
		 { 1, 1, 0, 0, 0, 0, 1, 1 },
		 { 0, 0, 0, 0, 1, 1, 0, 0 },
		 { 0, 0, 0, 0, 1, 1, 0, 0 },
		 { 1, 0, 0, 0, 1, 1, 1, 1 },
		 { 0, 1, 0, 0, 1, 1, 1, 1 },
		 { 0, 0, 1, 1, 1, 1, 1, 1 },
		 { 0, 0, 1, 1, 1, 1, 1, 1 } };
		 
		check(board, 0, 0, n);
		System.out.println(blue);
		System.out.println(white);
	}
	public static void check(int[][] square, int x, int y, int n) {
		int value = square[x][y]; // 길이가 1이면 바로 체크
		if (n == 1) {
			if (value == 0) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		boolean isOne = true;
		// 사각형이 하나의 색인지 체크
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (value != square[i][j]) {	// 같지 않으면?
					isOne = false;				// 다름 표시
					break;
				}
			}
			if (!isOne) {						// 다름이면 루프 탈출
				break;
			}
		}
		// 하나의 색이면 색에 따라 체크
		if (isOne) {
			if (value == 0) {					// 파란부분이면
				blue++;
			} else {							// 흰부분이면
				white++;
			}
			return;
		} else {								// 하나의 색이 아니면
			// 하나의 색이 아니면 4조각으로 나누어서 계산
			check(square, x, y, n / 2);					// 현재 위치에서 절반만큼(현재)
			check(square, x + n / 2, y, n / 2);			// 현재 위치에서 절반 앞부분부터 나머지(오른쪽)
			check(square, x, y + n / 2, n / 2);			// 왼쪽
			check(square, x + n / 2, y + n / 2, n / 2);	// 대각선
		}
	}
}
