#include <stdio.h>
void main() {
	// TODO 3���� 2���� �迭 a(2,4), b(4,3), s(2,3)�� ������ ��, R�� C���� �迭 ����
	//	S(R,C)��, ���A�� R��� ���B�� C���� �ִ� ���ҵ��� ���� ���� ������ ���� �ϴ� ��� ����
	int a[2][4] = { { 5,7,-3,4 },{ 2,-5,3,6 } };
	int b[4][3] = { { 3,0,8 },{ -5,1,-1 },{ 7,4,4 },{ 2,4,3 } };
	int s[2][3] = { 0 };
	for (int r = 0; r <= 1; r++) {
		for (int c = 0; c <= 2; c++) {
			s[r][c] = 0;
			for (int k = 0; k <= 3; k++) {
				s[r][c] = s[r][c] + (a[r][k] * b[k][c]);
			}
		}
	}
	for (int r = 0; r <= 1; r++) {
		for (int c = 0; c <= 2; c++) {
			printf("%d\t", s[r][c]);
		}
		printf("\t");
	}
	system("PAUSE");
}