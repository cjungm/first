
public class BubbleSort {

	public static void main(String[] args) {
		// TODO 학생 5명의 영어 성적을 오름차순으로 버블 정렬하는 알고리즘을 제시하라
		int e[]= {95,75,85,100,50};
		System.out.print("원본:\t");
		for(int k=0;k<e.length;k++) {
			System.out.print(e[k]+"\t");
		}
		System.out.println();
		int i=0;
		int temp;
		do {
			int j=0;
			do {
				if(e[j]>e[j+1]) {
					temp=e[j];
					e[j]=e[j+1];
					e[j+1]=temp;
				}
				j++;
			}while(j<4-i);
			i++;
			System.out.print(i+"회차:\t");
			for(int k=0;k<e.length;k++) {
				System.out.print(e[k]+"\t");
			}
			System.out.println();
		}while(i<4);
	}

}
