package Test2018_1;

import java.util.ArrayList;
import java.util.Scanner;

public class LWZCondense {
static int w=0;
	public static void main(String[] args) {
		//영문 대문자로 이루어진 문자열 msg 1=<msg=<1000
		Scanner scanner = new Scanner(System.in);
		String msg = scanner.nextLine();
		printIndex(msg);
		
	}
	static void printIndex(String msg) {
		int len= msg.length();
		int k=0;
		ArrayList<String> index = new ArrayList<String>();
		for(int i=0;i<26;i++) {
			index.add(Character.toString((char) (i+65)));
		}
		int j;
		System.out.print("[");
		while(w<len) {
			k=w;
			j=1;
			System.out.print(match(msg, index, k, j,len)+1);
			if(w==len) {
				break;
			}else {
				System.out.print(",");
			}
			}
		System.out.print("]");

		}
	static int match(String msg,ArrayList<String> index,int k, int j,int len) {
		int num=0;
		if(k+j<=len) {
			if(!index.contains(msg.subSequence(k, k+j))) {
				index.add((String) msg.subSequence(k, k+j));
				num=index.indexOf(msg.subSequence(k, k+j-1));
			}else {
				w++;
				num = match(msg, index,k,++j, len);
				
			}
		}else {
			num=index.indexOf(msg.subSequence(k, k+j-1));
		}
 
		return num;
		}
	}