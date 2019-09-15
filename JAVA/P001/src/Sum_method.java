import java.util.Scanner;

public class Sum_method {

	public static void main(String[] args) {
		int sum =0 , n1, n2, n;
		Scanner scanner = new Scanner(System.in);
		n1 = scanner.nextInt();
		n2 = scanner.nextInt();
		for(n = n1; n <= n2; n++) {
			sum = sum + n;
		}
		System.out.print(n1 + "부터 " + n2 + "까지의 ");
		System.out.println("정수의 합은 " + sum + "이다.");
	}

}
