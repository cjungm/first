import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO 배열 변수 E에 대하여 데이터 k가 있는 위치를 찾아 주는 이분 검색 알고리즘을 제시하라
		//e[]배열 ,l: 검색 대상 배열 데이터의 하한 인덱스 변수
		//h: 검색 대상 배열 데이터의 상한 인덱스의 변수
		//k: 검색할 데이터
		Scanner scanner = new Scanner(System.in);
		int e[]= {14,17,20,22,26,48,50,90,95,100};
		System.out.print("찾는 숫자를 입력해주세요>> ");
		int a= scanner.nextInt();
		if(bSearch(e, 0, 9, a)==-99) {
			System.out.println("찾는 숫자 없는듯...ㅋㅋ");
		}else {
			System.out.println(bSearch(e, 0, 9, a)+"번째에 있음");
		}
		scanner.close();
	}
	public static int bSearch(int e[],int l, int h, int k) {
		int m;
		for(;;) {
			if(l>h) {
				return -99;
			}
			m=(l+h)/2;
			if(e[m]>k) {
				h=m-1;
				continue;
			}else if(e[m]<k) {
				l=m+1;
				continue;
			}else {
				return m+1;
			}
		}
	}

}
