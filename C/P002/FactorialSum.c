#include <stdio.h>
void main() {
	int n = 1;				//	초항은 1
	int f = 1;				//	n!
	int s = 1;				//	sum(n!)
	while (1) {
		n++;
		f *= n;
		s += f;
		if (n == 100) break;	//	자연수 100까지
	}
	printf("%d\n", s);
	system("PAUSE");
}