#include <stdio.h>
void main() {
	int m = 0, i = 0;
	int eng[10] = { 70,60,55,90,85,75,80,100,95,45 };	//	10�� �л����� ���� ����
	int math[10] = { 90,45,60,77,85,65,80,95,80,55 };	//	10�� �л����� ���� ����
	while (1) {
		if (eng[i] == 100) {
			if (math[i] > m)m = math[i];
		}
		i++;
		if (i >= 10)break;
	}
	printf("%d\n", m);
	system("PAUSE");
}