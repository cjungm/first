#include <stdio.h>	
void main() {
	int p[9] = { 0,1,0,0,1,0,0,0,1 };
	int pn = 0;
	for (int k = 1; k < 9; k++) {
		if (p[k] == 1) {
			pn++;
		}
	}
	int e = pn % 2;
	if (p[0] == e) printf("���� �̹߰�\n");
	else printf("�����߰�\n");
	printf("\n");
	system("PAUSE");
}