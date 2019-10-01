#include <stdio.h>
void main() {
	// TODO 3개의 2차원 배열 a(2,4), b(4,3), s(2,3)이 존재할 때, R행 C열의 배열 원소
	//	S(R,C)에, 행렬A의 R행과 행렬B의 C열에 있는 원소들을 각각 곱한 총합을 보유 하는 행렬 원소
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