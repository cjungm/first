#include <stdio.h>
void main() {
	int n = 0, s = 0;
	do {
		n++;
		s += n;			//	n이 홀수 일때
		n++;
		s -= n;			//	n이 짝수 일때
	} while (n != 100);
	printf("%d\n", s);
	system("PAUSE");
}