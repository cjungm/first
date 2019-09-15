import java.util.Scanner;

public class Use_Recursive {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		System.out.print(n);
		Ex2 factorial = new Ex2();
		System.out.println("의 누승은 " + factorial.calFact(n) + " 입니다.");
		}
}
class Ex2{
	int Fact = 1;
	public int calFact(int n) {
		return (n > 0) ? n * calFact(n-1): 1;
	}
}