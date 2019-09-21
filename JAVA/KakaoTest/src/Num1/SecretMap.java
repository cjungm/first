package Num1;
public class SecretMap {

	public static void main(String[] args) {
		int n = 5;
		int map1[] = {9, 20, 28, 18, 11};
		int map2[] = {30, 1, 21, 17, 28};
//		["#####","# # #", "### #", "# ##", "#####"]
		String[] result = new String[n];
		int [][] arr1 = new int[5][5];
		int [][] arr2 = new int[5][5];
		for(int i=0;i<map1.length;i++) {
			arr1[i]=binary(map1[i]);
			arr2[i]=binary(map2[i]);
		}
		for(int k=0;k<map1.length;k++) {
			System.out.print("\"");
			result[k]="";
			for(int j=0;j<map1.length;j++) {
				if(arr1[k][j]==1|arr2[k][j]==1) 
					result[k]+="#";
				else  result[k]+=" ";
			}
			System.out.print(result[k]);
			if(k<map1.length-1)
				System.out.print("\",");
			else
				System.out.print("\"");
		}

	}
	static int [] binary(int arr) {
		int[] bin= new int [5];
		int a = arr;
		for(int i=0;i<bin.length;i++) {
			bin[4-i]= a%2;
			a/=2;
		}
		return bin;
	}
}
