package Test2018_1;

import java.util.Scanner;

public class ChangeNSolution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("진법 입력>>");
		int n = scanner.nextInt();
		System.out.print("출력갯수 입력>>");
		int t = scanner.nextInt();
		System.out.print("인원 입력>>");
		int m = scanner.nextInt();
		System.out.print("튜브 순서 입력>>");
		int p = scanner.nextInt();
		System.out.println(solution(n, t, m, p));

	}
	static String solution(int n, int t, int m, int p) {
	    String retVal = "";
	    
	    int curTurn = 0;
	    int curNum = 0;
	    String strNum = "";
	    
	    while(retVal.length() < t) {
	        strNum = conversion(n, curNum++); // 진수변환 결과 리턴
	        for(char c : strNum.toCharArray()) {
	            curTurn++;
	            if(curTurn == p) {
	                retVal += c;
	                if(retVal.length() == t) {
	                    break;
	                }
	            }
	            if(curTurn == m) {
	                curTurn = 0;
	            }
	        }
	    }
	    
	    return retVal;
	}
	/**
	 * 10진수를 입력받아 n진수의 String으로 리턴
	 * @param n진수
	 * @param num 10진수 입력값
	 */
	static String conversion(int n, int num) {
	    String retVal = "";
	    //	0일 경우
	    if(num == 0) return "0";
	    while(num != 0) {
	    	//숫자가 진법보다 큰 경우
	    	if(num>=n) {
	    		//10보다 작으면 Integer로 10보다 크면 Character로 변환
	    		retVal = (num % n < 10 ? Integer.toString(num % n) : Character.toString((char) (num % n + 55))) + retVal;
	    	}else {
	    		break;
	    	}
	        num = num / n;
	    }
	    //가장 첫번째로 오게 될 문자
	    retVal = (num % n < 10 ? Integer.toString(num % n) : Character.toString((char) (num % n + 55))) + retVal;
	    return retVal;
	}
}
