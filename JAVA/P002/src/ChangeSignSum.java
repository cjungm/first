public class ChangeSignSum {

	public static void main(String[] args) {
		//s = 1-2+3-4+... 구하기
		int n=0, s=0;
		do {
			n++;
			s+=n;
			n++;
			s-=n;
		}while(n!=100);
		System.out.println(s);
	}

}
