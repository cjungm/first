
public class PrimeFactors {

	public static void main(String[] args) {
		// TODO 자연수 N을 입력받아 소인수 분해하여 그 결과를 출력하는 과저을 반복하는 알고리즘을 제시하라
		int a[] = new int [20];
		int n=20;
		int t=0;
		do {
			if(n>=2) {
				int p=2;
				for(;p<=n;p++) {
					if(n%p==0) {
						break;
					}
				}
				a[t]=p;
				n=n/p;
				t++;
			}
			else return;
		} while(n!=1);
		if(t==1) {
			System.out.println("소수");
		}
		else {
			for(int j=0;j<t-1;j++) {
				System.out.print(a[j]+"*");
			}
			System.out.println(a[t-1]);
		}
	}

}
