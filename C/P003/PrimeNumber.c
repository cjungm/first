#include <stdio.h>
#include <math.h>
void main() {
	int p = 2, n = 3;
	while (1) {
		int m = (int)sqrt(n);
		for (int i = 2; i <= m; i++) {
			int r = n % i;
			if (r == 0)break;
			if (i == m)p = n;
		}
		n++;
		if (n >= 100)break;
	}
	printf("%.2d\n", p);
	system("PAUSE");
}