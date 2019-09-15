#include <stdio.h>
void main() {
	int SUM = 0;
	int N = 1;
	int SW = 1;

	do {
		SUM = SUM + SW * N;
		if (N < 100) {
			N = N + 1;
			SW = -SW;
		}
		else
		{
			break;
		}
	} while (1);
	printf("%d\n", SUM);
	system("pause");
}