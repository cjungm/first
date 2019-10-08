package Test2018_1;

public class AutoCompletion {

	public static void main(String[] args) {
//		go를 찾을 때 go를 모두 입력해야 한다.
//		gone을 찾을 때 gon 까지 입력해야 한다. (gon이 입력되기 전까지는 go 인지 gone인지 확신할 수 없다.)
//		guild를 찾을 때는 gu 까지만 입력하면 guild가 완성된다.
//		이 경우 총 입력해야 할 문자의 수는 7이다.
//		String [] words = {"go","gone","guild"};
//		String [] words = {"abc","def","ghi","jklm"};
		String [] words = {"word","war","warrior","world"};
		int len = words.length;
		int [] count = new int [len];
		int cnt;
		int answer=0;
		int i=0;
		while(i<len) {
			int [] temp = new int [len];
			for(int j=0;j<len;j++) {
				cnt=0;
				if(j!=i) {
					for(int k=0;k<words[i].length();k++) {
						if(words[j].length()>=k+1&&words[j].substring(k, k+1).equals(words[i].substring(k,k+1))) {
							cnt++;
						}
					}
				}
				temp[j]=cnt;
			}
			count[i]=findMax(temp);

			i++;
		}
		for(int j=0;j<len;j++) {
			if(words[j].length()>count[j]) {
				count[j]++;
			}
			answer+=count[j];
		}
		System.out.println(answer);
	}
	static int findMax(int [] temp) {
		int max=0;
		for(int i=0; i<temp.length;i++) {
			if(temp[i]>max)max=temp[i];
		}
		return max;
	}

}
