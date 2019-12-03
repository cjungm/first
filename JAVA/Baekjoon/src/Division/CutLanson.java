package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutLanson {
	 
    public static void main(String[] args) throws IOException {
//    	문제
//    	집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 
//    	박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.
//    	이미 오영식은 자체적으로 K개의 랜선을 가지고 있다.
//    	그러나 K개의 랜선은 길이가 제각각이다. 
//    	박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다. 
//    	예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm 은 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)
//    	편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자. 
//    	그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 
//    	이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.
//
//    	입력
//    	첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다. 
//    	K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다. 
//    	그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 231-1보다 작거나 같은 자연수이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int k = Integer.parseInt(firstLine[0]); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(firstLine[1]); // 필요한 랜선의 개수
        
        int[] inputArray = new int[k];
        for(int i=0; i<k; i++) {
            inputArray[i] = Integer.parseInt(br.readLine()); // 각 랜선의 길이 배열
        }
        Arrays.sort(inputArray);
        
        long max = inputArray[k-1]; // middle을 구하는 과정 중에 min,max 모두 int 범위를 넘을 수 있음.
        long min = 1; // 문제에서 랜선 길이는 자연수라 0으로 초기값으로 정하면 에러가 발생한다. 
        long middle = 0; // 만약 max에 int의 최대값이 들어가면 처음 middle값은 int 최대의 반인데 그 이상의 수라면 middle은 int를 넘어선다.
        
        while(max >= min) { // 이분탐색 시작
            middle = (max+min)/2;
            
            long allCount = 0;
            
            for(int j=0; j<inputArray.length; j++) {
                
                allCount += inputArray[j]/middle;
            }
            
            if(allCount >= n) { // 처음에는 ==이 되면 break를 걸어서 시간을 단축해보려고 했는데, 그건 구체적인 수를 찾을 때는 가능하지만,
                                // 문제처럼 가능한 경우의 수 중에서 최대값을 구할 경우에는 다음과 같은 부등호 처리를 해야한다.
                                // == 이 아니라도 문제에 답이 되는 경우가 존재하기 때문이다.
                
                min = middle + 1;
                
            }else if(allCount < n) {
                
                max = middle - 1;
                
            }
            
        }
        System.out.println(max);
        
    }
 
}
