package Test2019_2;

import java.util.ArrayList;

public class Num3 {

	public static void main(String[] args) {
		int answer=0;
		int[] vote= {2,3,4,1,6,7,5};
		int member = vote.length;
		int limit = 3;
		if(member<=2) {
			answer=0;
		}
		int[][] graph=new int[member][2];
		for(int i=0;i<member;i++) {
			graph[i][0]=i;
			graph[i][1]=vote[i]-1;
			System.out.println(graph[i][0]+" "+graph[i][1]);
		}
		ArrayList<Integer> team = new ArrayList<>();
		int index=-1;
		int num=0;
		int cnt=0;
		for(int i=0;i<member;i++) {
			index=-1;
			cnt=0;
			for(int j=i;!(graph[i][0]==index);j++) {
				index=graph[j][1];
				j=graph[j][1]-1;
				if(team.contains(index)) break;
				team.add(index);
				cnt++;
			}
			if((cnt)>=limit) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
