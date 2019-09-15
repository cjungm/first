#include <stdio.h>
void main() {
	int n, Fact = 1;

	scanf_s("%d", &n);
	printf("%d", n);
	Fact = factorial(n);
	printf("의 누승은 %d이다\n", Fact);
	system("pause");
}
int factorial(int n) {

	return (n > 0) ? n * factorial(n - 1) : 1;
}