package Test2019_2;


public class Num1 {

	public static void main(String[] args) {
		int [] target= {2, 2, 2, 2, 2};
		int [][]positions= {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}};
		int answer=0;
		int score[] ={10,8,6,4,2,0};
		int dist[]= new int[5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				dist[i]+=target[j];
			}
			System.out.println(dist[i]);
		}
		for(int i=0;i<positions.length;i++) {
			int x= positions[i][0];
			int y = positions[i][1];
			double far = Math.sqrt(Math.pow((0-x), 2)+Math.pow((0-y), 2));
			if((far<=dist[4])&&far>dist[3]) {
				answer+=score[4];
			}else if((far<=dist[3])&&far>dist[2]) {
				answer+=score[3];
			}else if((far<=dist[2])&&far>dist[1]) {
				answer+=score[2];
			}else if((far<=dist[1])&&far>dist[0]) {
				answer+=score[1];
			}else if(far<=dist[1]) {
				answer+=score[0];
			}
		}
		System.out.println(answer);
	}
}
