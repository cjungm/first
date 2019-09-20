#include <stdio.h>
void main() {
	int a[10] = { 21,17,4,51,24,75,40,27,48,72 };
	int cnt = 0;
	int i = 0;
	do {
		int n3 = a[i] % 3;
		int n4 = a[i] % 4;
		int n = n3 + n4;
		if (n == 0)cnt++;
		i++;
	} while (i < 10);
	printf("%d\n", cnt);
	system("PAUSE");
}