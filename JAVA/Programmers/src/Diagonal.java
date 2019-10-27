
public class Diagonal {

	public static void main(String[] args) {
		
		int w = 8;
		int h = 12;
		long answer = 1;
        long total=w*h;
        double rate = Math.ceil((double)h/w);
        answer= total - (long)rate*w;
        System.out.println(answer);
	}
}
