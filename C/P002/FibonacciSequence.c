#include <stdio.h>
void main() {
	int a = 1, b = 1, s = a + b;	//	n-2��°, n-1��°, n��°�� ��
	int n = 2;						//	2��° �׺��� ����
	int c = 0;
	while (1) {
		c = a + b;					
		s += c;
		a = b;						//	n-1 = n
		b = c;						//	n-2 = n-1
		n++;
		if (n == 100)break;
	}
	printf("%d\n", s);
	system("PAUSE");
}