#include <stdio.h>
void main() {
	int n = 0, s = 0;
	do {
		n++;
		s += n;			//	n�� Ȧ�� �϶�
		n++;
		s -= n;			//	n�� ¦�� �϶�
	} while (n != 100);
	printf("%d\n", s);
	system("PAUSE");
}