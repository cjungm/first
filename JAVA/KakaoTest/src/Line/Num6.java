package Line;

public class Num6 {

	public static void main(String[] args) {
		int a=4;	//입력받을 데이터의 개수
		int b=9;	//세로
		String way ="MIDDLE";	//방식
		int total=0; 	//가로 전체 길이
		int cnt=0;
		String content[][]= {{"5", "123"},{"9","45"},{"7","7890"},{"3","6"}};
		
		for(int i=0;i<a;i++) {
			total+=(content[i][1].length()*Integer.parseInt(content[i][0]));
			cnt+=content[i][1].length();
		}
		int number[][][]= new int [a][cnt][2];
		for(int i=0;i<a;i++) {
			int convert = Integer.parseInt(content[i][1]);
			for(int j=content[i][1].length()-1;j>=0;j--) {
				number[i][j][0]=Integer.parseInt(content[i][0]);
				number[i][j][1]=convert%10;
				convert/=10;
				
			}
		}		

		for(int k=0;k<b;k++) {
			for(int i=0;i<a;i++) {
				for(int j=0;j<content[i][1].length();j++) {
					numberPrint(number[i][j][1],k,number[i][j][0],way);
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
		
		
	}
	static void numberPrint(int number, int order, int size, String way) {
		int point=4;
		int start=0,end=8;
		for(int i=0;i<size;i++) {
			start=0;
			point=4;
			end=8;
			if(size==3) {
				switch(way) {
				case "TOP":
					start=0;
					point=2;
					end=4;
					break;
				case "MIDDLE":
					point=4;
					start=2;
					end=6;
					break;
				case "BOTTOM":
					point=6;
					start=4;
					end=8;
					break;
				}
			}
			switch(number) {
			case 0:
				if((order>=start)&&(order<=end)) {
					if(((order>start)&&(order<=point))||((order>point)&&(order<end))) {
						if((i==0)||(i==size-1)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 1:
				if((order>=start)&&(order<=end)) {
					if((i==size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 2:
				if((order>=start)&&(order<=end)) {
					if((order>start)&&(order<point)) {
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>point)&&(order<end)){
						if(i==0) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 3:
				if((order>=start)&&(order<=end)) {
					if(((order>start)&&(order<point))||((order>point)&&(order<end))) {
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 4:
				if((order>=start)&&(order<=end)) {
					if((order>=start)&&(order<point)) {
						if((i==size-1)||(i==0)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>point)&&(order<=end)){
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 5:
				if((order>=start)&&(order<=end)) {
					if((order>start)&&(order<point)) {
						if(i==0) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>point)&&(order<end)){
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 6:
				if((order>=start)&&(order<=end)) {
					if((order>=start)&&(order<point)) {
						if(i==0) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>point)&&(order<end)) {
						if((i==size-1)||(i==0)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 7:
				if((order>=start)&&(order<=end)) {
					if((order>start)&&(order<point)) {
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>=point)&&(order<=end)){
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 8:
				if((order>=start)&&(order<=end)) {
					if(((order>start)&&(order<point))||((order>point)&&(order<end))) {
						if((i==0)||(i==size-1)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			case 9:
				if((order>=start)&&(order<=end)) {
					if((order>start)&&(order<point)) {
						if((i==size-1)||(i==0)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else if((order>point)&&(order<=end)){
						if(i==size-1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}else {
						System.out.print("#");
					}
				}else {
					System.out.print(".");
				}
				break;
			}
		}
	}

}
