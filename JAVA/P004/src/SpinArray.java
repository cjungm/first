
public class SpinArray {

	public static void main(String[] args) {
		// TODO 2차원 배열 a(5,5)의 원소에 회전 형태의 배열 채우기	
		char a[][]= {{'a','b','c','d','e'}
		,{'f','g','h','i','j'}
		,{'k','l','m','n','o'}
		,{'p','q','r','s','t'}
		,{'u','v','w','x','y'}};
		char b[][] = new char[5][5];
		int n;
		for(int r=0;r<=4;r++) {
			for(int c=0;c<=4;c++) {
				n=4-r;
				b[c][n]=a[r][c];
			}
		}
		for(int r=0;r<=4;r++) {
			for(int c=0;c<=4;c++) {
				System.out.print(a[r][c]+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================");
		for(int c=0;c<=4;c++) {
			for(n=0;n<=4;n++) {
				System.out.print(b[c][n]+"\t");
			}
			System.out.println();
		}
	}

}
