package practice;
import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("N X N의 마방진을 생성합니다. N을 입력하세요(N은 3이상 홀수)");
		
		int number =scan.nextInt();
		
		if(number < 3 || number % 2 == 0) {
			System.out.println("숫자는 3이상의 홀수여야 합니다.");
			scan.close();
			return;
		}
		
		int[][] magicSqure = createMagicSquare(number);
		
		printMagicSquare(magicSqure);
		
		boolean result = isValidMagicSquare(magicSqure);
		
		System.out.printf("마방진 확인 결과 :%b \n", result);
		
		scan.close();
	}
	
	
	static int[][] createMagicSquare(int size) {
		
		int[][]magicSquare = new int[size][size];
		
		//시작을 0행 가운데 열에서 시작
		//숫자를 적는 위치를 이동하며 차례대로 숫자를 기입
		//숫자를 적는 이동 규칙
		
		//마방진의 행, 열 이동 규칙
		//예외조건이 아닐 경우 다음과 같이 이동
		//행은 1 감소 , 열은 1 증가
		//사이즈를 넘어서면 다시 0 또는 size -1로 이동
		//행 감소시  -1 -> size-1  으로 변경
		//열 증가시  size -> 0 으로 변경
		
		//예외조건: 단 작성하려는 숫자가 size의 배수일 때는
		//행 증가. 열 고정
		//(1,0) -> (2,0)
		
		
		int row = 0;
		int col = size / 2;
		
		for(int count = 1 ; count <= size * size ; count++) {
			
			magicSquare[row][col]  = count;
			
			//예외 조건
			if(count % size == 0) {
				
				row = row + 1;
				
			}else {
				
				row = row - 1;
				col = col + 1;
				
				if(row == -1)
					row = size -1;
				
				if(col == size)
					col = 0;				
			}

		}
		
		
		return magicSquare;
	}

	static void printMagicSquare(int[][] magicSquare) {
		
		System.out.printf("[마방진 출력 size = %d]\n", magicSquare.length);
		for(int i = 0 ; i < magicSquare.length ; i++) {
			
			for(int j = 0 ;j < magicSquare[i].length ; j++) {
				
				System.out.printf("%4d ", magicSquare[i][j]);
				
			}
			System.out.println();
				
		}
		System.out.println("[출력 완료]");
	}	
	
	static boolean isValidMagicSquare(int[][] square) {
		
		System.out.println("==마방진여부 확인==");
		int refSum = 0;

		//0행의 합
		System.out.printf("0행의 합 = [");
		
		for(int j = 0 ; j <square[0].length ; j ++) {
			System.out.printf("%3d ",square[0][j]);
			refSum += square[0][j];
		}
		System.out.printf("]  = %d\n",refSum);
		
		//행의 합
		for(int i = 1 ; i <square.length ; i ++) {
			
			int sum = 0;
			System.out.printf("%d행의 합 = [",i);			
			for(int j = 0 ; j < square[i].length ; j++) {
				System.out.printf("%3d ",square[i][j]);				
				sum += square[i][j];
			}

			System.out.printf("]  = %d\n", sum);
			if(sum != refSum)
				return false;			
		}
		
		
		//행의 합
		for(int j = 0 ; j <square[0].length ; j ++) {
			
			int sum = 0;
			System.out.printf("%d열의 합 = [",j);			
			for(int i = 0 ; i < square.length ; i++) {
				System.out.printf("%3d ",square[i][j]);					
				sum += square[i][j];
			}
			System.out.printf("]  = %d\n", sum);
			if(sum != refSum)
				return false;
			
		}
			
		int sum = 0;
		//대각의 합  (좌상 -> 우하)
		System.out.printf("대각의 합 [좌상-> 우하] = [");					
		for(int i= 0 ; i <square.length ; i ++) {
			System.out.printf("%3d ",square[i][i]);			
			sum += square[i][i];
		}
		System.out.printf("] = %d\n", sum);			
		
		if( sum != refSum)
			return false;
		
		sum = 0;
		//대각의 합  (좌하 -> 우상)
		System.out.printf("대각의 합 [좌하-> 우상] = [");							
		for(int i= 0 ; i <square.length ; i ++) {
			System.out.printf("%3d ",square[square.length -i -1][i]);				
			sum += square[square.length -i -1][i];
		}
		System.out.printf("] = %d\n", sum);	
		
		if( sum != refSum)
			return false;
		
		
		return true;
	}

}
