#include <stdio.h>
void main() {
	//	10명 학생들의 영어 점수
	int score[10] = { 70,60,55,90,85,75,80,100,95,45 };
	int cnt = 0;
	int i = 0;
	while (1)
	{
		if (score[i] >= 80) cnt++;
		i++;
		if (i >= 10) break;
	}
	printf("%d\n", cnt);
	system("PAUSE");
}