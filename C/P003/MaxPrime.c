#include <stdio.h>
void main() {
	int x = 0, y = 0;
	printf("���ڸ� �Է��ϼ���\n");
	printf("ù ��° ��>>");
	scanf_s("%d", &x);
	printf("�� ��° ��>>");
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