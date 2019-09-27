
public class RowColumn {

	public static void main(String[] args) {
		// TODO 2차원 배열(5,5)의 원소에  열 우선 배열 채우기
		int a[][] = new int [5][5];
		int v=0;
		int c=0;
		do {
			int r=0;
			do {
				v++;
				a[r][c]=v;
				r++;
			}while(r<=4);
			c+=1;
		}while(c<=4);
		
		for(int r=0;r<5;r++) {
			for(c=0;c<5;c++) {
				System.out.print(a[r][c]+" ");
			}
			System.out.println();
		}
	}

}
