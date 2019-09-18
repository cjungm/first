public class ArithmeticalProgression {

	public static void main(String[] args) {
		int a = 2;
		int d = 6;
		int s = a;
		int n = 0;
		int an = 0;
		while(true) {
			an = a +(n-1) * d;
			s = s + an;
			n = n + 1;
			if(n > 200) break;
		}
		System.out.println(s);
	}

}
