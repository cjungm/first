#include <stdio.h>
void main() {
	int n, Fact = 1;

	scanf_s("%d", &n);
	printf("%d", n);
	while (n > 0) {
		Fact = n * Fact;
		n = n - 1;
	}
	printf("�� ������ %d�̴�\n", Fact);
	system("pause");
}