#include <stdio.h>
void main() {
	int A, B, R;

	printf("두 수를 입력하세요. \n>>> 첫번째 수 = ");
	scanf_s("%d", &A);
	printf(">>> 두번째 수 = ");
	scanf_s("%d", &B);

	if (A < B)swap(&A, &B);
	R = GCD(A, B);

	printf("최대공약수는 %d입니다.\n", R);
}
void swap(int *L, int *R) {// 주소(포인터)를 매개변수로 받음
	int Temp;

	Temp = *L;
	*L = *R;
	*R = Temp;
}

int GCD(int X, int Y) {// 값(Value)을 매개변수로 받음
	for (;;) {
		int M = X % Y;
		if (M == 0) break;
		X = Y;
		Y = M;
	}
	return Y;
}