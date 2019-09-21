package Num2;

public class DartsGame {

	public static void main(String[] args) {
		String score = "1S2D*3T";
		String set[] = new String[3];
		int curPoint=0;
		int index[] = new int[3];
		int i =0;
		while(curPoint<score.length()) {
			String target = score.substring(curPoint,curPoint+1);
			switch(target) {
			case "S":
				index[i]=curPoint;
				break;
			case "D":
				index[i]=curPoint;
				break;
			case "T":
				index[i]=curPoint;
				break;
			}
			curPoint++;
		}
		set[0] = score.substring(0, index[0]+1);
		set[1] = score.substring(index[0]+1, index[1]+1);
		set[2] = score.substring(index[1]+1);
		int [] scoreChange = new int[3];
		int total =0;
		for(int j =0 ;j<set.length;j++) {
			scoreChange[i] = calculate(set[j],j+1);
		}
		for(int j =1 ;j<set.length;j++) {
			if(set[j].contains("*")) {
				if(j==1) {
					scoreChange[j-1]*=2;
				}else {
					scoreChange[j-1]*=2;
					scoreChange[j-2]*=2;
				}
			}
			if(set[j].contains("#")) {
					scoreChange[j]*=(-1);
			}
		}
		total = scoreChange[0]+scoreChange[1]+scoreChange[2];
		System.out.println(""+total);
	}
	static int calculate(String str, int order) {
		if(str.contains("S")) {
			order= (int) Math.pow(order, 1);
		}
		else if(str.contains("D")) {
			order= (int) Math.pow(order, 2);
		}
		else if(str.contains("T")) {
			order= (int) Math.pow(order, 3);
		}
		return order;
	}
}
