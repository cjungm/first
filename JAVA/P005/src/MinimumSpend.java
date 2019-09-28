
public class MinimumSpend {

	public static void main(String[] args) {
		// TODO 어떤 그래프 G가 N개의 정점과, 서로 다른 가중치를 갖는 E개의 간선으로 구성
		//		간선을 따라 n개의 정점을 사이클 없이 모두 연결할 때 포함된 간선의 가중치 총합이 가장 작은 경우를 
		//		찾아 출력해주는 최소비용 그래프 알고리즘을 제시하라
		int c[]= {4,2,10,7,12,15,18,20,9,13,1};		//	간선의 가중치
		int cycle[]= {0,0,0,0,0,1,0};				//	6번째 사이클 발생
		int n=7;
		int e=c.length;
		int temp;
		for(int i=0;i<e;i++) {
			System.out.print(c[i]+"\t");
		}
		for(int i=0;i<e-1;i++) {
			for(int j=i+1;j<e;j++) {
				if(c[i]>c[j]) {
					temp=c[i];
					c[i]=c[j];
					c[j]=temp;
				}
			}
		}
		System.out.println();
		for(int i=0;i<11;i++) {
			System.out.print(c[i]+"\t");
		}
		int l=1;		//	최소비용 그래프에 참여한 간선의 개수
		int k=0;		//	반복용 변수
		int t=0;		//	최소비용 그래프에 참여한 간선들의 가중치 총합
		while(l<=(n-1)) {
			if(cycle[k]==0) {
				t+=c[k];
				l+=1;
			}
			k+=1;
		}
		System.out.println("\n가중치 총합: "+t);
	}

}
