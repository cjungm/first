package Num1;
public class SecretMapSolution {

	public static void main(String[] args) {
		int n = 5;
		int map1[] = {9, 20, 28, 18, 11};
		int map2[] = {30, 1, 21, 17, 28};
//		["#####","# # #", "### #", "# ##", "#####"]
		String[] result = new String[n];
		
		for(int i=0;i<n;i++) {
			int targetBit = 1;
			String resultMap ="";
			int arr = map1[i]|map2[i];
			for(int j=0;j<n;j++) {
				resultMap = ((arr & targetBit)>0 ? "#":" " )+ resultMap;
				targetBit = targetBit << 1;
			}
			result[i] = resultMap;
			System.out.println(result[i]);
		}
	}

}
