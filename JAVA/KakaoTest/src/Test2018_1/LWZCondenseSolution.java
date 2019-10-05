package Test2018_1;

import java.util.ArrayList;
import java.util.HashMap;

public class LWZCondenseSolution {

	public static void main(String[] args) {
		ArrayList<String> dic = new ArrayList<>();
		String msg ="ABABABABABABABAB";
//		String msg ="KAKAO";
		solution(msg);
	}

	public static ArrayList<String> solution(String str) {
	    // 사전으로 사용할 맵을 생성하고 기초데이터를 입력
	    HashMap dicMap = new HashMap<String, String>();
	    char c = 'A';
	    int n = 1;
	    while(dicMap.size() < 26) {
	        dicMap.put(String.valueOf(c++), String.valueOf(n++));
	    } 
	    
	    // 메인소스
	    ArrayList<String> retList = new ArrayList<String>();
	    while(!str.isEmpty()) {
	        for(int i = str.length(); i > 0; i--) {
	            if(dicMap.containsKey(str.substring(0,i))){
	                String key = str.substring(0, i);
	                String nextKey = str.length() >= i+1 ? str.substring(i, i+1) : str.substring(i-1, i);
	                retList.add((String) dicMap.get(key));
	                if(!nextKey.isEmpty() && !dicMap.containsKey(key+nextKey)) { 
	                    dicMap.put(key+nextKey, String.valueOf(dicMap.size()+1));
	                    System.out.print(dicMap.get(str.substring(0, i)));
	                }
	                str = str.substring(key.length());
	                break;
	            }
	        }
	    }
	    return retList;
	}
	}
	
