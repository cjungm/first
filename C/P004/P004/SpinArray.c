#include <stdio.h>
void main() {
	// TODO 2���� �迭 a(5,5)�� ���ҿ� ȸ�� ������ �迭 ä���	
	char a[5][5] = { { 'a','b','c','d','e' }
		,{ 'f','g','h','i','j' }
		,{ 'k','l','m','n','o' }
		,{ 'p','q','r','s','t' }
	,{ 'u','v','w','x','y' } };
	char b[5][5];
	int n;
	for (int r = 0; r <= 4; r++) {
		for (int c = 0; c <= 4; c++) {
			n = 4 - r;
			b[c][n] = a[r][c];
		}
	}
	for (int r = 0; r <= 4; r++) {
		for (int c = 0; c <= 4; c++) {
			printf("%d\t", a[r][c]);
		}
		printf("\t");
	}
	printf("==============================\n");
	for (int c = 0; c <= 4; c++) {
		for (n = 0; n <= 4; n++) {
			printf("%d\t", b[c][n]);
		}
		printf("\t");
	}
	system("PAUSE");
}