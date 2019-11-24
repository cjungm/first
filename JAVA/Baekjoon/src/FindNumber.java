package Baekjoon;

import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
//		����
//		N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
//
//		�Է�
//		ù° �ٿ� �ڿ��� N(1��N��100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]�� �־�����. ���� �ٿ��� M(1��M��100,000)�� �־�����. 
//		���� �ٿ��� M���� ������ �־����µ�, �� ������ A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� �������� ������ int �� �Ѵ�.
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int [] a = new int[n];
		a = getarray(a,scanner);
		int m = scanner.nextInt();
		int [] b = new int[m];
		b = getarray(b,scanner);
		String str = makeStr(a);
		for(int i = 0;i < b.length;i++) {
			if(str.contains(""+b[i])) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		scanner.close();
	}

	static String makeStr(int[] a) {
		String str="";
		for(int i= 0;i<a.length;i++) {
			str+=a[i];
		}
		return str;
	}

	static int[] getarray(int[] a, Scanner scanner) {
		for(int i= 0;i<a.length;i++) {
			a[i] = scanner.nextInt();
		}
		return a;
	}

}
