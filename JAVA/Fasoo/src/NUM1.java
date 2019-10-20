import java.util.ArrayList;

public class NUM1 {

	public static void main(String[] args) {
//		문제 설명
//		4방향으로 움직일 수 있는 로봇이 좌표평면의 원점에 서 있습니다. 
//		이 로봇에게 알파벳으로 명령을 내려 특정 방향으로 1칸만큼 이동을 시킬 수 있습니다. 
//		로봇은 4방향으로 움직일 수 있으며, U는 위, L은 왼쪽, R은 오른쪽, D는 아래로 이동하라는 명령어입니다. 
//		로봇에게 명령을 하나의 문자열로 묶어서 내릴 수 있습니다. 예를 들어, 로봇에게 다음과 같은 명령을 내렸다고 가정해 봅시다.
//		URLLDRLR
//		로봇은 (0,0) → (0,1) → (1,1) → (0,1) → (-1,1) → (-1,0) → (0,0) → (-1,0) → (0,0) 의 순서로 이동하여 원점으로 돌아오게 됩니다. 
//		하지만 우리는 이 명령어 중 연속되는 일부 명령어만을 내려도 원점으로 돌아오게 할 수 있습니다. 
//		그 경우는 다음과 같습니다.
//		RL	[1,2]
//		RL	[5,6]
//		LR	[6,7]
//		URLLDR	[0,5]
//		URLLDRLR	[0,7] ※명령어 전체도 포함
//		제한사항
//		•	'R', 'L', 'U', 'D' 이외에 명령어는 주어지지 않습니다.
//		•	명령어 s의 길이 : 1,000 이하의 자연수

		String s="URLLDRLR";
		 int len = s.length();
			int answer = 0;
	        int row =0;
	        int col =0;
	        int targetr=0,targetc=0;
	        for(int i=0;i<len;i++){
	            switch(s.substring(i,i+1)){
	                case "U":
	                    col++;
	                    break;
	                case "R":
	                    row++;
	                    break;
	                case "L":
	                    row--;
	                    break;
	                case "D":
	                    col--;
	                    break;
	            }
	        }
	        targetr=row;
	        targetc=col;
			for(int i=0;i<len;i++){
	            row=0;
	            col=0;
	            for(int j=i;j<len;j++){
	                switch(s.substring(j,j+1)){
	                    case "U":
	                        col++;
	                        break;
	                    case "R":
	                        row++;
	                        break;
	                    case "L":
	                        row--;
	                        break;
	                    case "D":
	                        col--;
	                        break;
	                }
	                if(targetr==row&&targetc==col){
	                    answer++;
	                    if(i==j){
	                        answer--;
	                    }
	                }
	            }
	        }
			System.out.println(answer);

}
}