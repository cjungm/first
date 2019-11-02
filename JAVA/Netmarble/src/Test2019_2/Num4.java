package Test2019_2;

import java.util.ArrayList;

public class Num4 {

	public static void main(String[] args) {
		
		int k=3;
//		int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		int [] score= {24,22,20,10,5,3,2,1};
		int answer=score.length;
		int len = score.length;
		int[][] check = new int[len][2];
		check[0][0]=score[0];

		for(int i=1;i<len;i++) {
			check[i][0]=score[i];
			check[i][1]=score[i-1]-score[i];
			System.out.println(check[i][0]+" "+check[i][1]);
		}
		int index=check[1][1];
		
		for(int i=1;i<len;i++) {
			ArrayList<Integer> rank = new ArrayList<>();
			index=check[i][1];
			if(index>0) {
				for(int j=i;j<len;j++) {
					if(index==check[j][1]) {
						if(j>i) check[j][1]=-1;
						rank.add(j);
					}
				}
			}
			if(rank.size()>=k) {
				for(int q=0;q<rank.size();q++) {
					if(check[rank.get(q)-1][0]>0) {
						answer--;
						check[rank.get(q)-1][0]=-1;
					}
					if(check[rank.get(q)][0]>0) {
						check[rank.get(q)][0]=-1;
						answer--;
					}
				}
			}

		}

		System.out.println(answer);
	}

}
