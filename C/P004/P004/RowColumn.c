#include <stdio.h>
void main() {
	// TODO 2���� �迭(5,5)�� ���ҿ�  �� �켱 �迭 ä���
	int a[5][5];
	int v = 0;
	int c = 0;
	do {
		int r = 0;
		do {
			v++;
			a[r][c] = v;
			r++;
		} while (r <= 4);
		c += 1;
	} while (c <= 4);

	for (int r = 0; r<5; r++) {
		for (c = 0; c<5; c++) {
			printf("%d\t",a[r][c]);
		}
		printf("\n");
	}
	system("PAUSE");
}