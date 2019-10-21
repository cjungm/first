package Queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Dequeue2 {

	public static void main(String[] args) {
//		문제
//		정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//		명령은 총 여덟 가지이다.
//		push_front X: 정수 X를 덱의 앞에 넣는다.
//		push_back X: 정수 X를 덱의 뒤에 넣는다.
//		pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 덱에 들어있는 정수의 개수를 출력한다.
//		empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//		front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		
//		입력
//		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘쨰 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
//		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 
//		문제에 나와있지 않은 명령이 주어지는 경우는 없다.
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		String [][] command =new String[N+1][2];
		int n=N+1;
		int head=0;

		ArrayList<String>deq= new ArrayList<>(); 
		while(n>0) {
			n--;
			String msg= scanner.nextLine();
			command[n]=msg.split(" ");
		}
		for(int i=N-1;i>=0;i--) {
			switch(command[i][0]) {
			case "push_front":
				deq.add(head, command[i][1]);
				head++;
				break;
			case "push_back":
				deq.add(command[i][1]);
				head++;
				break;
			case "pop_front":
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.get(--head));
					deq.remove(head);
				}
				break;
			case "pop_back":
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.get(0));
					deq.remove(0);
					head--;
				}
				break;
			case "size":
				System.out.println(deq.size());
				break;
			case "empty":
				if(deq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.get(head-1));
				}
				break;
			case "back":
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.get(0));
				}
				break;
			}
		}
		scanner.close();
	}

}
