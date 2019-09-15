#include <stdio.h>
void main() {
	int n, Fact = 1;

	scanf_s("%d", &n);
	printf("%d", n);
	while (n > 0) {
		Fact = n * Fact;
		n = n - 1;
	}
	printf("의 누승은 %d이다\n", Fact);
	system("pause");
}