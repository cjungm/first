#include <stdio.h>
void main() {
	// TODO 2���� �迭 a(5,5)�� ���ҿ� ������ ������ �迭 ä���
	int s[5][5] = { 0 };
	int r = 0;
	int c = 2;
	for (int n = 1; n <= 25; n++) {
		s[r][c] = n;
		int nr = r - 1;
		int nc = c + 1;
		if (nr == -1)nr = 4;
		if (nc == 5)nc = 0;
		if (s[nr][nc] == 0) {
			r = nr;
			c = nc;
		}
		else r++;

	}
	for (int nr = 0; nr <= 4; nr++) {
		for (int nc = 0; nc <= 4; nc++) {
			printf("%d\t", s[nr][nc]);
		}
		printf("\t");
	}
	system("PAUSE");
}