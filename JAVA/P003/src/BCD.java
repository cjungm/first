
public class BCD {

	public static void main(String[] args) {
		// TODO 4비트의 BCD코드를 받아들여 4비트 3초과 코드로 변환하여 출력하는 알고리즘을 제시하라
		int b[]= {0,1,1,1};
		int e[] = new int [4];
		int a[] = {0,0,1,1};
		int c=0;
		for(int k=3;k>=0;k--) {
			int s=b[k]+a[k]+c;
			if(s>1) {
				e[k]=s%2;
				c=1;
			}else {
				e[k]=s;
				c=0;
			}
		}
		for(int k=0;k<=3;k++) {
			System.out.print(e[k]);
		}
		System.out.println();
	}

}
