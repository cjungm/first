
public class MaxMin {

	public static void main(String[] args) {
		// TODO 영어 시험 만점 학생들 중에서 가장 높은 수학 시험 점수를 가지고 있는 학생의 수학 점수를 찾아서 출력하는 알고리즘을 제시하라.
		int m=0;
		int i=0;
		int eng[]= {70,60,55,90,85,75,80,100,95,45};
		int math[]= {90,45,60,77,85,65,80,95,80,55};
		while(true) {
			if(eng[i]==100) {
				if(math[i]>m) {
					m=math[i];
				}

			}
			i++;
			if(i>=10) { 
				break;
			}
		}
		System.out.println(m);
	}

}
