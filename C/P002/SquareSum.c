#include <stdio.h>
void main() {
	int a = 0, b = 0;	//	a�� ���, b�� ����
	int s = 0, c = 0;	//	s�� ��, c�� a*b
	do {
		a++;
		b = 101 - a;	// �ñ׸� x=1���� 100���� nx ���ϱ�
		c = a * b;
		c = c * c;
		s += c;
	} while (a < 100);
	printf("%d\n", s);
	system("PAUSE");
}