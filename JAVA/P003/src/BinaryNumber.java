
public class BinaryNumber {

	public static void main(String[] args) {
		// TODO 2진수를 10진수로 변환하는 알고리즘을 제시하라
		int t[] = {1,1,1,1,0,1,1,0};
		int c[] = new int [8];
		int d=0,sign=1;
		if(t[0]!=0) {
			sign=-1;
			int b=1;
			for(int k=7;k>=1;k--){
				c[k]=t[k]-b;
				if(t[k]!=0||b!=1) {
					b=0;
				}
				c[k]=Math.abs(c[k]);
				t[k]=1-c[k];
			}
		}
		for(int k=1;k<=7;k++) {
			int t1=(int)Math.pow(2, (7-(double)k));
			int t2=t[k]*t1;
			d+=t2;
		}
		d*=sign;
		System.out.println(d);
	}

}
