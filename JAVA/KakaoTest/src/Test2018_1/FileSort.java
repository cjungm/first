package Test2018_1;

import java.util.ArrayList;
import java.util.Scanner;

public class FileSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		String str= "“img12.png”, “img10.png”, “img02.png”, “img1.png”, “IMG01.GIF”, “img2.JPG”";
		String str= " “F-5 Freedom Fighter”, “B-50 Superfortress”, “A-10 Thunderbolt II”, “F-14 Tomcat”";
		sortFile(str);
	}

	static void sortFile(String str) {
		str=str.substring(1,str.length()-1);
		String msg[] = str.split(", ");
		int len = msg.length;
		int index = 0;
		for(int i=0;i<len;i++) {
			msg[i]=msg[i].substring(1,msg[i].length()-1);
		}
		String[] text= new String[26];
		for(int i=0;i<26;i++) {
			text[i]= Character.toString((char)(i+65));
		}
		System.out.print("[");
			for(int i=0;i<26;i++) {
				ArrayList<String>same =  new ArrayList<>();
				for(int j=0;j<len;j++) {
					if(text[i].equalsIgnoreCase(msg[j].substring(0,1))) {
						same.add(msg[j]);
					}
				}
				
				while(!same.isEmpty()) {
					int min=0;
					if(same.size()>0) {
						for(int k=1;k<same.size();k++) {
							int numStr = Integer.parseInt(same.get(min).replaceAll("[^0-9]",""));
							int numStr2 = Integer.parseInt(same.get(k).replaceAll("[^0-9]",""));
							if(numStr>numStr2) {
								min=k;
							}else if(numStr==numStr2) {
								int tail = same.get(min).charAt(same.get(min).indexOf(".")+1);
								int tail2 = same.get(k).charAt(same.get(k).indexOf(".")+1);
								if(tail<tail2) {
									min=k;
								}
								
							}
						}
						System.out.print("\""+same.get(min)+"\" ");
						same.remove(min);
					}
					
				}
				
			}
			System.out.print("]");
	}
}
//[“img12.png”, “img10.png”, “img02.png”, “img1.png”, “IMG01.GIF”, “img2.JPG”]