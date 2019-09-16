package calender;

import java.util.Scanner;

public class PrintCalendar {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("출력하고 싶은 연도를 입력하세요");

		int targetYear = scan.nextInt();

		System.out.println("출력하고 싶은 월을 입력하세요");

		int targetMonth = scan.nextInt();

		System.out.println("몇 개의 월을 출력하고 싶은가요?");

		int numOfMonth = scan.nextInt();
		
		System.out.println("가로에 몇 개의 월을 출력하실 것인가요[컬럼의 개수]?");
		
		int numOfCol = scan.nextInt();

		printCalendar(targetYear, targetMonth, numOfMonth, numOfCol);
	

		scan.close();
	}

	/** 지정한 년도와 월의 달력을 출력
	 * @param year
	 * @param month
	 * @param nMonth : 몇 개의 달을 출력할지 결정
	 * @param colNum : 가로에 몇 개의 달력을 출력할 것인지 결정
	 */		
	static void printCalendar(int year, int month, int nMonth, int colNum){
		
		// row 계산. [1줄은 무조건 생김]
		int rowNum = ( nMonth - 1 ) / colNum + 1; 
						
		Month[][] mMonthArray = createMonthArray(year, month, nMonth, colNum, rowNum);
		
		displayMonthArray(mMonthArray);	
	}

	static Month[][] createMonthArray(int year, int month, int nMonth, int colNum, int rowNum) {
		
		Month[][] mMonthArray = new Month[rowNum][colNum];
		
		Month aMonth = new Month(year,month);
		
		int monthCount = 0;
		
		boolean isEndOfMonth = false;
		
		for(int i = 0 ; i < mMonthArray.length && isEndOfMonth == false ; i++){
			
			for( int j = 0 ;  j< mMonthArray[i].length ; j++){
				
				if(monthCount == nMonth){
					
					isEndOfMonth = true;					
				}
					
				if( isEndOfMonth ){
					
					mMonthArray[i][j] = null;
							
				}else{

					mMonthArray[i][j] = aMonth;
					aMonth = aMonth.getNextMonth();				
										
				}
				monthCount++;
			}
			
		}
		return mMonthArray;
	}
	
	
	static void displayMonthArray(Month[][] mMonthArray) {
		
		//이 문자열은 class 공통 변수로 갖는 것이 좋을 듯.
		String seperator = "   "; 
		
		for( int row = 0; row < mMonthArray.length ; row++){

			int colMax = mMonthArray[row].length;

			String titleLine = "";

			//달력 위의 몇년 몇 월인지를 표시하는 반복 
			for( int col = 0 ; col < colMax  ; col++){

				//공백으로 셋팅된 달력은 더하지 않고 반복 종료, 2016, 1, 12, 5 의 경우 마지막 row는 2개의 월만 출력됨. 
				if( mMonthArray[row][col] == null){
					break;
				}

				titleLine += String.format("    [%4d] / [%2d]    "
						, mMonthArray[row][col].getYear(), mMonthArray[row][col].getMonth());

				titleLine += seperator;
			}

			System.out.println(titleLine);


			String dayOfWeekStr = "";
			//달력 위의 요일을 출력하는 반복			
			for( int col = 0 ; col < colMax  ; col++){

				//공백으로 셋팅된 달력은 더하지 않고 반복 종료
				if( mMonthArray[row][col] == null){
					break;
				}				

				dayOfWeekStr +=" SU MO TU WE TH FR SA";

				dayOfWeekStr += seperator;

			}

			System.out.println(dayOfWeekStr);


			//각 날짜를 출력하는 반복.
			//한 달에 존재하는 최대 week 수만큼 반복하며, 가로로 출력해야 할, 월의 각 week의 열을 더한다
			//제일 바깥쪽 반복이 각 week 단위로 넘어가는 반복 (가로로 연결되는  한 줄을 만들기 위해)
			for( int week = 0 ; week < Month.MAX_WEEK ; week++){

				String weekStr = "";

				//해당하는 각 월 별로 반복
				//즉 1월 2월 3월을 가로로 출력하면
				//반복을 1월, 2월, 3월 순으로 진행
				for( int col = 0 ; col < mMonthArray[row].length ; col++ ){

					//공백으로 셋팅된 달력은 더하지 않고 반복 종료
					if( mMonthArray[row][col] == null){
						break;
					}
					
					int[][] monthArray = mMonthArray[row][col].getDayArray();
					
					for( int day = 0 ; day < Month.DAYS_OF_WEEK ; day ++){
						
						if( monthArray[week][day] > 0 ){
							
							weekStr += String.format(" %2d", monthArray[week][day]);
							
						}
						
						else{
							
							weekStr += String.format("   ", monthArray[week][day]);
							
						}
						
					}
					weekStr += seperator;
					
				}
				
				System.out.println(weekStr);
				
			}

		}

	}		
}