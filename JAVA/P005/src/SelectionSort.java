
public class SelectionSort {

	public static void main(String[] args) {
		// TODO 학생 5명의 영어 성적을 오름차순으로 선택 정렬하는 알고리즘을 제시하라
		int e[]= {95,75,85,100,50};
		int i=0;
		int temp;
		int sign=0;			//	정렬 여부
		int cnt=0;			//	정렬 횟수
		do {
			int j=i+1;
			sign=0;
			do {
				if(e[i]>e[j]) {
					temp=e[i];
					e[i]=e[j];
					e[j]=temp;
					sign++;
				}
				j++;
			}while(j<5);
			if(sign==0) break;
			else {
				cnt++;
				System.out.print(cnt+"회차 정렬: ");
			for(int k=0;k<e.length;k++){
				System.out.print(e[k]+"\t");
				}
			}
			System.out.println();
			i++;
		}while(i<4);
		System.out.println("총 정렬 횟수는 "+cnt+"회");
	}

}
