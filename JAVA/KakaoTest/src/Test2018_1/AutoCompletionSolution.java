package Test2018_1;

import java.util.ArrayList;
import java.util.HashMap;

public class AutoCompletionSolution {

	public static void main(String[] args) {
		String [] words = {"go","gone","guild"};
//		String [] words = {"abc","def","ghi","jklm"};
//		String [] words = {"word","war","warrior","world"};
		System.out.println(count(words));
	}
	public static int count(String[] arr) {
	    // Trie 데이터 입력
	    Trie trie=  new Trie();
	    for(String str : arr) {
	        trie.insert(str);
	    }
	    
	    // 입력 데이터 별 카운트
	    int count = 0;
	    for(String str : arr) {
	        for(int i = 1 ; i <= str.length() ; i++) {
	            count++;
	            String word = str.substring(0, i);
	            
	            // 한글자씩 늘려서 나오는 노드가 1개인 경우 더이상 진행하지 않음
	            if(trie.findLeafs(word).size() == 1) {
	                break;
	            }
	        }
	    }
	    
	    return count;
	}

}
class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /**
     * Trie에 문자열 입력
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.getChild(c) != null) {
                current = current.getChild(c);
            }
            else {
                current = current.putChild(c);
            }
        }
        current.setLeaf(true);
    }
    
    /**
     * 문자열 word까지 입력된 경우 리턴되는 모든 leaf 리턴
     * @param word
     * @return
     */
    public ArrayList<TrieNode> findLeafs(String word) {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();
        
        TrieNode current = root;
        
        //입력된 word에 해당하는 마지막 TrieNode를 탐색
        for(char c : word.toCharArray()) {
            if(current.getChild(c)!=null) {
                current = current.getChild(c);
            }
            else {
                retList.clear();
                return retList;
            }
        }
        
        // 마지막 TrieNode가 leaf이면 추가
        if(current.isLeaf()) {
            retList.add(current);
        }
        
        // 현재 TrieNode에 연결된 자식노드들의 모든 leaf를 추가
        retList.addAll(current.getAllLeaf());
        return retList;
    }
}
 
class TrieNode {
    private char data;
    private boolean isLeaf;
    private HashMap<Character, TrieNode> children;
    
    public TrieNode(char c) {
        this.data = c;
        children = new HashMap<Character, TrieNode>();
        isLeaf = false;
    }
    
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
    
    public boolean isLeaf() {
        return isLeaf;
    }
    
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    
    /**
     * 입력 c에 해당하는 TrieNode 생성 후 Child로 추가
     * @param c
     * @return
     */
    public TrieNode putChild(char c) {
        TrieNode temp = new TrieNode(c);
        getChildren().put(c, temp);
        return temp;
    }
    /**
     * 현재 노드의 자식노드 중 입력값 c에 해당하는 값 리턴
     * @param c
     * @return
     */
    public TrieNode getChild(char c) {
        return getChildren().get(c);
    }
    
    /**
     * 현재 노드와 연결된 모든 자식노드 중 leaf에 해당하는 노드 전부 리턴
     * @return
     */
    public ArrayList<TrieNode> getAllLeaf() {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();
        for(TrieNode child : getChildren().values()) {
            if(child.isLeaf()) {
                retList.add(child);
            }
            retList.addAll(child.getAllLeaf());
        }
        return retList;
    }
    
}

