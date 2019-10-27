import java.util.ArrayList;

public class Origami {

	public static void main(String[] args) {
		int n=3;
		 int len = (int)Math.pow(2,n)-1;
	      int [] answer = new int [len];
	      answer=check(n,len);
	      
	}
	static int [] check(int n , int len){
        int [] a= {0};
        if(n>1){
            int[] a3 = new int[len];
            ArrayList <Integer> b = new ArrayList<>();
            b.add(0);
            for(int i=2;i<=n;i++){
            	int ll = (int)Math.pow(2, i-1)-1;
            	int l = (int)Math.pow(2, i)-1;
            	for(int j=ll;j<l;j++) {
            		if(j==l-1) {
            			b.add(1);
            		}else {
            			b.add(b.get(j-ll));
            		}
            	}
            }
            for(int i=0;i<len;i++) {
            	a3[i]=b.get(i);
            	System.out.print(a3[i]);
            }
            return a3;
        }else {
        	return a;
        }

	}
}
