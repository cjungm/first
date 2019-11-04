package Test2019_2;

public class Num7 {

	public static void main(String[] args) {
//		String [] mine = {".1...2", "111.3."};
		String [] mine = {".3....", "1..20."};
		String[][] num = new String[2][mine[0].length()];
		String bomb = "M";
		String none = "S";
		String unknown = "?";
		for(int i=0;i<2;i++) {
			for(int j=0;j<mine[0].length();j++) {
				num[i][j]=mine[i].substring(j,j+1);
			}
		}

		for(int i=0;i<2;i++) {
			for(int j=0;j<mine[0].length();j++) {
				if(!mine[i].substring(j,j+1).equals(".")
						&&!mine[i].substring(j,j+1).equals("?")
						&&!mine[i].substring(j,j+1).equals("S")
						&&!mine[i].substring(j,j+1).equals("M")) {
					num=chekckMine(num,i,j);
				}else if(mine[i].substring(j,j+1).equals(".")){
					num = drawS(num,i,j);
				}
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<mine[0].length();j++) {
				if(num[i][j].equals("?")){
					num = drawS(num,i,j);
				}
			}
		}
		for(int i=0;i<mine.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				if(!mine[i].substring(j,j+1).equals(".")
						&&!mine[i].substring(j,j+1).equals("?")
						&&!mine[i].substring(j,j+1).equals("S")
						&&!mine[i].substring(j,j+1).equals("M")) {
					num[i][j]=mine[i].substring(j,j+1);
					System.out.print(num[i][j]);
				}else {
					System.out.print(num[i][j]);
				}
			}
			System.out.println();
		}
		
	
	}

	static String[][] drawS(String[][] num, int i, int j) {
		boolean has = false;
		if(!num[i][j].equals("M")) {
			for(int a=0;a<8;a++) {
				switch(a) {
				case 0:
					if(i-1>=0&&j>=0&&j<num[i-1].length) {
					
						if(!(num[i-1][j].contains(".")||num[i-1][j].contains("?")
								||num[i-1][j].contains("M")||num[i-1][j].contains("S"))
								&&Integer.parseInt(num[i-1][j])<=0) {
							has=true;
							break;
							}
					
					}
					break;
				case 1:
					if(i-1>=0&&j-1>=0) {
						
						if(!(num[i-1][j-1].contains(".")||num[i-1][j-1].contains("?")
								||num[i-1][j-1].contains("M")||num[i-1][j-1].contains("S"))
								&&Integer.parseInt(num[i-1][j-1])<=0) {
							has=true;
							break;
							}
					
					}
					break;
				case 2:
					if(i-1>=0&&j+1<num[i-1].length) {
						
						if(!(num[i-1][j+1].contains(".")||num[i-1][j+1].contains("?")
								||num[i-1][j+1].contains("M")||num[i-1][j+1].contains("S"))
								&&Integer.parseInt(num[i-1][j+1])<=0) {
							has=true;
							break;
							}
				
					}
					break;
				case 3:
					if(i>=0&&i<num.length&&j-1>=0) {
						if(!(num[i][j-1].contains(".")||num[i][j-1].contains("?")
								||num[i][j-1].contains("M")||num[i][j-1].contains("S"))
								&&Integer.parseInt(num[i][j-1])<=0) {
							has=true;
							break;
							}
					
						
					}
					break;
				case 4:
					if(i>=0&&i<num.length&&j+1<num[i].length) {
					
						if(!(num[i][j+1].contains(".")||num[i][j+1].contains("?")
								||num[i][j+1].contains("M")||num[i][j+1].contains("S"))
								&&Integer.parseInt(num[i][j+1])<=0) {
							has=true;
							break;
							}
				
						
					}
					break;
				case 5:
					if(i+1<num.length&&j>=0&&j<num[i+1].length) {
						
						if(!(num[i+1][j].contains(".")||num[i+1][j].contains("?")
								||num[i+1][j].contains("M")||num[i+1][j].contains("S"))
								&&Integer.parseInt(num[i+1][j])<=0) {
							has=true;
							break;
							}
			
						
					}
					break;
				case 6:
					if(i+1<num.length&&j-1>=0) {
						
						if(!(num[i+1][j-1].contains(".")||num[i+1][j-1].contains("?")
								||num[i+1][j-1].contains("M")||num[i+1][j-1].contains("S"))
								&&Integer.parseInt(num[i+1][j-1])<=0) {
							has=true;
							break;
							}
	
						
					}
					break;
				case 7:
					if(i+1<num.length&&j+1<num[i+1].length) {
						
						if(!(num[i+1][j+1].contains(".")||num[i+1][j+1].contains("?")
								||num[i+1][j+1].contains("M")||num[i+1][j+1].contains("S"))
								&&Integer.parseInt(num[i+1][j+1])<=0) {
							has=true;
							break;
							}
	
						
					}
					break;
				}
				if(has) {
					num[i][j]="S";
				}
				
			}
		}
		return num;
	}

	static String[][] drawMine(int i, int j,String[][] num) {
		for(int a=0;a<8;a++) {
			switch(a) {
			case 0:
				if(i-1==0&&j>=0&&j<num[i-1].length) {

					if(num[i-1][j].equals(".")||num[i-1][j].equals("?")) {
						num[i-1][j]="M";
						num=minusCnt(num,i-1,j);
						}

				}
				break;
			case 1:
				if(i-1==0&&j-1>=0) {
					
					if(num[i-1][j-1].equals(".")||num[i-1][j-1].equals("?")) {
						num[i-1][j-1]="M";
						num=minusCnt(num,i-1,j-1);
						}

				}
				break;
			case 2:
				if(i-1==0&&j+1<num[i-1].length) {
				
					if(num[i-1][j+1].equals(".")||num[i-1][j+1].equals("?")) {
						num[i-1][j+1]="M";
						num=minusCnt(num,i-1,j+1);
						}

					
				}
				break;
			case 3:
				if(i>=0&&i<num.length&&j-1>=0) {
					
					if(num[i][j-1].equals(".")||num[i][j-1].equals("?")) {
						num[i][j-1]="M";
						num=minusCnt(num,i,j-1);
						}

					
				}
				break;
			case 4:
				if(i>=0&&i<num.length&&j+1<num[i].length) {
					
					if(num[i][j+1].equals(".")||num[i][j+1].equals("?")) {
						num[i][j+1]="M";
						num=minusCnt(num,i,j+1);
						}

					
				}
				break;
			case 5:
				if(i+1<num.length&&j>=0&&j<num[i+1].length) {
					
					if(num[i+1][j].equals(".")||num[i+1][j].equals("?")) {
						num[i+1][j]="M";
						num=minusCnt(num,i+1,j);
						}
	
					
				}
				break;
			case 6:
				if(i+1<num.length&&j-1>=0) {
					
					if(num[i+1][j-1].equals(".")||num[i+1][j-1].equals("?")) {
						num[i+1][j-1]="M";
						num=minusCnt(num,i+1,j-1);
						}
				
					
				}
				break;
			case 7:
				if(i+1<num.length&&j+1<num[i+1].length) {
					
					if(num[i+1][j+1].equals(".")||num[i+1][j+1].equals("?")) {
						num[i+1][j+1]="M";
						num=minusCnt(num,i+1,j+1);
						}
				
					
				}
				break;
			}
			
		}
		return num;
	}

	static String[][] chekckMine(String[][] num, int i, int j) {
		int cnt=0;
		int nu=Integer.parseInt(num[i][j]);
		if(nu>0) {
			for(int a=0;a<8;a++) {
				switch(a) {
				case 0:
					if(i-1>=0&&j>=0&&j<num[i-1].length) {
						if(num[i-1][j].equals(".")||num[i-1][j].equals("?")) {
							cnt++;
						}
					}
					break;
				case 1:
					if(i-1>=0&&j-1>=0) {

						if(num[i-1][j-1].equals(".")||num[i-1][j-1].equals("?")) {
							cnt++;
						}

					}
					break;
				case 2:
					if(i-1>=0&&j+1<num[i-1].length) {

						if(num[i-1][j+1].equals(".")||num[i-1][j+1].equals("?")) {
							cnt++;
						}

					}
					break;
				case 3:
					if(i>=0&&i<num.length&&j-1>=0) {

						if(num[i][j-1].equals(".")||num[i][j-1].equals("?")) {
							cnt++;
						}

					}
					break;
				case 4:
					if(i>=0&&i<num.length&&j+1<num[i].length) {

						if(num[i][j+1].equals(".")||num[i][j+1].equals("?")) {
							cnt++;
						}

					}
					break;
				case 5:
					if(i+1<num.length&&j>=0&&j<num[i+1].length) {

						if(num[i+1][j].equals(".")||num[i+1][j].equals("?")) {
							cnt++;
						}

					}
					break;
				case 6:
					if(i+1<num.length&&j-1>=0) {

						if(num[i+1][j-1].equals(".")||num[i+1][j-1].equals("?")) {
							cnt++;
						}

					}
					break;
				case 7:
					if(i+1<num.length&&j+1<num[i+1].length) {

						if(num[i+1][j+1].equals(".")||num[i+1][j+1].equals("?")) {
							cnt++;
						}

					}
					break;
				}
			}
			if(nu==cnt) {
				num = drawMine(i,j,num);
			}else {
				num = drawQ(i,j,num);
			}
		}
		return num;
	}

	static String[][] drawQ(int i, int j, String[][] num) {
		for(int a=0;a<8;a++) {
			switch(a) {
			case 0:
				if(i-1==0&&j>=0&&j<num[i-1].length) {
				
					if(num[i-1][j].equals(".")) {
						num[i-1][j]="?";
						}

				}
				break;
			case 1:
				if(i-1==0&&j-1>=0) {
					
					if(num[i-1][j-1].equals(".")) {
						num[i-1][j-1]="?";
						}
				
				}
				break;
			case 2:
				if(i-1==0&&j+1<num[i-1].length) {
					
					if(num[i-1][j+1].equals(".")) {
						num[i-1][j+1]="?";
						}
				
					
				}
				break;
			case 3:
				if(i>=0&&i<num.length&&j-1>=0) {
					
					if(num[i][j-1].equals(".")) {
						num[i][j-1]="?";
						}
				
					
				}
				break;
			case 4:
				if(i>=0&&i<num.length&&j+1<num[i].length) {
					
					if(num[i][j+1].equals(".")) {
						num[i][j+1]="?";
						}
		
					
				}
				break;
			case 5:
				if(i+1<num.length&&j>=0&&j<num[i+1].length) {
					
					if(num[i+1][j].equals(".")) {
						num[i+1][j]="?";
						}
			
					
				}
				break;
			case 6:
				if(i+1<num.length&&j-1>=0) {
				
					if(num[i+1][j-1].equals(".")) {
						num[i+1][j-1]="?";
						}
		
					
				}
				break;
			case 7:
				if(i+1<num.length&&j+1<num[i+1].length) {
				
					if(num[i+1][j+1].equals(".")) {
						num[i+1][j+1]="?";
						}
				
					
				}
				break;
			}
			
		}
		return num;
	}

	static String[][] minusCnt(String[][] num, int i, int j) {

			for(int a=0;a<8;a++) {
				switch(a) {
				case 0:
					if(i-1==0&&j>=0&&j<num[i-1].length&&!num[i-1][j].matches("[.MS?]")) {

						int nu=Integer.parseInt(num[i-1][j]);
						String str=Integer.toString(--nu);
						num[i-1][j]=str;

					}
					break;
				case 1:
					if(i-1==0&&j-1>=0&&!num[i-1][j-1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i-1][j-1]);
							String str=Integer.toString(--nu);
							num[i-1][j-1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 2:
					if(i-1==0&&j+1<num[i-1].length&&!num[i-1][j+1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i-1][j+1]);
							String str=Integer.toString(--nu);
							num[i-1][j+1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 3:
					if(i>=0&&i<num.length&&j-1>=0&&!num[i][j-1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i][j-1]);
							String str=Integer.toString(--nu);
							num[i][j-1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 4:
					if(i>=0&&i<num.length&&j+1<num[i].length&&!num[i][j+1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i][j+1]);
							String str=Integer.toString(--nu);
							num[i][j+1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 5:
					if(i+1<num.length&&j>=0&&j<num[i+1].length&&!num[i+1][j].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i+1][j]);
							String str=Integer.toString(--nu);
							num[i+1][j]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 6:
					if(i+1<num.length&&j-1>=0&&!num[i+1][j-1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i+1][j-1]);
							String str=Integer.toString(--nu);
							num[i+1][j-1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				case 7:
					if(i+1<num.length&&j+1<num[i+1].length&&!num[i+1][j+1].matches("[.MS?]")) {
						try {
							int nu=Integer.parseInt(num[i+1][j+1]);
							String str=Integer.toString(--nu);
							num[i+1][j+1]=str;
						} catch (NumberFormatException e) {	
							e.printStackTrace();
						}
					}
					break;
				}
			}
		
		return num;
	}
}
