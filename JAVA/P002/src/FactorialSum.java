public class FactorialSum {

	public static void main(String[] args) {
		int n = 1;
		int f = 1;
		int s = 1;
		while(true) {
			n++;
			f*=n;
			s+=f;
			if(n==10)break;
		}
		System.out.println(s);
	}

}
