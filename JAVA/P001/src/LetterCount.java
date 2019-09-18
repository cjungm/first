import java.util.Scanner;

public class LetterCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = "Love is a variety of different feelings, "
				+ "states, and attitudes that ranges "
				+ "from interpersonal affection to pleasure.";
		int cnt = 0;
		
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == 'a') {
				cnt++;
			}
		}
		System.out.println("a문자 갯수 : " + cnt);
	}

}
