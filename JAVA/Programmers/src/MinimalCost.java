

import java.util.ArrayList;

public class MinimalCost {

	public static void main(String[] args) {
//		int [][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int [][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
		int height =3;
		int r = land.length;
		int c = land[0].length;
		int [][] track =new int[r][c];
		int group=0;
		int answer=0;
		ArrayList<Integer>ladder=new ArrayList<>();
		for(int i=0;i<r;i++) {
			int x=0;
			int y=0;
			int xxx=100;
			for(int m=0;m<r;m++) {
				for(int n=0;n<c;n++) {
					if(track[m][n]==0&&land[m][n]<xxx) {
						xxx=land[m][n];
						x=m;
						y=n;
					}
				}
			}
			for(int j=0;j<c;j++) {
				if(track[x][y]==0) {
					group++;
					ladder.add(group);
					track=check(track,land,height,x,y,group);
				}
			}
		}
		for(int k=1;k<group;k++) {
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(track[i][j]==k&&ladder.contains(k)) {
						ladder.remove(ladder.indexOf(k));
						int min=100;
						int index = 0;
						answer+= calculate(land,track,height,i,j,ladder,min,index,k);
					}
				}
			}
		}
		System.out.println(answer);
    }

	static int calculate(int[][] land, int[][] track, int height, int i, int j, ArrayList<Integer> ladder,
			int min, int index, int k) {
		int r = land.length;
		int c = land[0].length;
		for(int a=0;a<4;a++) {
			switch(a) {
			case 0:
				if(i-1>=0) {
					if(track[i][j]!=track[i-1][j]&&ladder.contains(track[i-1][j])) {
						int d=(int)Math.abs(land[i][j]-land[i-1][j]);
						if(min>d) {
							min=d;
							index=track[i-1][j];
						}
					}else if(k==track[i-1][j]) {
						track[i][j]=track[i][j]*-1;
						min=calculate(land,track,height,i-1,j,ladder,min,index,k);
					}
				}
				break;
			case 1:
				if(j-1>=0) {
					if(track[i][j]!=track[i][j-1]&&ladder.contains(track[i][j-1])) {
						int d=(int)Math.abs(land[i][j]-land[i][j-1]);
						if(min>d) {
							min=d;
							index=track[i][j-1];
						}
					}else if(k==track[i][j-1]) {
						track[i][j]=track[i][j]*-1;
						min=calculate(land,track,height,i,j-1,ladder,min,index,k);
					}
				}
				break;
			case 2:
				if(j+1<c) {
					if(track[i][j]!=track[i][j+1]&&ladder.contains(track[i][j+1])) {
						int d=(int)Math.abs(land[i][j]-land[i][j+1]);
						if(min>d) {
							min=d;
							index=track[i][j+1];
						}
					}else if(k==track[i][j+1]) {
						track[i][j]=track[i][j]*-1;
						min=calculate(land,track,height,i,j+1,ladder,min,index,k);
					}
				}
				break;
			case 3:
				if(i+1<r) {
					if(track[i][j]!=track[i+1][j]&&ladder.contains(track[i+1][j])) {
						int d=(int)Math.abs(land[i][j]-land[i+1][j]);
						if(min>d) {
							min=d;
							index=track[i+1][j];
						}
					}else if(k==track[i+1][j]) {
						track[i][j]=track[i][j]*-1;
						min=calculate(land,track,height,i+1,j,ladder,min,index,k);
					}
				}
				break;
			}
		}
		return min;
	}

	// grouping
	static int[][] check(int[][] track, int[][] land, int height, int i, int j, int group) {
		track[i][j]=group;
		int r = land.length;
		int c = land[0].length;
		for(int a=0;a<8;a++) {
			switch(a) {
			case 0:
				if(i-1>=0&&j-1>=0) {
					if(track[i-1][j-1]==0&&Math.abs(land[i][j]-land[i-1][j-1])<=height) {
						track=check(track, land, height, i-1, j-1, group);
					}
				}
				break;
			case 1:
				if(i-1>=0) {
					if(track[i-1][j]==0&&Math.abs(land[i][j]-land[i-1][j])<=height) {
						track=check(track, land, height, i-1, j, group);
					}
				}
				break;
			case 2:
				if(i-1>=0&&j+1<c) {
					if(track[i-1][j+1]==0&&Math.abs(land[i][j]-land[i-1][j+1])<=height) {
						track=check(track, land, height, i-1, j+1, group);
					}
				}
				break;
			case 3:
				if(j-1>=0) {
					if(track[i][j-1]==0&&Math.abs(land[i][j]-land[i][j-1])<=height) {
						track=check(track, land, height, i, j-1, group);
					}
				}
				break;
			case 4:
				if(j+1<c) {
					if(track[i][j+1]==0&&Math.abs(land[i][j]-land[i][j+1])<=height) {
						track=check(track, land, height, i, j+1, group);
					}
				}
				break;
			case 5:
				if(i+1<r&&j-1>=0) {
					if(track[i+1][j-1]==0&&Math.abs(land[i][j]-land[i+1][j-1])<=height) {
						track=check(track, land, height, i+1, j-1, group);
					}
				}
				break;
			case 6:
				if(i+1<r) {
					if(track[i+1][j]==0&&Math.abs(land[i][j]-land[i+1][j])<=height) {
						track=check(track, land, height, i+1, j, group);
					}
				}
				break;
			case 7:
				if(i+1<r&&j+1<c) {
					if(track[i+1][j+1]==0&&Math.abs(land[i][j]-land[i+1][j+1])<=height) {
						track=check(track, land, height, i+1, j+1, group);
					}
				}
				break;
			}
		}
		return track;
	}

}
