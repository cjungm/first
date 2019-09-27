
public class Sandglass {

	public static void main(String[] args) {
		// TODO 2차원 배열 a(5,5)의 원소에 모래시계 형태의 배열 채우기
		int a[][]=new int[5][5];
		int v=1;
		int m=3;
		for(int r=0;r<m;r++) {
			for(int c=r;c<(5-r);c++) {
				a[r][c]=v;
				v++;
			}
		}
		for(int r=m;r<=4;r++) {
			for(int c=(4-r);c<=r;c++) {
				a[r][c]=v;
				v++;
			}
		}
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				System.out.print(a[r][c]+"\t");
			}
			System.out.println();
		}

	}
}