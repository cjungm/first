
public class LozengeArray {

	public static void main(String[] args) {
		// TODO 2차원 배열 a(5,5)의 원소에 마름모 형태의 배열 채우기
		int a[][]=new int[5][5];
		int v=1;
		int m=2;
		int cl=m,cr=m;
		for(int r=0;r<=4;r++) {
			for(int c=cl;c<=cr;c++) {
				a[r][c]=v;
				v+=2;
			}
			if(r<m) {
				cl--;
				cr++;
			}else {
				cl++;
				cr--;
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
