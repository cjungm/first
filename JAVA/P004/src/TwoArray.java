
public class TwoArray {

	public static void main(String[] args) {
		// TODO 2차원 배열 a(5,5)의 원소에 2 형태의 배열 채우기
		int a[][]=new int[5][5];
		int v=1;
		int d=1;
		int c1=0,c2=4;
		for(int r=0;r<5;r++) {
			for(int c=c1;c!=c2+d;c+=d) {
				a[r][c]=v;
				v++;
			}
			int temp=c1;
			c1=c2;
			c2=temp;
			d=-d;
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
