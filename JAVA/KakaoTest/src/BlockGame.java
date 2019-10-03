import java.util.ArrayList;

public class BlockGame {

	 public static void main(String[] args) {
	        System.out.println(getRemoveCount(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
	        System.out.println();
//	        System.out.println(getRemoveCount(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
	    }
	 
	    public static int getRemoveCount(int m, int n, String[] arr) {
	        // 입력받은 String 배열을 2차원 ArrayList로 변환
        ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	        for(String str : arr) {
	            ArrayList<String> innerList = new ArrayList<String>();
	            for(char c : str.toCharArray()) {
	                innerList.add(String.valueOf(c));
	            }
	            board.add(innerList);
	        }
	        
	        int totalCnt = 0;
	        int hitCnt = 0;
	        print(board);
	        // processHit에서 삭제처리하고 삭제카운트를 올림.
	        while((hitCnt = processHit(board)) > 0) {
	            totalCnt += hitCnt;
	            print(board);
	            // 빈칸을 탐색하여 위에 있는 요소를 아래로 당김
	            arrange(board);
	            print(board);
	        }
	        return totalCnt;
	    }
	    
	    private static int processHit(ArrayList<ArrayList<String>> board) {
	        int hitCnt = 0;
	        char[][] delMarkBoard = new char[board.size()][board.get(0).size()];
	        
	        // 삭제되는 블럭 위치는 별도로 delMarkBoard에 체크
	        for(int i = 0 ; i < board.size() ; i++) {
	            for(int j = 0 ; j < board.get(i).size() ; j++) {
	                String cur = board.get(i).get(j);
	                // 빈블럭이 아닌 경우 삭제되는지 확인
	                if(!cur.isEmpty()) {
	                    // 현재 i, j 위치가 삭제 대상인지 확인
	                    if(    (cur.equals(getValue(i-1, j-1, board)) && cur.equals(getValue(i-1, j, board)) && cur.equals(getValue(i, j-1, board)))
	                        || (cur.equals(getValue(i-1, j, board)) && cur.equals(getValue(i-1, j+1, board)) && cur.equals(getValue(i, j+1, board)))
	                        || (cur.equals(getValue(i, j-1, board)) && cur.equals(getValue(i+1, j-1, board)) && cur.equals(getValue(i+1, j, board)))
	                        || (cur.equals(getValue(i, j+1, board)) && cur.equals(getValue(i+1, j+1, board)) && cur.equals(getValue(i+1, j, board)))) {
	                        delMarkBoard[i][j] = 'D';
	                        hitCnt++;
	                    }
	                }
	            }
	        }
	        
	        // delMarkBoard에 체크된 위치 값 일괄 삭제
	        for(int i = 0 ; i < delMarkBoard.length ; i++) {
	            for(int j = 0 ; j < delMarkBoard[i].length ; j++) {
	                if(delMarkBoard[i][j]=='D') {
	                    board.get(i).set(j, "");
	                }
	            }
	        }
	        return hitCnt;
	    }
	 
	    private static void arrange(ArrayList<ArrayList<String>> board) {
	        // 역z 방향으로 탐색 하여 공백을 만난 경우 위쪽으로 계속 이동하면 공백이 아닌 문자를 발견하면 내려버리기
	        for(int i = board.size()-1 ; i >= 0 ; i--) {
	            for(int j = board.get(i).size()-1 ; j >= 0 ; j--) {
	                if(board.get(i).get(j).isEmpty()) {
	                    // 위쪽 방향으로 탐색하며 공백아닌 문자를 발견한 경우 swap
	                    for(int k=i; k >= 0; k--) {
	                        if(!board.get(k).get(j).isEmpty()) {
	                            board.get(i).set(j, board.get(k).get(j));
	                            board.get(k).set(j, "");
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	    }
	    
	    private static String getValue(int i, int j, ArrayList<ArrayList<String>> board) {
	        String retVal = "";
	        try {
	            retVal = board.get(i).get(j);
	        } catch (IndexOutOfBoundsException e) {
	            retVal = "";
	        }
	        return retVal;
	    }
	    
	    private static void print(ArrayList<ArrayList<String>> board) {
	        for(int i = 0 ; i < board.size() ; i++) {
	            for(int j = 0 ; j < board.get(i).size() ; j++) {
	                System.out.print((board.get(i).get(j).isEmpty() ? " " : board.get(i).get(j)) + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

}
