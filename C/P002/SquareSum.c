#include <stdio.h>
void main() {
	int a = 0, b = 0;	//	a는 계수, b는 변수
	int s = 0, c = 0;	//	s는 합, c는 a*b
	do {
		a++;
		b = 101 - a;	// 시그마 x=1부터 100까지 nx 구하기
		c = a * b;
		c = c * c;
		s += c;
	} while (a < 100);
	printf("%d\n", s);
	system("PAUSE");
}