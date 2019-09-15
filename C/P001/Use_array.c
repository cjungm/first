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
	printf("배열 NUM의 원소들 중에서 최솟값은 %d이다\n", MIN);
	system("pause");
}