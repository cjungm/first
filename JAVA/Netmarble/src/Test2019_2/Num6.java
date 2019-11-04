package Test2019_2;

public class Num6 {

	public static void main(String[] args) {
		int h=7;
		int w=9;
		int n=4;
		String [] board= {"111100000","000010011","111100011","111110011","111100011","111100010","111100000"};
		int answer=0;
		int len= board.length;
		for(int i=0;i<len;i++) {
			System.out.println(board[i]);
		}
		//네가지 측정 가로 세로 대각 대각

//		while(true) {
			for(int i=0;i<h;i++) {
				int cnt=0;
				for(int j=0;j<w-1;j++) {
					
					if(board[i].substring(j,j+1).equals("1")) {
						cnt++;
					}else {
						if(cnt==n) {
							answer++;
						}
						cnt=0;
					}
				}
				if(cnt==n) {
					answer++;
				}

			}
			for(int i=0;i<w;i++) {
				int cnt=0;
				for(int j=0;j<h;j++) {
					
					if(board[j].substring(i,i+1).equals("1")) {
						cnt++;
					}else {
						if(cnt==n) {
							answer++;
						}
						cnt=0;
					}
				}
				if(cnt==n) {
					answer++;
				}
			}

				for(int j=0;j<w;j++) {
					int cnt=0;
					int max=0;
					if(0>j)max=0;
					if(0<j)max=j;
					if(max>=h)max=h-1;
					for(int k=0;k<=max;k++) {

						if(board[k].substring(j-k,j-k+1).equals("1")) {
							cnt++;
						}else {
							if(cnt==n) {
								answer++;
							}
						cnt=0;
						}
						}
					
					if(cnt==n) {
					answer++;
					}
				}
				for(int i=1;i<h;i++) {
					int cnt=0;
					for(int j=h-i;j>0;j--) {
						if(board[h-j].substring(w+j-h,w+j-h+1).equals("1")) {
							cnt++;
						}else {
							if(cnt==n) {
								answer++;
							}
						cnt=0;
						}
					}					
				}
			
				for(int j=w-1;j>=0;j--) {
					int cnt=0;
					int max=w-j-1;
					if(max>=h)max=h;
					for(int k=0;k<max;k++) {
						if(board[k].substring(j+k,j+k+1).equals("1")) {
							cnt++;
						}else {
							if(cnt==n) {
								answer++;
							}
						cnt=0;
						}
					}
					if(cnt==n) {
					answer++;
					}
				}
				for(int i=1;i<h;i++) {
					int cnt=0;
					for(int j=0;j<h-i;j++) {

						if(board[i+j].substring(j,j+1).equals("1")) {
							cnt++;
						}else {
							if(cnt==n) {
								answer++;
							}
						cnt=0;
						}
					}

					
				}
			
			
			System.out.println(answer);
//		}
	}

}
