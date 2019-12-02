package Division;

import java.util.Scanner;

public class NumberCard2 {
	
	static Scanner scanner;

	public static void main(String[] args) {
//		문제
//		숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
//		정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이가 주어진다. 
//		둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
//		숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
//		셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
//		넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 
//		이수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int [] arr1 = new int[n];
		arr1 = getNum(arr1);
		int m = scanner.nextInt();
		int [] arr2 = new int[m];
		arr2 = getNum(arr2);
		int [] arr3 = new int [m];
		arr3 = getCheck(arr3,arr2,arr1);
	}

	static int[] getCheck(int[] arr3, int[] arr2, int[] arr1) {
		for(int i = 0;i<arr3.length;i++) {
			arr3[i] = 0;
			for(int l = 0;l<arr1.length;l++) {
				if(arr2[i]==arr1[l]) {
					arr3[i]++;
				}
			}
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		return arr3;
	}

	static int[] getNum(int[] arr) {
		for(int i = 0;i<arr.length;i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}
}
