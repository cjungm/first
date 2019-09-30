
public class DayCount {

	public static void main(String[] args) {
		// TODO 어떤 해의 1월 1일을 수요일이라고 가정할 때
		//		같은 해의 날짜(월일)을 받아들여서 요일을 출력해 주는
		//		요일 계산 알고리즘을 제시하라
		int md[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		String wd[]= {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
		int m =3;
		int d=8;
		if(d==0) return;
		
		int nal =0;
		int dal=m-1;
		if(dal!=0) {
			int i=0;
			do {
				nal+=md[i];
				i++;
			}while(i<=(dal-1));
		}
		nal=nal+-1;
		int v=nal/7;
		v*=7;
		int w = nal-v;
		int x=w+3;
		if(x>7) x-=7;
		System.out.println(m+"월 "+d+"일 =>  "+wd[x-1]);
	}

}
