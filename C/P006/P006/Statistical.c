#include <stdio.h>
#include <stdlib.h>
void main() {
	// TODO 전교생일 TOEFL 시험을 본 후 성적표를 받았을 때, 
	//		평균점보다 높은 점수를 받은 학생의 수를 계산하는 통계 산출 알고리즘을 제시하라
	int t[10];		//	전교생의 숫자는 10명
	int s = 0;
	int i = 0, j = 0;
	for (j = 0; j<10; j++) {
		t[j] = (rand() % 120) + 1;
		printf("t[%d]: %d\n",j,t[j]);
	}

	do {
		s += t[i];
		i++;
	} while (i<10);
	double m = s / 10;
	int cnt = 0;
	i = 0;
	do {
		if (t[i]>m) {
			cnt++;
		}
		i++;
	} while (i<10);
	printf("TOEFL 평균: %.2lf\n평균점보다 높은 학생수: %d\n",m,cnt);
	system("PAUSE");
}