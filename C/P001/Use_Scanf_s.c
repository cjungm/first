#include <stdio.h>
void main() {
	int SUM = 0;
	int N, N1, N2;

	scanf_s("%d", &N1);
	scanf_s("%d", &N2);

	for(N = N1;N <= N2; N++) {
		SUM = SUM + N;
	} 
	printf("%d���� %d���� ������ ���� %d�̴�\n", N1, N2, SUM);
	system("pause");
}