
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO 1부터 100 사이에서 가장 큰 소수를 구하는 알고리즘을 제시하라
		int p=2,n=3;
		while(true) {
			double tmp = Math.sqrt(n);
			int m =(int)tmp;
			for(int i=2;i<=m;i++) {
				int r=n%i;
				if(r==0) break;
				if(i==m) p=n;
			}
			n++;
			if(n>100) break;
		}
		System.out.println(p);
	}

}
