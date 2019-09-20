#include <stdio.h>
#include <math.h>
void main() {
	int t[8] = { 1,1,1,1,0,1,1,0 };
	int c[8];
	int d = 0;
	int sign = 1;
	if (t[0] != 0) {
		sign = -1;
		int b = 1;
		for (int k = 7; k >= 1; k--) {
			c[k] = t[k] - b;
			if (t[k] != 0 || b != 1) b = 0;
			c[k] = abs(c[k]);
			t[k] = 1 - c[k];
		}
	}
	for (int k = 1; k <= 7; k++) {
		int t1 = (int)pow(2, (7 - (double)k));
		int t2 = t[k] * t1;
		d += t2;
	}
	d *= sign;
	printf("%d\n", d);
	system("PAUSE");
}