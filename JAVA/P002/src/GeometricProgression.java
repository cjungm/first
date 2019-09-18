public class GeometricProgression {

	public static void main(String[] args) {
		int r = 3;
		int a = 2;
		long s = a;
		int n = 2;
		while(true) {
			a = a*r;
			s = s+a;
			n = n+1;
			if(n>10) break;
		}
		System.out.println(s);
	}

}
