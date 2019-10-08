package Test2018_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LastSongSolution {

	public static void main(String[] args) {
//		String m= "ABCDEFG";
//		String m= "CC#BCC#BCC#BCC#B";
		String m ="ABC";
//		String musicinfos[] = {"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};
//		String musicinfos[] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String musicinfos[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

		System.out.println (findMusic(m,musicinfos));
		
	}
	/**
	 * hh:mm 형식의 두 시간의 차를 분단위로 리턴
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getMin(String startTime, String endTime) {
	    String[] arr;
	    arr = startTime.split(":");
	    int startMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	    
	    arr = endTime.split(":");
	    int endMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	    
	    return Math.abs(endMin-startMin);
	}
	public static String findMusic(String m, String[] musicInfos) {
	    ArrayList<String> matchMusic = new ArrayList<String>();
	    
	    // #문자와 혼동을 피하기 위해서 '대문자#'을 '소문자' 로 변경하여 스트링 비교
	    m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a");
	    
	    for(String str : musicInfos) {
	        String[] arr = str.split(",");
	        
	        int playLen = getMin(arr[0], arr[1]); // 실제 재생 분을 구함
	        String orgPlayStr = arr[3]; // 원곡의 음표
	        // #문자와 혼동을 피하기 위해서 '대문자#'을 '소문자' 로 변경하여 스트링 비교
	        orgPlayStr = orgPlayStr.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a");
	        
	        // 실제 재생된 음표를 구함 rearPlayStr
	        int j = 0;
	        String rearPlayStr = "";
	        for(int i = 0; i < playLen ; i++) {
	            j = i % orgPlayStr.length();
	            rearPlayStr += orgPlayStr.charAt(j);
	        }
	        
	        if(rearPlayStr.contains(m)) {
	            matchMusic.add(str);
	        }
	    }
	    
	    // 조건에 맞는 음악이 여러개인 경우 재생시간이 긴곡, 재생시간도 같다면 먼저 입력된 곡
	    Collections.sort(matchMusic, new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2) {
	            String arr[] = o1.split(",");
	            int len1 = getMin(arr[0], arr[1]);
	            int len2 = getMin(arr[0], arr[1]);
	            return len2 - len1;
	        }
	    });
	    
	    return matchMusic.size() > 0 ? matchMusic.get(0).split(",")[2] : "(none)";
	}


}
