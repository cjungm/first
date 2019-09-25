package Line;

public class Num2 {

	public static void main(String[] args) {
		String a = "1 0 2";
		int b=5;
		String [] split = a.split(" ");
		String msg = "";
		int [] first =new int[split.length];
		int len = split.length;
		int depth[] = new int[len];
		int [] copy =new int[len];
		copy=first;
		for(int i=0;i<len;i++) {
			first[i]=Integer.parseInt(split[i]);
		}
		depth=minimum(first);
		
		for(int i=0;i<len;i++) {
			first[i]=Integer.parseInt(split[i]);
			msg+= depth[i];
		}
		int number1 = Integer.parseInt(msg);
		depth=maximum(first);
		msg="";
		for(int i=0;i<len;i++) {
			first[i]=Integer.parseInt(split[i]);
			msg+= depth[i];
		}
		int number2 = Integer.parseInt(msg);
		int cnt=0;
		for(int i=number1;i<=number2;i++) {
			msg=""+i;
			if((msg.contains(""+first[0]))&&(msg.contains(""+first[1]))&&(msg.contains(""+first[2]))) {
				cnt++;
			}
			if(cnt==(b-2)) {
				break;
			}
		}
		int answer = Integer.parseInt(msg);
		System.out.println(answer);
	}
	static int[] minimum(int [] first) {
		int min;//첫째 자리
		int depth[] =new int [first.length];
		int j=0;
		int index=0;
		while(true) {
			min=99;
			if(index==0) {
				for(int i=0;i<first.length;i++) {
					if((min>first[i])&&first[i]!=0) {
						min=first[i];
						j=i;
					}
				}
			}else {
				for(int i=0;i<first.length;i++) {
					if(min>first[i]) {
						min=first[i];
						j=i;
					}
				}
			}
			first[j]=99;
			depth[index]=min;
			index++;
			if(index>=first.length) {
				break;
			}
		}
		return depth;
	}
	static int[] maximum(int [] first) {
		int min;//첫째 자리
		int depth[] =new int [first.length];
		int j=0;
		int index=0;
		while(true) {
			min=0;
			if(index==0) {
				for(int i=0;i<first.length;i++) {
					if((min<first[i])&&first[i]!=0) {
						min=first[i];
						j=i;
					}
				}
			}else {
				for(int i=0;i<first.length;i++) {
					if(min<first[i]) {
						min=first[i];
						j=i;
					}
				}
			}
			first[j]=0;
			depth[index]=min;
			index++;
			if(index>=first.length) {
				break;
			}
		}
		return depth;
	}

}
