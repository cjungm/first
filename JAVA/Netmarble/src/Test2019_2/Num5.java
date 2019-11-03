package Test2019_2;

public class Num5 {

	public static void main(String[] args) {
		String [] offers= {"07/01 07/30 2000", "07/01 07/15 2000", "07/01 07/30 2000", "07/01 07/30 1500", "07/05 07/30 2100", "07/20 08/01 2400", "07/20 07/31 2400", "07/31 09/01 2900", "08/01 08/15 3000", "08/14 08/19 2000","08/17 08/30 4000"};
//		String [] offers= {"10/05 10/12 2400", "10/05 10/10 2500", "10/07 10/15 2300", "10/08 10/30 3000", "10/15 11/03 3000", "10/20 11/01 3500", "11/02 11/11 4000"};
		int len = offers.length;
		int answer = 0;
		String[][] offer = new String[len][3];
		for(int i=0;i<len;i++) {
			offer[i]=offers[i].split(" ");
			System.out.println(offer[i][0]+" "+offer[i][1]+" "+offer[i][2]);
		}
		int index=0;
		int max=Integer.parseInt(offer[0][2]);
		int [][] num = new int [len][3];
		for(int i=0;i<len;i++) {
			for(int j=0;j<3;j++) {
				switch(j) {
				case 0:
					num[i][j]=Integer.parseInt(offer[i][j].substring(0,2))*30+Integer.parseInt(offer[i][j].substring(3,5));
					
					break;
				case 1:
					num[i][j]=Integer.parseInt(offer[i][j].substring(0,2))*30+Integer.parseInt(offer[i][j].substring(3,5));
					break;
				case 2:
					num[i][j]=Integer.parseInt(offer[i][2]);
					break;
				}
			}
		}
		for(int i=0;i<len;i++) {
			for(int j=i;j<len-1;j++) {
				int temp =num[j][2];
				if((max<temp)&&(num[i][1]>=num[j][0])){
					max=Integer.parseInt(offer[i][2]);
					index=i;
				}
			}
		}
		answer=num[index][2];
		System.out.println(num[index][2]);
	}

}
