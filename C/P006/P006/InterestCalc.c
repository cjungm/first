#include <stdio.h>
void main() {
	// TODO ������ ������ ���࿡ ��ġ�� �� 1���� ���� ������ �ް� �Ǵ� 
	//		���ݰ� ������ �հ踦 �˷� �ִ� ���� �հ� ��� �˰������� �����϶�
	double r = 0.05;		//	������: 0.05
	int m = 100000;			//	����: 100,000��
	int y = 5;				//	�� ��ġ�Ⱓ: 5��

	double k = 1;
	int i = 1;
	double t;
	do {
		k *= (1 + r);
		t = m * k;
		printf("%d�� => %f��",i,t);
		i++;
	} while (i <= y);
}