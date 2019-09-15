
public class Use_array {

	public static void main(String[] args) {
		int num[] = {70, 60, 50, 80, 90};
		int min = 9999;
		int n;
		for(n = 0; n < num.length; n++) {
			if(min > num[n]) {
				min = num[n];
			}
		}
		System.out.print("배열 num의 원소들 중에서 최솟값은 ");
		System.out.println(min + "입니다.");
	}

}
