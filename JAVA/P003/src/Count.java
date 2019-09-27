
public class Count {

	public static void main(String[] args) {
		// 영어 시험 성적이 80점 이상인 학생들의 수를 구하는 알고리즘
		int score[]= {70,60,55,90,85,75,80,100,95,45};
		int cnt=0;
		int i=0;
		while(true) {
			if(score[i]>=80) {
				cnt++;
			}
			i++;
			if(i>=10) break;
		}
		System.out.println(cnt);
	}

}
