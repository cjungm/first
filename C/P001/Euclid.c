#include <stdio.h>
void main() {
	int A, B, R;

	printf("�� ���� �Է��ϼ���. \n>>> ù��° �� = ");
	scanf_s("%d", &A);
	printf(">>> �ι�° �� = ");
	scanf_s("%d", &B);

	if (A < B)swap(&A, &B);
	R = GCD(A, B);

	printf("�ִ������� %d�Դϴ�.\n", R);
}
void swap(int *L, int *R) {// �ּ�(������)�� �Ű������� ����
	int Temp;

	Temp = *L;
	*L = *R;
	*R = Temp;
}

int GCD(int X, int Y) {// ��(Value)�� �Ű������� ����
	for (;;) {
		int M = X % Y;
		if (M == 0) break;
		X = Y;
		Y = M;
	}
	return Y;
}