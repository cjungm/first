#include <stdio.h>
#include <stdlib.h>
void main() {
	// TODO �������� TOEFL ������ �� �� ����ǥ�� �޾��� ��, 
	//		��������� ���� ������ ���� �л��� ���� ����ϴ� ��� ���� �˰����� �����϶�
	int t[10];		//	�������� ���ڴ� 10��
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
	printf("TOEFL ���: %.2lf\n��������� ���� �л���: %d\n",m,cnt);
	system("PAUSE");
}