package Line;

import java.util.Scanner;

public class Num1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = 5;
		int b = 2;
		int time [] = {4,3,5,2,8};
		int process[][]= new int [b][a];
		int spendTime1=0;
		int spendTime2=0;
		for(int i=0;i<time.length;i++) {
			if(spendTime1<=spendTime2) {
				spendTime1+=do1(i,time);
			}else {
				spendTime2+=do2(i,time);
			}
		}
		if(spendTime1<=spendTime2) {
			System.out.println(""+spendTime2);
		}else {
			System.out.println(""+spendTime1);
		}
	}
	static int do1(int i,int time[]) {
		int spendTime1=0;
		int j=0;
		while(true) {
			if(j<time[i]) {
				j++;
			}else {
				break;
			}	
		}
		spendTime1+=j;
		return spendTime1;
	}
	static int do2(int i,int time[]) {
		int spendTime1=0;
		int j=0;
		while(true) {
			if(j<time[i]) {
				j++;
			}else {
				break;
			}	
		}
		spendTime1+=j;
		return spendTime1;
	}
}
