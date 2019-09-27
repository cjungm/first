
public class CommonMultiple {

	public static void main(String[] args) {
		// TODO 배열 A에 21,17,4,51,24,75,40,27,48,72 가 A(1)부터 시작하여 순차적으로 입력되어 있다고 가정할 때
		// 		3의 배수이면서 4의 배수인 수의 갯수를 구하는 알고리즘을 제시하라
		int a[] = {21,17,4,51,24,75,40,27,48,72};
		int cnt=0, i=0;
		do {
			int n3=a[i]%3;
			int n4=a[i]%4;
			int n = n3+n4;
			if(n==0) {
				cnt++;
			}
			i++;
			
		}while(i<10);
		System.out.println(cnt);
	}

}
