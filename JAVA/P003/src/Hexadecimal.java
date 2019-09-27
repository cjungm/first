
public class Hexadecimal {

	public static void main(String[] args) {
		// TODO 10진수를 받아들여 16진수로 변환하여 출력하는 알고리즘을 제시하랄
		char[]h= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] t= new char[20];
		int d=1017,i=0,m,n;
		do {
			m=d/16;
			n=d%16;
			t[i]=h[n];
			i++;
			d=m;
		}while(m>=16);
		t[i]=h[m];
		int k=i;
		do {
			System.out.print(t[k]);
			k--;
		}while(k>=0);
	}

}
