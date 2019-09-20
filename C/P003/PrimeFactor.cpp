#include <stdio.h>
void main() {
	int a[20];
	int n = 20;
	int t = 0;
	do {
		if (n >= 2) {
			int p = 2;
			for (; p <= n; p++) {
				if (n%p == 0)break;
			}
			a[t] = p;
			n = n / p;
			t++;
		}
		else
		{
			return;
		}
	} while (n != 1);
	if (t == 1)printf("¼Ò¼ö\n");
	else
	{
		for (int j = 0; j < t - 1; j++) {
			printf("%d*", a[j]);
		}
		printf("%.2d\n", a[t-1]);
	}
	return;
	
}