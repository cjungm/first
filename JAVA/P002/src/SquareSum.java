public class SquareSum {

	public static void main(String[] args) {
		// s=(100x1)^2 + (99x2)^2 + (98x3)^2 +...구하기
		int a = 0, b=0;
		int s = 0, c =0;
		do {
			a++;
			b=101-a;
			c=a*b;
			c=c*c;
			s+=c;
		}while(a<100);
		System.out.println(s);
	}

}
