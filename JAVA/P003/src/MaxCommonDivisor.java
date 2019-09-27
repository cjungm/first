
public class MaxCommonDivisor {

	public static void main(String[] args) {
		// TODO 유클리드 호제법에 의하여 두 정수 x,y의 최대공약수를 구하는 알고리즘을 제시하라
		int x=60,y=124;
		if(x<y) {
			int temp =x;
			x=y;
			y=temp;
		}
		while(true) {
			int m = x%y;
			if(m==0) break;
			x=y;
			y=m;
		}
		System.out.println(y);

	}

}
