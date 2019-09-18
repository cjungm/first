import java.util.Scanner;

public class SplitDate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String date = new String("2019-09-18");
		int index = date.indexOf('-');
		int lastIndex = date.lastIndexOf('-');
		String s[] = date.split("-");
		int year = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1]);
		int day = Integer.parseInt(s[2]);
		System.out.println(index + ", " + lastIndex + ", " + year + ", "
				+ month + ", " + day);
		System.out.println(s[1]);
		s[1] = s[1].replace("0", "");
		System.out.println(s[1]);
	}

}
