package Baekjoon;

import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
//		문제
//		N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1≤M≤100,000)이 주어진다. 
//		다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수들의 범위는 int 로 한다.
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
