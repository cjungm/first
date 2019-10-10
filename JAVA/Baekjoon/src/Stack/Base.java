package Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Base {
	static int head=0;
	public static void main(String[] args) {
//		정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//		명령은 총 다섯 가지이다.
//		push X: 정수 X를 스택에 넣는 연산이다.
//		pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 스택에 들어있는 정수의 개수를 출력한다.
//		empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//		top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		int n=0;
		String msg="";
		Scanner scanner = new Scanner(System.in);
		n= scanner.nextInt();
		int i=0;
		ArrayList<Integer>stack = new ArrayList<>();

		while(i<=n) {
			msg = scanner.nextLine();
			String [] command =msg.split(" ");
			switch(command[0]) {
			case "push":
				int x=Integer.parseInt(command[1]);
				push(stack,x);
				break;
			case "pop":
				pop(stack);
				break;
			case "size":
				size(stack);
				break;
			case "empty":
				empty(stack);
				break;
			case "top":
				top(stack);
				break;
			}
			i++;
		}
	}

	 static void top(ArrayList<Integer> stack) {
		 if(head>0) {
			 System.out.println(stack.get(head-1));
		}
		else {
			System.out.println(-1);
		}		
	}

	static void empty(ArrayList<Integer> stack) {
		 if(stack.isEmpty()) {
			 System.out.println(1);
		 }else {
			 System.out.println(0);
		 }
	}

	static void size(ArrayList<Integer> stack) {
		 System.out.println(head);
	}

	static void pop(ArrayList<Integer> stack) {
		if(head>0) {
			 System.out.println(stack.get(head-1));
			 stack.remove(head-1);
			 head--;
		}
		else {
			System.out.println(-1);
		}
	}

	static void push(ArrayList<Integer> stack, int x) {
		stack.add(x);
		head++;
	}

}
