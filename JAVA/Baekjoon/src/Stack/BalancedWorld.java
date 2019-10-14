package Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedWorld {

	public static void main(String[] args) {
//		하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 
//		각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 
//		길이는 100글자보다 작거나 같다.
//		입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
		ArrayList<String> msg = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int cnt=0;
		int small;
		int big;
		char c = 'c';
		while(true) {
			String str= scanner.nextLine();
			if(str.equals(".")) break;
			msg.add(str);
		}
		while(!msg.isEmpty()) {
			small=0;
			big=0;
			c = 'c';
			for(int i=0;i<msg.get(cnt).length();i++) {
				if(c=='b'&&msg.get(cnt).substring(i, i+1).equals(")")) {
					System.out.println("NO");
					break;
				}else if(c=='s'&&msg.get(cnt).substring(i, i+1).equals("]")) {
					System.out.println("NO");
					break;
				}
				switch(msg.get(cnt).substring(i, i+1)){
				case "[":
					big++;
					c = 'b';
					break;
				case "]":
					big--;
					c = 'c';
					break;
				case "(":
					c = 's';
					small++;
						break;
				case ")":
					small--;
					c = 'c';
					break;
				}
				if(big<0||small<0) {
					System.out.println("NO");
					break;
				}

			}
			if(big==0&&small==0) {
				System.out.println("YES");
			}
			msg.remove(cnt);
			
		}
		scanner.close();
	}

}
