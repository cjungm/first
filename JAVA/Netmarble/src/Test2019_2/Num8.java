package Test2019_2;

public class Num8 {

	public static void main(String[] args) {
		int [][] paths = {{1,5,1,1},{1,2,4,3},{1,3,3,2},{2,5,2,1},{2,4,2,3},{3,4,2,2}};
//		공항 개수 n = 5, 목적지 k = 4
		int n=5;
		int k=4;

		Graph graph = new Graph(n);
		for(int i=0;i<paths.length;i++) {
			graph.input(paths[i][0], paths[i][1], paths[i][2], paths[i][3]);
		}
		graph.findMin(1,k);

	}
	static class Graph{
	    private int n;           // 노드들의 수
	    private int maps[][];    // 노드들간의 시간 저장할 변수
	    private int costs[][];	 // 노드들간의 마일리지 저장할 변수
	 
	    public Graph(int n){
	        this.n = n;
	        maps = new int[n+1][n+1];				// 시간 계산 배열
	        costs = new int[n+1][n+1];				// 마일리지 계산 배열
	    }
	    public void input(int i,int j,int w, int z){
	        maps[i][j] = w;
	        maps[j][i] = w;
	        costs[i][j] = z;
	        costs[j][i] = z;
	    }
	 
	    public void findMin(int v, int k){			// 출발지 , 목적지
	        int distance[] = new int[n+1];          // 최단 거리를 저장할 변수
	        int mileage[] = new int[n+1];           // 최대 마일리지를 저장할 변수
	        boolean[] check = new boolean[n+1];     // 해당 노드를 방문했는지 체크할 변수
	         
	        //distance값 초기화.
	        for(int i=1;i<n+1;i++){
	            distance[i] = Integer.MAX_VALUE;	// (2^31) - 1
	            mileage[i] = Integer.MIN_VALUE;
	        }
	         
	        //시작노드값 초기화.
	        distance[v] = 0;						// 시작노드 1
	        mileage[v] = 0;
	        check[v] =true;							// 방문 확인
	         
	        //연결노드 distance갱신
	        for(int i=1;i<n+1;i++){
	            if(!check[i] && maps[v][i] !=0){	// 방문도 하지 않고 갈 수 있다면
	                distance[i] = maps[v][i];		// 거리 초기화
	                mileage[i] = costs[v][i];
	            }
	        }
	         
	         
	        for(int a=0;a<n-1;a++){
	            //원래는 모든 노드가 true될때까지 인데
	            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
	            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
	            int min=Integer.MAX_VALUE;			// 최소값
	            int min_index=-1;					// 최소 값 인덱스
	            int max=Integer.MIN_VALUE;			// 최소값
	            int max_index=-1;					// 최소 값 인덱스
	             
	            //최소값 찾기
	            for(int i=1;i<n+1;i++){
	            	
	                if(!check[i] && distance[i]!=Integer.MAX_VALUE){	// 방문한적이 없고 거리가 초기화 되었다면
	                    if(distance[i]<min ){							// 최소값과 인덱스 변경
	                        min=distance[i];
	                        min_index = i;
	                        max=mileage[i];
	                        max_index = i;
	                    }else if(distance[i]==min) {
	                    	if(mileage[i]>max) {
	                    		max=mileage[i];
		                        max_index = i;
	                    	}
	                    }
	                }
	            }
	             
	            check[min_index] = true;								// 최소 인덱스 방문 여부 체크
	            for(int i=1;i<n+1;i++){
	                if(!check[i] && maps[min_index][i]!=0){				// 방문학적이 없고 최소인덱스 거리와 
	                    if(distance[i]>distance[min_index]+maps[min_index][i]){
	                        distance[i] = distance[min_index]+maps[min_index][i];
	                        mileage[i] = mileage[max_index]+costs[max_index][i];
	                    }
	                }
	            }
	 
	        }
	         
	        //결과값 출력
        	System.out.print(distance[k]+" "+mileage[k]);

	    }
	}

}
