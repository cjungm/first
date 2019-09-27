
public class ApproximateValue {

	public static void main(String[] args) {
		// TODO 배열 A(100)의 원소 100개는 절대값이 500이하이다.
//				이 중에서 정수 33에 가장 가까운 근사값을 찾아 해당 원소의 첨자를 출력하는 알고리즘을 제시하라
		int a[] = {131,450,-100,150,50,-10,0,40,32,1};
		int minCha=533,n=0,ans=n,cha=0;
		do {
			if(a[n]>=33) {
				cha=a[n]-33;
			}else {
				cha=33-a[n];
			}
			if(cha<minCha) {
				minCha=cha;
				ans=n;
			}
			n++;
		}while(n<10);
		System.out.println(ans+1);
	}

}
