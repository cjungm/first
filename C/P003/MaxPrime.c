#include <stdio.h>
void main() {
	int x = 0, y = 0;
	printf("숫자를 입력하세요\n");
	printf("첫 번째 수>>");
	scanf_s("%d", &x);
	printf("두 번째 수>>");
	scanf_s("%d", &y);
	if (x < y) {
		int temp = x;
		x = y;
		y = temp;
	}
	for (;;) {
		int m = x % y;
		if (m == 0)break;
		x = y;
		y = m;
	}
	printf("%d\n", y);
	system("PAUSE");
}