
public class QuickSort {
static int cnt=0;
static int cnt2=0;
	public static void main(String[] args) {
		// TODO 학생 5명의 영어 성적을 오름차순으로 퀵 정렬하는 알고리즘을 제시하라

		int e[]= {26,14,100,95,22,17,48,20,50,90};
		System.out.print("원본:\t");
		for(int i=0;i<10;i++) {
			System.out.print(e[i]+"\t");
		}
		System.out.println();
		qSort(e,0,9);
	}
	public static void qSort(int []e,int l , int r) {
		cnt2++;
		int temp;
		if(l>=r) return;
		int p=e[l];				//변하는 배열의 첫번째 값
		int i=l+1;				//변하는 순서 +1
		int j=r;				//마지막 순서
		do {
			while((p>e[i]) && (i<r)) i++;	//다음 값보다 크고 다음 순서가 마지막 순서보다 작다면 다음 순서 증가
			while((p<e[j]) && (i>l)) j--;	//마지막 값보다 작고 다음 순서가 현재 순서보다 크다면 마지막 순서 감소
			if(i>=j) break;					//다음 순서가 마지막 순서와 같으면 탈출
			temp=e[i];
			e[i]=e[j];
			e[j]=temp;
		}while(i<=j);
		temp=e[j];
		e[j]=e[l];
		e[l]=temp;
		cnt++;
		System.out.print(cnt+"회차:\t");
		for(int k=0;k<10;k++) {
			System.out.print(e[k]+"\t");
		}
		System.out.println();
		qSort(e,l,j-1);
		qSort(e,j+1,r);
	}

}
