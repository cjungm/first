#include <stdio.h>
void main() {
	int m = 0, i = 0;
	int eng[10] = { 70,60,55,90,85,75,80,100,95,45 };	//	10명 학생들의 영어 점수
	int math[10] = { 90,45,60,77,85,65,80,95,80,55 };	//	10명 학생들의 수학 점수
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