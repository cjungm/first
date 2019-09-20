#include <stdio.h>	
void main() {
	int b[4] = { 0,1,1,1 };
	int e[4];
	int a[] = { 0,0,1,1 };
	int c = 0;
	for (int k = 3; k >= 0; k--) {
		int s = b[k] + a[k] + c;
		if (s > 1) {
			e[k] = s % 2;
			c = 1;
		}
		else
		{
			e[k] = s;
			c = 0;
		}
	}
	for (int k = 0; k <= 3; k++) {
		printf("%d", e[k]);
	}
	printf("\n");
	system("PAUSE");
}