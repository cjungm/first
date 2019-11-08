package DynamicProgramming;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
//		문제
//		명우는 홍준이와 함께 팰린드롬 놀이를 해보려고 한다.
//		먼저, 홍준이는 자연수 N개를 칠판에 적는다. 그 다음, 명우에게 질문을 총 M번 한다.
//		각 질문은 두 정수 S와 E로 나타낼 수 있으며, 
//		S번째 수부터 E번째 까지 수가 팰린드롬을 이루는지를 물어보며, 
//		명우는 각 질문에 대해 팰린드롬이다 또는 아니다를 말해야 한다.
//		예를 들어, 홍준이가 칠판에 적은 수가 1, 2, 1, 3, 1, 2, 1라고 하자.
//		S = 1, E = 3인 경우 1, 2, 1은 팰린드롬이다.
//		S = 2, E = 5인 경우 2, 1, 3, 1은 팰린드롬이 아니다.
//		S = 3, E = 3인 경우 1은 팰린드롬이다.
//		S = 5, E = 7인 경우 1, 2, 1은 팰린드롬이다.
//		자연수 N개와 질문 M개가 모두 주어졌을 때, 명우의 대답을 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 수열의 크기 N (1 ≤ N ≤ 2,000)이 주어진다.
//		둘째 줄에는 홍준이가 칠판에 적은 수 N개가 순서대로 주어진다. 
//		칠판에 적은 수는 100,000보다 작거나 같은 자연수이다.
//		셋째 줄에는 홍준이가 한 질문의 개수 M (1 ≤ M ≤ 1,000,000)이 주어진다.
//		넷째 줄부터 M개의 줄에는 홍준이가 명우에게 한 질문 S와 E가 한 줄에 하나씩 주어진다.
		int n=7;
		int[] arr = {1, 2, 1, 3, 1, 2, 1};
		int m=4;
		Scanner scanner = new Scanner(System.in);
		while(m>0) {
			int s = scanner.nextInt();
			int e = scanner.nextInt();
			palindrome(arr,s,e);
			m--;
		}
		scanner.close();
	}

	static void palindrome(int[] arr, int s, int e) {
		int len = e-s+1;
		int middle = 0;
		boolean yes = true;
		if(len%2==0) {
			middle=len/2;
			for(int i=s-1;i<s-1+middle;i++) {
				int j=s-1+len-i;
				if(arr[i]!=arr[j]) {
					yes = false;
				}
			}		
		}else {
				if(len!=1) {
				middle=len/2+1;
				for(int i=s-1;i<s-1+middle-1;i++) {
					int j=s-1+len-1-i;
					if(arr[i]!=arr[j]) {
						yes = false;
					}
				}
			}
		}if(yes) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
