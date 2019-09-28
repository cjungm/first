import java.util.Random;
import java.util.Scanner;

public class Ranking {

	public static void main(String[] args) {
		// TODO 대리점의 전년도 매출액을 순서대로 읽어 들여 매출액을 토대로 대리점의 석차를 구한 후,
		//		25개 대리점에 대하여 매출액과 석차를 함께 순서대로 출력하는 알고리즘을 제시하라
		Scanner scanner = new Scanner(System.in);
		int a[] = new int [25];	//	매출액을 저장하는 배열
		int r[] = new int [25];	//	석차를 저장하는 배열
		
		for(int i=0;i<25;i++) {
			Random random = new Random();
			a[i]=(random.nextInt(9)+1)*100;	//	매출액 입력
			r[i]=1;					//	석차 초깃값 설정
		}
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				if(a[i]<a[j])		//	매출액이 큰 대리점이 존재하면
					r[i]++;			//	석차를 1만큼 증가시킴
			}
		}
		for(int i=0;i<25;i++) {
			System.out.println(a[i]+":"+r[i]);
		}

	}

}
