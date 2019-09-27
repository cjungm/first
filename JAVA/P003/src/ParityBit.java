
public class ParityBit {

	public static void main(String[] args) {
		// TODO 8비트 패리티 비트 오류 검사를 실시하는 알고리즘을 제시하라
		int p[]= {0,1,0,0,1,0,0,0,1};
		int pn=0;
		for(int k=1;k<9;k++) {
			if(p[k]==1) {
				pn++;
			}
		}
		int e=pn%2;
		if(p[0]==e) {
			System.out.println("오류 미발견");
		}else {
			System.out.println("오류 발견");

		}

	}

}
