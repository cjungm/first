import java.util.Random;
import java.util.Scanner;

public class Calculator {
	static long buttonTime=0;
	
	public static void main(String[] args) {
		
		long findNumber=0;
		int cnt=0;
		Scanner scanner = new Scanner(System.in);
		findNumber = scanner.nextInt();
		Random r = new Random();
		String s[] = {"+","*","-","/"};
		String msg="";

		while(cnt<=99) {
			if((buttonTime==Math.pow(2, 63)-1)||buttonTime<0) {
				System.out.println(-1);
				return;
			}
			int a=0;
			if(buttonTime<findNumber) {
				a= r.nextInt(2);
			}else if(buttonTime>findNumber) {
				a=2+r.nextInt(2);
			}else if(buttonTime==findNumber) {
				System.out.println(cnt);
				System.out.println(msg);
				break;
			}
			msg = calculate(a,msg,s);
			cnt++;
			
		}

	}

	private static String calculate(int a, String msg, String[] s) {
		msg= msg + s[a]+" ";
		switch(a) {
		case 0:
			buttonTime+=2;
			break;
		case 1:
			buttonTime*=2;
			break;
		case 2:
			buttonTime-=2;
			break;
		case 3:
			buttonTime/=2;
			break;
		}
		return msg;
	}

}
