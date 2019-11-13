package Division;

public class PaperCount {

	public static void main(String[] args) {
//		문제
//		N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다. 
//		우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.
//
//		만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
//		(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
//		이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 
//		1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
		int n = 9;
		int [][] paper =  {{0, 0,  0, 1, 1,  1, -1, -1, -1},
							{0, 0,  0, 1, 1,  1, -1, -1, -1},
							{0, 0,  0, 1, 1,  1, -1, -1, -1},
							{1, 1,  1, 0, 0,  0,  0,  0,  0},
							{1, 1,  1, 0, 0,  0,  0,  0,  0},
							{1, 1,  1, 0, 0,  0,  0,  0,  0},
							{0, 1, -1, 0, 1, -1,  0,  1, -1},
							{0, -1, 1, 0, 1, -1,  0,  1, -1},
							{0, 1, -1, 1, 0, -1,  0,  1, -1}};
		int [] num = {0,0,0};
		num = checkPaper(num,paper,0,n,0,n);
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
	}

	 static int[] checkPaper(int[] num, int[][] paper, int xstart, int xend, int ystart, int yend) {
		 int xlen = xend-xstart;
		 int ylen = yend-ystart;
		 if(xlen==1) {
			 switch(paper[ystart][xstart]) {
			 case -1:
				 num[0]++;
				 break;
			 case 0:
				 num[1]++;
				 break;
			 case 1:
				 num[2]++;
				 break;
			 }
			 return num;
		 }else {
			 boolean isOk = true;
			 int tmp=paper[ystart][xstart];
			 for(int i=ystart;i<yend;i++) {
				 for(int j=xstart;j<xend;j++) {
					 if(paper[i][j]!=tmp) {
						 isOk=false;
						 break;
					 }else {
						 tmp=paper[i][j];
					 }
				 }
				 if(!isOk) {
					 break;
				 }
			 }
			 if(isOk) {
				 switch(paper[ystart][xstart]) {
				 case -1:
					 num[0]++;
					 break;
				 case 0:
					 num[1]++;
					 break;
				 case 1:
					 num[2]++;
					 break;
				 }
				 return num;
				 
			 }else {
				 int x1=xlen/3+xstart;
				 int x2=xlen/3*2+xstart;
				 int x3=xlen+xstart;
				 int []x= {x1-(xlen/3),x1,x2,x3};
				 int y1=ylen/3+ystart;
				 int y2=ylen/3*2+ystart;
				 int y3=ylen+ystart;
				 int []y= {y1-(ylen/3),y1,y2,y3};
				 for(int i=1;i<y.length;i++) {
					 for(int j=1;j<x.length;j++) {
						 num = checkPaper(num,paper,x[j-1],x[j],y[i-1],y[i]);
					 }
				 }
				 
			 }
			
			return num;
		 }
		
	}

}
