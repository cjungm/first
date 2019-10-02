#include <stdio.h>
void main() {
	// TODO 고객이 원금을 은행에 예치한 후 1년이 지날 때마다 받게 되는 
	//		원금과 이자의 합계를 알려 주는 원리 합계 계산 알고리즘을 제시하라
	double r = 0.05;		//	이자율: 0.05
	int m = 100000;			//	원금: 100,000원
	int y = 5;				//	총 거치기간: 5년

	double k = 1;
	int i = 1;
	double t;
	do {
		k *= (1 + r);
		t = m * k;
		printf("%d년 => %f원",i,t);
		i++;
	} while (i <= y);
}