public class SumUntill100 {

	public static void main(String[] args) {
		int sum = 0;
		int n = 1;
		while(true) {
			sum = sum + n;
			n = n + 1;
			if(n > 100) break;
		}
		System.out.println(sum);
	}

}
