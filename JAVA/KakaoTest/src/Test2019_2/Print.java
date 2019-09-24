package Test2019_2;

public class Print {

	public static void main(String[] args) {
		int[][] data = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
//		int[][] data = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
		int len =data.length;
		int first = order(data);
		int number =first;
		int spendTime = data[first][2];
		for(int i=1;i<len;i++) {
			number = next(data,number,spendTime);
			spendTime+=data[number][2];
			System.out.print(" "+(number+1));
		}


	}
	//첫 번째 순서 정하기
	static int order(int[][]data) {
		int min=data[0][1];
		int index=0;
		int len =data.length;
		for(int i =0;i<len;i++) {
			if(min>data[i][1]) {
				min=data[i][1];
				index=i;
			}else if(min==data[i][1]) {
				if(data[index][2]>data[i][2]) {
					min=data[i][1];
					index=i;
				}
			}
		}
		System.out.print("제일 빠른 인쇄 번호는 "+(index+1));
		return index;
	}
	// 그 외 순서 구하기
	//1. 소요시간 구하기
	//2. 비교하기
	static int next(int[][]data, int first,int time) {
		int spendTime = 0;
		spendTime += time;
		data[first][1]=99;
		data[first][2]=99;
		int min=data[0][1];
		int index=0;
		for(int j=0;j<data.length;j++) {
			if((data[j][1]<=spendTime)) {
				if(data[index][2]>data[j][2]) {
					min=data[j][1];
					index=j;
				}
			}
		}
		if(index==0) {
			for(int i =0;i<data.length;i++) {
				if(min>data[i][1]) {
					min=data[i][1];
					index=i;
				}else if(min==data[i][1]) {
					if(data[index][2]>data[i][2]) {
						min=data[i][1];
						index=i;
					}
				}
			}
		}
		return index;
	}
}
