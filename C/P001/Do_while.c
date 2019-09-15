#include <stdio.h>
void main() {
	int SUM = 0;
	int N = 1;

	do {
		SUM = SUM + N;
		N = N + 1;
	} while (N <= 10);
	printf("%d\n", SUM);
	system("pause");
}