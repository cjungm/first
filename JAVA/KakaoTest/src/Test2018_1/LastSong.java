package Test2018_1;

public class LastSong {

	public static void main(String[] args) {
//		방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
//		네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
//		각 음은 1분에 1개씩 재생된다. 
//		음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 
//		음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
//		음악이 00:00를 넘겨서까지 재생되는 일은 없다.
//		조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
//		재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
//		조건이 일치하는 음악이 없을 때에는 “(None)“을 반환한다.
//		String m= "ABCDEFG";
//		String m= "CC#BCC#BCC#BCC#B";
		String m ="ABC";
//		String musicinfos[] = {"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};
//		String musicinfos[] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String musicinfos[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		int len = musicinfos.length;
		String ms[][]= new String[len][4];
		int time[] = new int [len];
		int cnt;
		for(int i=0;i<len;i++) {
			ms[i]=musicinfos[i].split(",");
			time[i] = timeC(ms[i][0], ms[i][1]);
			if(ms[i][3].contains("#")) {
				int index = ms[i][3].indexOf("#")-1;
					ms[i][3] =ms[i][3].substring(0,index) 
							+  ms[i][3].substring(index,index+1).toLowerCase()
							+ms[i][3].substring(index+2); 
			}
			System.out.println(ms[i][0]+ms[i][1]+ms[i][2]+ms[i][3]+"  "+time[i]);
		}
		for(int i=0;i<len;i++) {
			cnt=ms[i][3].length();
			int j=0;
			while(cnt<time[i]) {
				if(j==ms[i][3].length()) j=0;
				ms[i][3]+=ms[i][3].substring(j,j+1);
				cnt++;
				j++;
			}
			System.out.println(ms[i][3]);
		}
		for(int i=0;i<len;i++) {
			if(ms[i][3].contains(m)) {
				System.out.println(ms[i][2]);
			}
		}
		
	}
	static int timeC(String m, String s) {
		String a[]= m.split(":");
		String b[]= s.split(":");
		int before = Integer.parseInt(a[0])*60+Integer.parseInt(a[1]);
		int after = Integer.parseInt(b[0])*60+Integer.parseInt(b[1]);
		return after-before;
	}

}
