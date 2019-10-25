package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixMultiply {
	static Scanner scanner;
	public static void main(String[] args) {
//		문제
//		크기가 N×M인 행렬 A와 M×K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N×M×K번이다. 
//		행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 달라지게 된다.
//
//		예를 들어, A의 크기가 5×3이고, B의 크기가 3×2, C의 크기가 2×6인 경우에 행렬의 곱 ABC를 구하는 경우를 생각해보자.
//		AB를 먼저 곱하고 C를 곱하는 경우 (AB)C에 필요한 곱셈 연산의 수는 5×3×2 + 5×2×6 = 30 + 60 = 90번이다.
//		BC를 먼저 곱하고 A를 곱하는 경우 A(BC)에 필요한 곱셈 연산의 수는 3×2×6 + 5×3×6 = 36 + 90 = 126번이다.
//		같은 곱셈이지만, 곱셈을 하는 순서에 따라서 곱셈 연산의 수가 달라진다.
//		행렬 N개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오. 
//		입력으로 주어진 행렬의 순서를 바꾸면 안 된다.
//
//		입력
//		첫째 줄에 행렬의 개수 N(1 ≤ N ≤ 500)이 주어진다.
//		둘째 줄부터 N개 줄에는 행렬의 크기 r과 c가 주어진다. (1 ≤ r, c ≤ 500)
//		항상 순서대로 곱셈을 할 수 있는 크기만 입력으로 주어진다.
		scanner = new Scanner(System.in);
		ArrayList <Integer> l = new ArrayList<>();
		ArrayList <Integer> r = new ArrayList<>();
//		Pair pair = new Pair(l, r);
		int[][] d = new int[500][500];
		int n= scanner.nextInt();
	    for (int i=0; i<n; ++i) {
	        int s = scanner.nextInt();
	        int b = scanner.nextInt();
	        l.add(s);
	        r.add(b);
	    }
		for (int i=0; i<n-1; ++i) {
	        d[i][i+1] = l.get(i) * r.get(i) * r.get(i+1);
	    }
		 for (int k=2; k<n; ++k) {
		        for (int i=0; i<n-k; ++i) {
		            int j = i+k;
		            d[i][j] = 2147483647;
		            for (int x=i; x<j; ++x) {
		                if (d[i][j] > d[i][x] + d[x+1][j] + l.get(i)*r.get(x)*r.get(j)) {
		                    d[i][j] = d[i][x] + d[x+1][j] + l.get(i)*r.get(x)*r.get(j);
		                }
		            }
		        }
		    }
		 System.out.println(d[0][n-1]);
		scanner.close();
	}

	

	
}
