#include <stdio.h>
void main() {
	// TODO 2차원 배열 a(5,5)의 원소에 달팽잎 형태의 배열 채우기
	int a[5][5];
	int n = 0, s = 1, i = 0, j = -1, k = 5;
	while (1) {
		for (int p = 0; p<k; p++) {
			n += 1;
			j += s;
			a[i][j] = n;
		}
		k -= 1;
		if (k <= 0)break;
		for (int p = 0; p<k; p++) {
			n += 1;
			i += s;
			a[i][j] = n;
		}
		s *= (-1);
	}
	for (i = 0; i<5; i++) {
		for (j = 0; j<5; j++) {
			printf("%d\t", a[i][j]);
		}
		printf("\t");
	}
	system("PAUSE");
}