package Baekjoon;

import java.util.Scanner;

public class MultiplyMatrix {
	
	static Scanner scanner;

	public static void main(String[] args) {
//		����
//		N*Mũ���� ��� A�� M*Kũ���� ��� B�� �־����� ��, �� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//		�Է�
//		ù° �ٿ� ��� A�� ũ�� N �� M�� �־�����. ��° �ٺ��� N���� �ٿ� ��� A�� ���� M���� ������� �־�����. 
//		�� ���� �ٿ��� ��� B�� ũ�� M�� K�� �־�����. 
//		�̾ M���� �ٿ� ��� B�� ���� K���� ���ʴ�� �־�����. N�� M, �׸��� K�� 100���� �۰ų� ����, ����� ���Ҵ� ������ 100���� �۰ų� ���� �����̴�.
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
