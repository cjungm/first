
public class MergeSort {

	public static void main(String[] args) {
		// TODO 오름차순으로 정렬된 배열 a(m)과 내림차순으로 정렬된 배열 b(n)을 병합 정렬하여
		//		오름차순의 배열 c(m+n)을 생성하는 알고리즘을 제시하라
		int a[]= {2,5,10,17,20};
		int b[] = {11,9,8,7};
		int m=5;
		int n=4;
		int c[]= new int [9];
		int ia=0,ib=n-1,ic=0;
		int done=0;
		for(;;) {
			if(a[ia]<b[ib]) {	//a배열의 가장 작은값이 b배열의 가장 작은값보다 작으면
				c[ic]=a[ia];	//c배열에 대입
				ia++;			//a배열 순서 증가
				ic++;			//c배열 순서 증가
				if(ia>m-1) {	//a배열 순서가 끝나면
					if(done==0) {
						a[m-1]=999999;
						ia=m-1;
						done=1;	//done으로 끝남 표시
					}else break;
				}
			}else {				//a배열의 가장 작은값이 b배열의 가장 작은값보다 크면
				c[ic]=b[ib];	//c배열에 b배열 대입
				ib--;			//b배열 감소
				ic++;			//c배열 증가
				if(ib<0) {
					if(done==0) {
						b[0]=999999;
						ib=0;
						done=1;
					}else break;
				}
			}
		}
		for(int p=0;p<m+n;p++) {
			System.out.print(c[p]+"\t");
		}
	}

}
