#include <stdio.h>
void main() {
	int tn = 0;
	for (int n = 4; n <= 500; n++) {
		int sum = 0;
		int k = n / 2;
		for (int j = 1; j <= k; j++) {
			if (n%j == 0) sum += j;
		}
		if (n == sum) {
			printf("n = %d\n", n);
			tn++;
		}
	}
	printf("%d\n", tn);
	system("PAUSE");
}