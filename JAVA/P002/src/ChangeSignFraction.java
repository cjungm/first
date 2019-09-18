public class ChangeSignFraction {

	public static void main(String[] args) {
		//s = 1/(2x3) - 2/(3x4) +3/(4x5) -...구하기
		int k = 0;
		double s = 0;
		int sw = 0;
		double l =0;
		do {
			k++;
			l = (double) k/(k+1 )*(k+2);
			if(sw==0) {
				s+=l;
				sw=1;
			}
			else {
				s-=l;
				sw=0;
			}
		}while(k!=49);
		System.out.println(s);
	}

}
