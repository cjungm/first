#include <stdio.h>
void main() {
	// TODO 2차원 배열 a(5,5)의 원소에 삼각형 형태의 배열 채우기
	int a[5][5] = { 0 };
	int v = 1;
	int r = 0;
	int c;
	do {
		c = r;
		do {
			a[r][c] = v;
			v++;
			c++;
		} while (c <= 4);
		r++;
	} while (r <= 4);

	for (r = 0; r < 5; r++) {
		for (c = 0; c < 5; c++) {
			printf("%d\t", a[r][c]);
		}
		printf("\n");
	}
	system("PAUSE");
}