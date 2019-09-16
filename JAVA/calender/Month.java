package calender;

class Month {

	static final int[] dayOfMonthForNormalYear	= { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final int[] dayOfMonthForLeapYear	= { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static final int MAX_WEEK = 6;
	static final int DAYS_OF_WEEK = 7;
	
	final int year;
	final int month;

	int[][] dayArray;
	
	Month(int year, int month) {
		
		this.year = year;
		this.month = month;
		
		dayArray = new int[MAX_WEEK][DAYS_OF_WEEK];
		fillDayArray();
		
	}
	
	/**이 객체의 연도를 정수로 반환한다
	 * @return
	 */
	public int getYear() {
		
		return year;
	}

	/**이 객체의 월을 정수로 반환한다.
	 * @return
	 */
	public int getMonth() {
		
		return month;
	}

	/** Month 객체의 날짜 배열을 반환한다.
	 * @return
	 */
	public int[][] getDayArray() {
		return dayArray.clone();
	}

	/**
	 * 현재 월에서 다음 달을 생성하여 반환한다.
	 * @return
	 */
	Month getNextMonth() {
		
		int newYear, newMonth;
		
		if( month == 12) {
			
			newYear = year + 1;
			newMonth = 1;		
			
		} else {
			
			newYear = year;
			newMonth = month + 1;
		
		}

		return new Month(newYear, newMonth);
	}
	
	/**
	 * 현재 월에서 이전 달을 생성하여 반환한다. 
	 * @return
	 */
	Month getBeforeMonth() {
		
		int newYear, newMonth;
		
		if( month == 1) {
			
			newYear = year - 1;
			newMonth = 12;		
			
		} else {
			
			newYear = year;
			newMonth = month - 1;
		
		}

		return new Month(newYear, newMonth);
	}
	
	/**
	 * 날짜 배열을 생성한다
	 */
	void fillDayArray() {
		
		int firstDayOfWeek = getFirstDayOfWeek(year,month);
		int numOfSpace = firstDayOfWeek;
		int numOfDays = getNumOfDaysForMonth(year, month);
			
		int day = 1;
		
		for(int i = 0 ; i < dayArray.length && day <= numOfDays ; i++) {
			
			for(int j = 0; j < dayArray[i].length ; j++) {
				
				if(numOfSpace != 0) {
					numOfSpace --;
					continue;
				}				
				dayArray[i][j] = day;
				day++;	
				
				if( day > numOfDays)
					break;
			}
		}
	}

	/**
	 * 해당 연도의 해당 일이 무슨 요일로 시작하는지 알아내는 메서드
	 * @param targetYear
	 * @param targetMonth
	 * @return
	 */
	static int getFirstDayOfWeek(int targetYear, int targetMonth) {
		
		int sumOfYears = getSumOfYears(targetYear);
		
		int sumOfMonths = getSumOfMonths(targetYear, targetMonth);
		
		//구하고자 하는 월의 시작 요일 구하기
		//해당 월의 첫번째 요일
		int firstDayOfWeek = (sumOfYears + sumOfMonths + 1) % 7;
		return firstDayOfWeek;
	}
	/** 시작년도부터 구하고자 하는 연도전까지 모든 일수의 합 구하기
	 * @param targetYear
	 * @return
	 */
	static int getSumOfYears(int targetYear) {
		
		int sumOfYears = 0;
		for(int year = 1 ; year < targetYear ; year ++) {
			
			//윤년 확인 조건
			if( isLeapYear(year))
				sumOfYears += 366;
			else
				sumOfYears += 365;
		}
		return sumOfYears;
	}

	/** 구하고자 하는 월의 이전 월까지 합 구하기
	 * @param targetYear 구하고자 하는 연도
	 * @param targetMonth 구하고자 하는 월
	 * @return
	 */
	static int getSumOfMonths(int targetYear, int targetMonth) {

		int sumOfMonths = 0;
				
		//구하고자 하는 연도의 월수 구하기
		//각 월의 일수를 배열에 저장
		int[] dayOfMonths = null;
		
		//구하고자 하는 해가 윤년일 경우 윤년의 배열을 참조하게 하고, 
		//평년일 경우 평년의 배열을 참조하게 한다. 
		if( isLeapYear(targetYear) )
			dayOfMonths = dayOfMonthForLeapYear;
		else
			dayOfMonths = dayOfMonthForNormalYear;
			
		
		//구하고자 하는 월이 1월이면 0으로 계산되어야 한다.
		for(int month = 0; month < targetMonth - 1 ; month++) {			
			sumOfMonths += dayOfMonths[month];
		}
		
		return sumOfMonths;		
	}
	
	
	/** 해당 연도의 해당 월이 몇일까지 존재하는지 반환
	 * @param targetYear
	 * @param targetMonth
	 * @return
	 */
	static int getNumOfDaysForMonth(int targetYear, int targetMonth) {
		
		//구하고자 하는 연도의 월수 구하기
		//각 월의 일수를 배열에 저장
		int[] dayOfMonths = null;
		
		//구하고자 하는 해가 윤년일 경우 윤년의 배열을 참조하게 하고, 
		//평년일 경우 평년의 배열을 참조하게 한다. 
		if( isLeapYear(targetYear) )
			dayOfMonths = dayOfMonthForLeapYear;
		else
			dayOfMonths = dayOfMonthForNormalYear;
		
		return dayOfMonths[targetMonth - 1];
		
	}
	/**
	 * 윤년인지를 판단하는 메서드
	 * @param year 확인하고자 하는 연도
	 * @return     윤년일 경우 true, 평년일 경우 false 반환
	 */
	static boolean isLeapYear(int year) {
		
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	

}