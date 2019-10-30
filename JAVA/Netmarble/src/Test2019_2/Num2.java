package Test2019_2;


public class Num2 {

	public static void main(String[] args) {
		String [] order_times= {"05:10", "12:10", "12:10", "12:10", "12:20", "13:00", "23:20"};
		int k=100;
		int answer=0;
		int len = order_times.length;
		int [] time = new int [len];
		for(int i=0;i<len;i++) {
			time[i]= Integer.parseInt(order_times[i].substring(0,2))*60+Integer.parseInt(order_times[i].substring(3,5));
			System.out.println(time[i]);
		}
		int min=time[0];
		int max=time[len-1];
		for(int i=0;time[i]<=max-k;i++) {
			int maxO=0;
			min=time[i];
			for(int j=0;j<len;j++) {
				if(time[j]>=min&&time[j]<=min+k) {
					maxO++;
				}
			}
			if(maxO>answer) {
				answer=maxO;
			}
		}
		System.out.println(answer);
	}

}
