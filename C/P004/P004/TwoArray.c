#include <stdio.h>
void main() {
	// TODO 2���� �迭 a(5,5)�� ���ҿ� 2 ������ �迭 ä���
	int a[5][5];
	int v = 1;
	int d = 1;
	int c1 = 0, c2 = 4;
	for (int r = 0; r<5; r++) {
		for (int c = c1; c != c2 + d; c += d) {
			a[r][c] = v;
			v++;
		}
		int temp = c1;
		c1 = c2;
		c2 = temp;
		d = -d;
	}
	for (int i = 0; i<5; i++) {
		for (int j = 0; j<5; j++) {
			printf("%d\t", a[i][j]);
		}
		printf("\t");
	}
	system("PAUSE");
}