package DynamicProgramming;

import java.util.Scanner;

public class Coin1 {

	public static void main(String[] args) {
//		문제
//		n가지 종류의 동전이 있다. 
//		각각의 동전이 나타내는 가치는 다르다. 
//		이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
//		그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
//		사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
//
//		입력
//		첫째 줄에 n, k가 주어진다. 
//		(1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 
//		동전의 가치는 100,000보다 작거나 같은 자연수이다.
		Scanner scanner = new Scanner(System.in);
		int n= scanner.nextInt();
		int k = scanner.nextInt();
		int []arr = new int [n];
		int answer = 0;
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		int sum=0;
		answer=routine(arr, k, 0, sum, answer);
		System.out.println(answer);
		scanner.close();
		
	}
	static int routine(int []a, int b,int c,int sum,int answer) {
		int time=b/a[c];
		int temp =sum;
		while(time>=0) {
			sum=temp;
			if(c==a.length-1) {
				sum+=a[c]*time;
				if(sum==b)answer++;
			}else {
				sum+=a[c]*time;
				answer= routine(a, b, c+1, sum, answer);
			}
			time--;
			
		}
		return answer;
	}
}
