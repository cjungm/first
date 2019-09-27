
public class Divisor {

	public static void main(String[] args) {
		// TODO 4부터 500까지의 자연수 중에서 완전수를 찾아 출력하고 그 개수를 구하는 알고리즘을 제시하라
		int tn=0;
		for(int n=4;n<=500;n++) {
			int sum =0;
			int k=n/2;
			for(int j=1;j<=k;j++) {
				if(n%j==0) {
					sum+=j;
				}
			}
			if(n==sum) {
				System.out.println("n= "+n);
				tn++;
			}
		}
		System.out.println(tn);

	}

}
