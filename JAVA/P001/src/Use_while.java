import java.util.Scanner;

public class Use_while {

	public static void main(String[] args) {
		int n, fact = 1;
		
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		System.out.print(n);
		while(n > 0) {
			fact = n * fact;
			n = n - 1;
		}
		System.out.println("의 누승은 " + fact + " 입니다.");
	}

}
