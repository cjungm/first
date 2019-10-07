import java.util.Scanner;

public class StarFruit {

	public static void main(String[] args) {
		int summerDay=0;
		int day=1;
		int spendDay=0;
		int cell=0;
		int price=0;
		int yield=0;
		Scanner scanner=new Scanner(System.in);
		summerDay = scanner.nextInt();
		spendDay = scanner.nextInt();
		cell= scanner.nextInt();
		price= scanner.nextInt();
		while(day<=summerDay) {
			if((day%spendDay==1)&&(day>1)) {
				yield+=cell;
			}else if(spendDay==1) {
				yield+=cell;
			}
			day++;
		}
		System.out.println(yield*price);

	}

}
