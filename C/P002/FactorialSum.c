#include <stdio.h>
void main() {
	int n = 1;				//	������ 1
	int f = 1;				//	n!
	int s = 1;				//	sum(n!)
	while (1) {
		n++;
		f *= n;
		s += f;
		if (n == 100) break;	//	�ڿ��� 100����
	}
	printf("%d\n", s);
	system("PAUSE");
}