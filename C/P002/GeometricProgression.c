#include <stdio.h>
void main() {
	int r = 3;		//	������ ����
	int a = 2;		//	������ ����
	int s = a;		//	100��° �ױ����� �� ���� ����
	int n = 2;		//	��� ������ �� ����
	while (1) {
		a = a * r;
		s = s + a;
		n = n + 1;
		if (n > 100) break;		//	100��° �ױ���
	}
	printf("%d\n", s);
	system("PAUSE");
}