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
	int Fact = 1;

	while (n > 0) {
		Fact = n * Fact;
		n = n - 1;
	}
	return Fact;
}