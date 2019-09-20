#include <stdio.h>
void main() {
	int a[10] = { 131,450,-100,150,50,-10,0,40,32,1 };
	int minCha = 533;
	int n = 0, ans = n;
	int cha = 0;
	do {
		if (a[n] >= 33)cha = a[n] - 33;
		else cha = 33 - a[n];
		if (cha < minCha) {
			minCha = cha;
			ans = n;
		}
		n++;
	} while (n < 10);
	printf("%d\n", (ans+1));
	system("PAUSE");
}