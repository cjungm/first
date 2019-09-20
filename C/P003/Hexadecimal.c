#include <stdio.h>
void main() {
	char h[16];
	h[0] = '0';
	h[1] = '1';
	h[2] = '2';
	h[3] = '3';
	h[4] = '4';
	h[5] = '5';
	h[6] = '6';
	h[7] = '7';
	h[8] = '8';
	h[9] = '9';
	h[10] = 'A';
	h[11] = 'B';
	h[12] = 'C';
	h[13] = 'D';
	h[14] = 'E';
	h[15] = 'F';
	char t[20];
	int d = 107;
	int i = 0;
	int m, n;
	do {
		m = d / 16;
		n = d % 16;
		t[i] = h[n];
		i++;
		d = m;
	} while (m >= 16);
	t[i] = h[m];
	int k = i;
	do {
		printf("%c", t[k]);
		k--;
	} while (k >= 0);
}