package Baekjoon;

import java.util.Scanner;

public class MultiplyMatrix {
	
	static Scanner scanner;

	public static void main(String[] args) {
//		문제
//		N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다. 
//		그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 
//		이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다. N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
	    scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
	    int m = scanner.nextInt();
	    int arrA[][] = new int[n][m];
	    arrA = getArray(arrA);
	    n = scanner.nextInt();
	    m = scanner.nextInt();
	    int arrB[][] = new int[n][m];
	    arrB= getArray(arrB);
	    multiply(arrA,arrB);
	    scanner.close();
	}
	static int[][] getArray(int [][]arr){	
		for(int i = 0; i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		return arr;
	}
	static void multiply(int [][]arrA,int[][]arrB){
		int row =arrA.length;
		int common = arrA[0].length;
		int col = arrB[0].length;
		int result[][] = new int[row][col];
		for(int k =0;k<row;k++) {
			for(int i = 0; i<col;i++) {
				int d = 0;
				for(int j=0;j<common;j++) {
					d+=arrA[k][j]*arrB[j][i];
				}
				result[k][i]=d;
				System.out.print(d+" ");
			}
			System.out.println();
		}

	}
}
