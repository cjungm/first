#include <stdio.h>
void main() {
	double t[30] = { 184,240,9,235,333,295,20,38,329,34
	,350,59,313,24,187,327,234,59,324,47
	,145,95,282,148,213,182,283,227,156,217 };
	int sum = 0;
	int n = 0, i = 0;
	while (1) {
		if (t[i]>200) {
			sum += t[i];
			n++;
		}
		i++;
		if (i >= 30)break;
	}
	double avg = (double)sum / n;
	printf("%.2d\n", avg);
	system("PAUSE");
}