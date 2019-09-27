
public class SumAvg {

	public static void main(String[] args) {
		// TODO 휴대폰 고객 1명이 한 달 동안 사용하는 총 통화시간을 토대로 일일 평균 통화시간(초)을 구하는 알고리즘을 제시하라
		double t[]= {184,240,9,235,333,295,20,38,329,34,
				350,59,313,24,187,327,234,59,324,47,
				145,95,282,148,213,182,283,227,156,217};
		int sum=0,n=0,i=0;
		while(true) {
			if(t[i]>200) {
				sum+=t[i];
				n++;
			}
			i++;
			if(i>=30) break;
		}
		double avg =(double) sum/n;
		System.out.println(avg);

	}

}
