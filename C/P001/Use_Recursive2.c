#include <stdio.h>
void main() {
	int n, Fact = 1;

	scanf_s("%d", &n);
	printf("%d", n);
	Fact = factorial(n);
	printf("�� ������ %d�̴�\n", Fact);
	system("pause");
}
int factorial(int n) {

	return (n > 0) ? n * factorial(n - 1) : 1;
}