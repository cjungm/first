package Num4;

import java.util.Arrays;

public class ShuttleBus {

	 public static void main(String[] args) {
	        System.out.println(getLastTime(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
	        System.out.println(getLastTime(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
	        System.out.println(getLastTime(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
	        System.out.println(getLastTime(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
	        System.out.println(getLastTime(1, 1, 1, new String[]{"23:59"}));
	        System.out.println(getLastTime(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59"
	                , "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
	    }
	    
	    /**
	     * 마지막으로 탈 수 있는 버스 시간 추출
	     * @param n 금일 버스운행 횟수
	     * @param t 버스운행 간격
	     * @param m 한번에 태울 수 있는 사람 수
	     * @param waitTime 줄서고 있는 사람들
	     * @return 마지막으로 탈 수 있는 버스 시각
	     */
	    public static String getLastTime(int n, int t, int m, String[] waitTime) {
	        String answer = "";
	        
	        // 버스 도착시간 계산
	        String[] busTime = new String[n];
	        for(int i = 0; i < n ; i++) {
	            busTime[i] = getAddTime("09:00", t*i);
	        }
	        
	        String lastBustTime = busTime[n-1];
	        
	        //대기자 명단을 먼저온 기준으로 정렬
	        Arrays.sort(waitTime);
	        
	        int curPos = 0;
	        int curAdded = 0;
	        String busStop = "";
	        for(int j = 0; j < busTime.length; j++) {
	            busStop = busTime[j];
	            curAdded = 0;
	            // 순차적으로 버스가 들어옴을 for로 처리
	            for(int k = curPos ; curPos < waitTime.length; k++) {
	                // 현재 버스에 시간 이전에 도착한 사람이 있는 경우  && 현재 버스에  빈 자리가 있는 경우
	                if(getMinLong(busStop)>=getMinLong(waitTime[k]) && curAdded < m ) {
	                    answer = waitTime[curPos]; // 마지막 탑승 가능한 사람 도착 시간 입시저장
	                    answer = getAddTime(answer, -1); // 마지막 탑승 가능자 보다 1분 빨리 오도록 임시시간 지정
	                    curPos++;
	                    curAdded++;
	                    // curAdd < m 버스 자리가 여유있고, 마지막 탑승객이면 현재 버스 시간에 맞게 나감
	                    if(j==busTime.length -1 && k == waitTime.length-1 && curAdded < m) {
	                        answer = busTime[n-1];
	                    }
	                }
	                else {
	                    // 마지막 버스 인데 탑승객이 전부 못타는 경우 최종탑승자(answer)보다 빨리 와야 함
	                    if(j==busTime.length-1 && curPos >= 1) {
	                        // 마지막 탑승 가능한 사람 도착 시간 입시저장
	                        answer = waitTime[curPos -1];
	                        answer = getAddTime(answer, -1);    
	                    }
	                    break;
	                }
	            }
	        }
	        
	        // 마지막 버스를 타도 여유가 있는 경우
	        if("".equals(answer)||getMinLong(answer) > getMinLong(lastBustTime)) {
	            answer = lastBustTime;
	        }
	        
	        return answer;
	    }
	    
	    /**
	     * hh:mm의 String을 입력받아 addMin만큼 더한 시간 리턴
	     * @param hhmm
	     * @param addMin
	     * @return hhmm분에 addMin분 을 합산한 시간
	     */
	    private static String getAddTime(String hhmm, int addMin) {
	        long temp = getMinLong(hhmm);
	        temp = temp + addMin;
	        int hh = (int)temp/60;
	        int mm = (int)temp%60;
	        return String.format("%02d", hh)+":"+String.format("%02d", mm);
	        
	    }
	    
	    /**
	     * hh:mm 의 스트링을 입력받아 long형태의 분으로 리턴
	     * 입력 String 01:30, 출력 long 90
	     * @param hhmm
	     * @return long타입의 분
	     */
	    private static long getMinLong(String hhmm) {
	        String arr[] = hhmm.split(":");
	        int hh = Integer.parseInt(arr[0]);
	        int mm = Integer.parseInt(arr[1]);
	        return hh*60+mm;
	    }
	}
