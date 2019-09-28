
public class InsertionSort {

	public static void main(String[] args) {
		// TODO 학생 5명의 영어 성적을 오름차순으로 삽입 정렬하는 알고리즘을 제시하라
		int e[]= {95,75,85,100,50};
		System.out.print("원본:\t");
		for(int k=0;k<e.length;k++) {
			System.out.print(e[k]+"\t");
		}
		System.out.println();
		int i=0;
		int j,key;
		for(i=1;i<5;i++) {
			key=e[i];
			for(j=i-1;j>=0;j--) {
				if(e[j]<=key) break;
				e[j+1]=e[j];
			}
			e[j+1]=key;
			System.out.print(i+"회차:\t");
			for(int k=0;k<e.length;k++) {
				System.out.print(e[k]+"\t");
			}
			System.out.println();
		}

	}

}
