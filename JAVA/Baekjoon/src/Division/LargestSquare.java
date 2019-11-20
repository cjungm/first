package Division;

import java.util.Scanner;

public class LargestSquare {

	static Scanner scanner;
	
	public static void main(String[] args) {
//		문제
//		히스토그램은 직사각형 여러 개가 아래쪽으로 정렬되어 있는 도형이다. 
//		각 직사각형은 같은 너비를 가지고 있지만, 높이는 서로 다를 수도 있다. 
//		예를 들어, 왼쪽 그림은 높이가 2, 1, 4, 5, 1, 3, 3이고 너비가 1인 직사각형으로 이루어진 히스토그램이다.
//		히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.
//
//		입력
//		입력은 테스트 케이스 여러 개로 이루어져 있다. 
//		각 테스트 케이스는 한 줄로 이루어져 있고, 직사각형의 수 n이 가장 처음으로 주어진다. 
//		(1 ≤ n ≤ 100,000) 그 다음 n개의 정수 h1, ..., hn (0 ≤ hi ≤ 1,000,000,000)가 주어진다. 
//		이 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다. 
//		모든 직사각형의 너비는 1이고, 입력의 마지막 줄에는 0이 하나 주어진다.
		scanner = new Scanner(System.in);
		while(true) {
			int n = scanner.nextInt();
			int [] arr = new int [n];
			int max = 0;
			if(n==0) {
				break;
			}
			arr = getArray(n, arr);
			max = getSize(arr,max);
			System.out.println(max);
		}
		
	}
	static int getSize(int[] arr, int max) {
		for(int i=0;i<arr.length;i++) {
			int count = 0;
			if(arr.length==1) {
				count=1;
			}else {
				count = upCalcSize(arr.length,i,count,arr,arr[i]);
				count = downCalcSize(arr.length,i-1,count,arr,arr[i]);
			}
			int size = arr[i]*count;
			if(max<size) {
				max=size;
			}
		}
		return max;
	}
	static int downCalcSize(int length, int i, int count, int[] arr, int num) {
		if(i>-1) {
			if(arr[i]>=num) {
				count++;
				count = downCalcSize(length,i-1,count,arr,num);
			}else {
				return count;
			}

		}else {
			return count;
		}
		return count;
	}
	static int upCalcSize(int length, int i, int count, int[] arr, int num) {
		if(i<length) {
			if(arr[i]>=num) {
				count++;
				count = upCalcSize(length,i+1,count,arr,num);
			}else {
				return count;
			}		
		}else {
			return count;
		}
		return count;
	}
	static int [] getArray(int n, int[] arr) {
		while(n>0) {
			arr[--n]=scanner.nextInt();
		}
		return arr;
	}
	

}
