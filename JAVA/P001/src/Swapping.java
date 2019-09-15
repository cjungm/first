import java.util.Scanner;

public class Swapping {

	public static void main(String[] args) {
		int a[] = new int [2];
		int r;
		Scanner scanner = new Scanner(System.in);
		System.out.println("두 수를 입력하세요");
		System.out.print("첫 번째 수 >>>");
		a[0] = scanner.nextInt();
		System.out.print("두 번째 수 >>>");
		a[1] = scanner.nextInt();
		System.out.print(a[0] + "와 " + a[1]);
		if(a[0] < a[1]) swap(a);
		r= gcd(a[0], a[1]);
		System.out.println("의 최대 공약수는 " + r +" 입니다.");
	}
	static void swap(int L[]) {
		int temp;
		temp = L[0];
		L[0] = L[1];
		L[1] = temp;
	}
	static int gcd (int x, int y) {
		int m = x % y;
		if(m == 0) {
			return y;
		}
		return gcd(y,m);
	}

}
