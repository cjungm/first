#include <stdio.h>
void main() {
	// TODO � ���� 1�� 1���� �������̶�� ������ ��
	//		���� ���� ��¥(����)�� �޾Ƶ鿩�� ������ ����� �ִ�
	//		���� ��� �˰����� �����϶�
	int md[] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	char* wd[] = { "������","ȭ����","������","�����","�ݿ���","�����","�Ͽ���" };
	int m = 3;
	int d = 8;
	if (d == 0) return;

	int nal = 0;
	int dal = m - 1;
	if (dal != 0) {
		int i = 0;
		do {
			nal += md[i];
			i++;
		} while (i <= (dal - 1));
	}
	nal = nal + -1;
	int v = nal / 7;
	v *= 7;
	int w = nal - v;
	int x = w + 3;
	if (x>7) x -= 7;
	printf("%s\n" , wd[x - 1]);
}