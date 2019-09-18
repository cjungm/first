import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0 , a = 0;
		while(a < 10) {
			a++;
			if(a % 2 == 1) {
				continue;
			}
			sum += a;
		}
		System.out.println(sum);
	}

}
