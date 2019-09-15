#include <stdio.h>
void main() {
	int SUM = 0;
	int N, N1, N2;

	scanf_s("%d", &N1);
	scanf_s("%d", &N2);

	for(N = N1;N <= N2; N++) {
		SUM = SUM + N;
	} 
	printf("%d부터 %d까지 정수의 합은 %d이다\n", N1, N2, SUM);
	system("pause");
}