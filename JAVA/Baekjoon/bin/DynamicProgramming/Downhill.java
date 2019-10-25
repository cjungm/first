package DynamicProgramming;

import java.util.Scanner;

public class Downhill {

	static Scanner scanner;
	static int answer=0;
	public static void main(String[] args) {
//		문제
//		여행을 떠난 세준이는 지도를 하나 구하였다. 
//		이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
//		한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며
//		, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
//		현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 
//		그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 
//		위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.
//		지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 
//		이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. 
//		M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.
		scanner = new Scanner(System.in);
		int x= scanner.nextInt();
		int y= scanner.nextInt();
		int [][]board= new int[x][y];
		board=printBoard(board);
		answer=check(board,x,y,0,0,answer);
		System.out.println(answer);
		scanner.close();
	}

	static int check(int[][] board, int x, int y, int j, int k, int answer) {
		for(int i=0;i<3;i++) {
			switch(i) {
			case 0:
				if(k-1>=0&&board[j][k-1]<board[j][k]) {
					if(board[j][k-1]!=board[x-1][y-1]) {
						System.out.print(board[j][k-1]+" ");
						answer=check(board,x,y, j, k-1,answer);
					}else {
						System.out.println();
						answer++;
					}
				}
				break;
			case 1:
				if(j+1<board.length&&board[j+1][k]<board[j][k]) {
					if(board[j+1][k]!=board[x-1][y-1]) {
						System.out.print(board[j+1][k]+" ");
						answer=check(board,x,y, j+1, k,answer);
					}else {
						System.out.println();
						answer++;
					}
				}
				break;
			case 2:
				if(k+1<board[0].length&&board[j][k+1]<board[j][k]) {
					if(board[j][k+1]!=board[x-1][y-1]) {
						System.out.print(board[j][k+1]+" ");
						answer=check(board,x,y, j, k+1,answer);
					}else {
						System.out.println();
						answer++;
					}
				}
				break;
			}
		}
		return answer;
	}

	static int[][] printBoard(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				board[i][j]=scanner.nextInt();
			}
		}
		return board;
	}

}
