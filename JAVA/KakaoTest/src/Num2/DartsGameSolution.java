package Num2;

import java.util.Scanner;

public class DartsGameSolution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Darts score:\t");
		String inputVal = scanner.nextLine();
		
		int len = inputVal.length();	//	점수의 길이
		int step = 1;					//	1:점수 2:보너스 3:옵션
		int lenPos = 0;					//	입력된 값의 깊이
		int [] score = new int [3];		//	점수
		int scorePos = 0;				//	점수의 좌표
		
		//1. 입력된 길이만큼 반복 분석
		while(lenPos<len) {
			String target = inputVal.substring(lenPos,lenPos+1);
			if(step ==1) {
				try {
					//1.1 숫자만 올 수 있다.
					score[scorePos] =Integer.parseInt(target);
					step++;
				}catch (Exception e) {
					//1.3 옵션만 올 수 있다.
					if("*".equals(target)) {
						//1.3.1 스타상
						if(scorePos-1==0) {
						score[scorePos-1]*=2;
						}else {
							score[scorePos-1]*=2;
							score[scorePos-2]*=2;
						}
					}else if("#".equals(target)) {
						//1.3.2 아차상
						score[scorePos-1]*=(-1);
					}else {
						System.out.println("유효한 다트 옵션이 아닙니다.");
						return;
					}
				}
			}else if(step ==2) {
				//1.2 점수 처리
				if("S".equals(target)) {
					//1.2.1 Single
					score[scorePos] = (int)Math.pow(score[scorePos], 1);
				}else if("D".equals(target)) {
					//1.2.2 Double
					score[scorePos] = (int)Math.pow(score[scorePos], 2);
				}else if("T".equals(target)) {
					//1.2.3 Triple
					score[scorePos] = (int)Math.pow(score[scorePos], 3);
				}else if("0".equals(target)) {
					//1.2.1 10점 처리
					score[scorePos] *= 10;
					step++;
					scorePos--;
				}else {
					System.out.println("유효한 다트 점수가 아닙니다.");
					return;
				}
				step--;
				scorePos++;
			}
			//다음 문자로 넘어가기
			lenPos++;
		}
		System.out.println(score[0]+score[1]+score[2]);
	}

}
