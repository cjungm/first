#include <stdio.h>
void main() {
	// TODO 2차원 배열 a(5,5)의 원소에 마름모 형태의 배열 채우기
	int a[5][5] = { 0 };
	int v = 1;
	int m = 2;
	int cl = m, cr = m;
	for (int r = 0; r <= 4; r++) {
		for (int c = cl; c <= cr; c++) {
			a[r][c] = v;
			v += 2;
		}
		if (r<m) {
			cl--;
			cr++;
		}
		else {
			cl++;
			cr--;
		}
	}
	for (int r = 0; r<5; r++) {
		for (int c = 0; c<5; c++) {
			printf("%d\t", a[r][c]);
		}
		printf("\t");
	}
	system("PAUSE");
}