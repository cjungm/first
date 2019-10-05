package Test2018_1;

import java.util.Scanner;

public class ChangeN {

	public static void main(String[] args) {
		//	진법 n			2=<n=<16
		//	출력할 숫자의 갯수 t	0<t=<1000
		//	게임에 참가하는 인원 m	2=<m=<100
		//	튜브의 순서 p		1=<p=<m
		Scanner scanner = new Scanner(System.in);
		System.out.print("진법 입력>>");
		int n = scanner.nextInt();
		System.out.print("출력갯수 입력>>");
		int t = scanner.nextInt();
		System.out.print("인원 입력>>");
		int m = scanner.nextInt();
		System.out.print("튜브 순서 입력>>");
		int p = scanner.nextInt();
		int num = 0;	//	현재 출력해야하는 숫자
		int turn =1;	//	현재 순서
		int pn =0; 		//	출력한 갯수
		while(pn!=t) {
			String cnum=changeN(n,num);
			for(int i=0;i<cnum.length();i++) {
				if(p==m) {
					if(turn%m==0) {
						System.out.print(cnum.substring(i,i+1));
						pn++;
						if(pn==t) {
							break;
						}
					}
				}else {
					if(turn%m==p) {
						System.out.print(cnum.substring(i,i+1));
						pn++;
						if(pn==t) {
							break;
						}
					}
				}

				turn++;
			}
			num++;
		}
		scanner.close();
	}
	static String changeN(int n, int num) {
		String msg ="";
		if(n>10) {
			while(num>=n) {
				if(num%n>=10) {
					switch (num%n) {
					case 10:
						msg="A"+msg;
						num/=n;
						break;
					case 11:
						msg="B"+msg;
						num/=n;
						break;
					case 12:
						msg="C"+msg;
						num/=n;
						break;
					case 13:
						msg="D"+msg;
						num/=n;
						break;
					case 14:
						msg="E"+msg;
						num/=n;
						break;
					case 15:
						msg="F"+msg;
						num/=n;
						break;
					}
				}else {
					msg=num%n+msg;
					num/=n;
				}
			}
		}else {
			while(num>=n) {
				msg=num%n+msg;
				num/=n;
			}
		}
		switch (num%n) {
		case 10:
			msg="A"+msg;
			num/=n;
			break;
		case 11:
			msg="B"+msg;
			num/=n;
			break;
		case 12:
			msg="C"+msg;
			num/=n;
			break;
		case 13:
			msg="D"+msg;
			num/=n;
			break;
		case 14:
			msg="E"+msg;
			num/=n;
			break;
		case 15:
			msg="F"+msg;
			num/=n;
			break;
		default:
			msg= num+msg;
			break;
		}
		
		return msg;
	}

}
