#include <stdio.h>
void main() {
	int a = 2;		//	������ ����
	int d = 6;		//	������ ���� = 6
	int s = a;		//	200��° �ױ����� ��
	int n = 2;		//	���� ������ �� ����
	int an = 0;
	while (1)
	{
		an = a + (n - 1) * d;
		s = s + an;
		n = n + 1;
		if (n > 200) break;		//	N == 201���� ������
	}
	printf("%d\n", s);
	system("PAUSE");
}