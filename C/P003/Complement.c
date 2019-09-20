#include <stdio.h>
void main() {
	int b[10] = { 0,1,0,1,0 };
	int o[5];
	int t[5];
	int i = 0;
	do {
		o[i] = 1 - b[i];
		i++;
	} while (i < 5);
	i = 4;
	int c = 1;
	do {
		t[i] = 1;
		if (o[i] == c)t[i] = 0;
		c = o[i] * c;
		i--;
	} while (i >= 0);
	for(int a=0;a<5;a++) printf("%d", t[a]);
	printf("\n");
	system("PAUSE");
}