package Num7;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Traffic {

	public static void main(String[] args) {
//		solution 함수에 전달되는 lines 배열은 N(1 ≦ N ≦ 2,000)개의 로그 문자열로 되어 있으며, 
//		각 로그 문자열마다 요청에 대한 응답완료시간 S와 처리시간 T가 공백으로 구분되어 있다.
//		응답완료시간 S는 작년 추석인 2016년 9월 15일만 포함하여 고정 길이 2016-09-15 hh:mm:ss.sss 형식으로 되어 있다.
//		처리시간 T는 0.1s, 0.312s, 2s 와 같이 최대 소수점 셋째 자리까지 기록하며 뒤에는 초 단위를 의미하는 s로 끝난다.
//		예를 들어, 로그 문자열 2016-09-15 03:10:33.020 0.011s은
//		“2016년 9월 15일 오전 3시 10분 33.010초”부터 
//		“2016년 9월 15일 오전 3시 10분 33.020초”까지 “0.011초” 동안 처리된 요청을 의미한다. 
//		(처리시간은 시작시간과 끝시간을 포함)
		Scanner scanner = new Scanner(System.in);
		String day = scanner.nextLine();
		long [][] date = makeT(day);
//		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		“2016-09-15 01:00:04.001 2.0s”, “2016-09-15 01:00:07.000 2s”
//		“2016-09-15 01:00:04.002 2.0s”, “2016-09-15 01:00:07.000 2s”
//		“2016-09-15 20:59:57.421 0.351s”, “2016-09-15 20:59:58.233 1.181s”, “2016-09-15 20:59:58.299 0.8s”, “2016-09-15 20:59:58.688 1.041s”, “2016-09-15 20:59:59.591 1.412s”, “2016-09-15 21:00:00.464 1.466s”, “2016-09-15 21:00:00.741 1.581s”, “2016-09-15 21:00:00.748 2.31s”, “2016-09-15 21:00:00.966 0.381s”, “2016-09-15 21:00:02.066 2.62s”
		long min=makeMin(date);
		long max=makeMax(date);
		int cnt= (int)(max-min)/1000;
		int traffic[]=makeTraffic(max, min, date);
		int answer = traffic[0];
		for(int i=0;i<traffic.length;i++) {
			if(answer<traffic[i]) {
				answer=traffic[i];
			}
		}
		System.out.println(answer);
		
	}
	static long[][] makeT(String line) {
		String date[] = line.split(",");
		for(int i=0;i<date.length;i++) {
			date[i]=date[i].trim();
			date[i]=date[i].substring(1,date[i].length()-1);
		}
		int count = date.length;
		String time[][] = new String[count][3];
		long[][] total = new long [count][2];
		for(int i=0;i<count;i++) {
			time[i]=date[i].split(" ");
			String[] a = time[i][1].split(":");
			time[i][2]= time[i][2].replace("s","");
			String b = a[2].substring(0,3);
			String c = a[2].substring(4);
			total[i][1]=(long) (Double.parseDouble(a[0])*3600*1000
						+Double.parseDouble(a[1])*60*1000
						+Double.parseDouble(b)*1000
					+Double.parseDouble(c));
			total[i][0] =total[i][1]-(long)(Double.parseDouble (time[i][2])*1000)+2;
			System.out.println(total[i][0]+" "+total[i][1]);
		}
		return total;
	}
	static long makeMax(long[][] a) {
		long max=a[0][0];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j]>max) {
					max=a[i][j];
				}
			}
		}
		return max;
	}
	static long makeMin(long[][] a) {
		long max=a[0][0];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j]<max) {
					max=a[i][j];
				}
			}
		}
		return max;
	}
	static int[] makeTraffic(long max,long min,long[][]a) {
		int cnt= (int)(max-min)/1000;
		int traffic[]=new int[cnt+1];
		int k=0;
		for(long i=min;i<max;i+=1000) {
			for(int j=0;j<a.length;j++) {
				if(((a[j][0]>=i)&&(a[j][0]<i+1000))||((a[j][1]>=i)&&(a[j][1]<i+1000))){
					traffic[k]++;
					
				}
			}
			k++;
		}
		return traffic;
	}

}
