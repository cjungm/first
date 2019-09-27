
public class Complement {

	public static void main(String[] args) {
		// TODO 2진수에 대하여 2의 보수를 구하는 알리즘을 제시하라
		int[] b= {0,1,0,1,0};
		int o[]= new int[5];
		int t[] = new int[5];
		int i=0;
		do {
			o[i]=1-b[i];
			i++;
		}while(i<5);
		i=4;
		int c=1;
		do {
			t[i]=1;
			if(o[i]==c) t[i]=0;
			c=o[i]*c;
			i--;
		}while(i>=0);
		for(int a=0;a<5;a++) {
			System.out.print(t[a]);
		}
		System.out.println();
	}

}
