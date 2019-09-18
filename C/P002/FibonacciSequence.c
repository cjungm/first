#include <stdio.h>
void main() {
	int a = 1, b = 1, s = a + b;	//	n-2번째, n-1번째, n번째의 수
	int n = 2;						//	2번째 항부터 시작
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