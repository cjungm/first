import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		System.out.print(n);
		Ex factorial = new Ex();
		System.out.println("의 누승은 " + factorial.calFact(n) + " 입니다.");
		}
}
class Ex{
	int Fact = 1;
	public int calFact(int n) {
		while(n > 0) {
			Fact = n * Fact;
			n = n - 1;
		}
		return Fact;
	}
}
