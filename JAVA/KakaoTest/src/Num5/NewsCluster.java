package Num5;

import java.util.ArrayList;
import java.util.Scanner;

public class NewsCluster {

	public static void main(String[] args) {
//		입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
//		입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 
//		이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 
//		예를 들어 “ab+”가 입력으로 들어오면, “ab”만 다중집합의 원소로 삼고, “b+”는 버린다.
//		다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. “AB”와 “Ab”, “ab”는 같은 원소로 취급한다.
		Scanner scanner = new Scanner (System.in);
		String str1=scanner.nextLine();
		String str2=scanner.nextLine();
		String arr1[];
		String arr2[];
		arr1= makeArr(str1);
		System.out.println();
		arr2= makeArr(str2);
		System.out.println();
		int small = and(arr1,arr2);
		int big = or(arr1,arr2);
		System.out.println(small);
		System.out.println(big);
		int jc = jacad(small, big);
		System.out.println(jc);
		
	}
	static String[] makeArr(String str) {
		str=str.replaceAll("[^A-Za-z]","").trim();
		int len = str.length();
		int arrlen= len-1;
		String arr[] = new String [arrlen];
		for(int i=0;i<arrlen;i++) {
			arr[i]=str.substring(i,i+2);
			System.out.print(arr[i]+"/");
		}
		return arr;
	}
	static int and(String[] arr1, String[] arr2) {
		ArrayList<String> same = new ArrayList<String>();
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i].equalsIgnoreCase(arr2[j])) {
					same.add(arr1[i]);
					arr2[j]="";
					break;
				}
			}
		}
		if(same.size()==0) {
			return -1;
		}

		return same.size();
	}
	
	static int or(String[] arr1, String[] arr2) {
		ArrayList<String> same = new ArrayList<String>();
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i].equalsIgnoreCase(arr2[j])) {
					arr2[j]="";
					break;
				}
			}
		}
		for(int i=0;i<arr1.length;i++) {
			same.add(arr1[i]);
		}
		for(int j=0;j<arr2.length;j++) {
			if(!arr2[j].equalsIgnoreCase("")) {
				same.add(arr2[j]);
			}
		}
		if(same.size()==0) {
			return -1;
		}

		return same.size();
	}
	static int jacad(int small, int big) {
		return (int)small*65536/big;
	}
}
