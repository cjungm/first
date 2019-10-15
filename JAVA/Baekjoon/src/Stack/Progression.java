package Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Progression {

	public static void main(String[] args) {
//		크기가 N인 수열 A = A1, A2, ..., AN이 있다. 
//		수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
//		Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 
//		그러한 수가 없는 경우에 오큰수는 -1이다.
//		예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. 
//		A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> rightBig = new ArrayList<>();
		int cnt = scanner.nextInt();
		while(cnt>0) {
			int num = scanner.nextInt();
			rightBig.add(num);
			cnt--;
		}
		for(int i=0;i<rightBig.size();i++) {
			if(rightBig.size()==0)break;
			if(i==rightBig.size()-1) {
				System.out.print("-1");
				break;
			}
			for(int j=i+1;j<rightBig.size();j++) {
				if(rightBig.get(i)<rightBig.get(j)) {
					System.out.print(rightBig.get(j)+"\t");
					break;
				}else if(j==rightBig.size()-1&&rightBig.get(i)>=rightBig.get(j)) {
					System.out.print("-1\t");
				}
			}
			
		}
		scanner.close();
	}

}
