#include <stdio.h>
void main() {
	int a = 2;		//	수열의 초항
	int d = 6;		//	수열의 공차 = 6
	int s = a;		//	200번째 항까지의 합
	int n = 2;		//	등차 수열의 항 순서
	int an = 0;
	while (1)
	{
		an = a + (n - 1) * d;
		s = s + an;
		n = n + 1;
		if (n > 200) break;		//	N == 201부터 가능함
	}
	printf("%d\n", s);
	system("PAUSE");
}