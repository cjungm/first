package Num7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TrafficSoulution {

public static class LogVo {
        
        long startDtm, endedDtm;
        String orgStr;
        
        public LogVo(long startDtm, long endedDtm, String orgStr) {
            this.startDtm = startDtm;
            this.endedDtm = endedDtm;
            this.orgStr = orgStr;
        }
        
        public long getStartDtm() {
            return startDtm;
        }
        
        public long getEndedDtm() {
            return endedDtm;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution(new String[]{"2016-09-15 20:59:57.421 0.351s"
                , "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s"
                , "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s"
                , "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s"
                , "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s"
                , "2016-09-15 21:00:02.066 2.62s"}));
    }
    
    private static int solution(String[] input) {
        ArrayList<LogVo> list = new ArrayList<LogVo>(); // LogVo를 담을 List
        
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        for(String s : input) {
            String arr[]= s.split(" ");
            try {
                // 시간계산을 간단히 처리하기 위해서 모두 시작시각, 종료시각을 long으로 처리
                long endedDtm = dt.parse(arr[0]+" "+arr[1]).getTime();
                long proceDtm = (long)(Double.parseDouble(arr[2].replace("s", ""))*1000); 
                long startDtm = endedDtm - proceDtm + 1;
                // LogVo를 생성하여 list에 추가
                list.add(new LogVo(startDtm, endedDtm, s));
            } catch (ParseException e) {
                e.printStackTrace();
                return -1;
            }
        }
        
        int maxCnt = 0; // 최대값
        for(LogVo sourceVo : list) {
            long startDtm = sourceVo.getStartDtm(); // 시작시각
            long endedDtm = sourceVo.getEndedDtm(); // 종료시각
            int startCnt = 0; // 현재 로그 시작구간에서 실행중이 트랜젝션 갯수
            int endedCnt = 0; // 현재 로그 종료구간에서 실행중이 트랜젝션 갯수
            for(LogVo targetVo : list) {
                if(startDtm <= targetVo.getEndedDtm() && startDtm + 999 >= targetVo.getStartDtm()) {
                    startCnt++;
                }
                if(endedDtm <= targetVo.getEndedDtm() && endedDtm + 999 >= targetVo.getStartDtm()) {
                    endedCnt++;
                }
            }
            maxCnt = startCnt > maxCnt ? startCnt : maxCnt;
            maxCnt = endedCnt > maxCnt ? endedCnt : maxCnt;
        }
        return maxCnt;
    }


}
