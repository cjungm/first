package Test2019_2;
public class Bubble {

	public static void main(String[] args) {
		String [] drum= {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		int len = drum.length;
		int answer = drum.length;
		char[][]logic = new char[len][len];
		for (int i =0;i<len;i++) {
			for(int j=0;j<len;j++) {
				logic[i][j] = drum[i].charAt(j);
				System.out.print(logic[i][j]);
			}
			System.out.println("");
		}
		int horizental = 0;
		int vertical = 0;
		int meet = 0;
		int[] memo = new int [len];
		int startPoint = 0;
		while(startPoint<len) {
			horizental=startPoint;
			vertical=0;
			startPoint++;
			meet=0;
			while(vertical<=len) {
				switch(logic[vertical][horizental]) {
					case '#':
						vertical++;
						break;
					case '<':
						horizental--;
						break;
					case '>':
						horizental++;
						break;
					case '*':
						if(meet==0) {
							vertical++;
							meet++;
						}else {
							memo[startPoint-1]=-1;
							vertical=len+1;
							break;
						}
						break;
				}
				if(vertical==len) {
					memo[startPoint-1]=startPoint;
					break;
				}
			}
		}
		for(int i =0;i<len;i++) {
			if(memo[i]<0) {
				answer--;
			}
			
		}
		System.out.print("answer="+answer);
	}

}
