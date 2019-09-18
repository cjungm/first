#include <stdio.h>
void main() {
	int r = 3;		//	수열의 공비
	int a = 2;		//	수열의 초항
	int s = a;		//	100번째 항까지의 합 보관 변수
	int n = 2;		//	등비 수열의 항 순서
	while (1) {
		a = a * r;
		s = s + a;
		n = n + 1;
		if (n > 100) break;		//	100번째 항까지
	}
	printf("%d\n", s);
	system("PAUSE");
}