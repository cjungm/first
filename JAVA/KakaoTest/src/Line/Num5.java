package Line;

public class Num5 {

	public static void main(String[] args) {
		int a=9;
		int b=9;
		int x=4,y=5;
		int answer=0;
		int way[][] = new int[y][x];
		if((x>a)||(y>b)) {
			System.out.println("fail");
		}else {
			for(int i=0;i<y;i++) {
				way[i][0]=i+2;
			}
			for(int i=0;i<x;i++) {
				way[0][i]=i+2;
			}
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					if((i!=0)&&(j!=0)) {
						way[i][j]=way[i-1][j]+way[i][j-1];
					}
					System.out.print(way[i][j]+" ");
				}
				System.out.println();
			}
		}
		answer= way[y-1][x-1];
		System.out.println(answer);

	}

}
