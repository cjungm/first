#include <stdio.h>
void main() {
	int NUM[5] = { 70, 60, 50, 80, 90 };
	int MIN = 9999;
	int N;

	for (N = 0; N < 5; N++) {
		if (MIN > NUM[N]) {
			MIN = NUM[N];
		}
	}
	printf("�迭 NUM�� ���ҵ� �߿��� �ּڰ��� %d�̴�\n", MIN);
	system("pause");
}