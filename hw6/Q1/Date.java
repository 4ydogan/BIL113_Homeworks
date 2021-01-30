public class Date{

	int day, month, year;

	public Date(){}

	public Date(int dayDate, int monthDate, int yearDate){

		day = dayDate;
		month = monthDate;
		year = yearDate;

	}

	public Date(String date){

		day = Integer.valueOf(date.substring(0,date.indexOf("/")));
		date = date.substring(date.indexOf("/")+1);
		month =Integer.valueOf(date.substring(0,date.indexOf("/")));
		date = date.substring(date.indexOf("/")+1);
		year = Integer.valueOf(date);

	}

	public int compareTo(Date date1){ // to compare two Date object (result = Date - date1)

		int result;

		if (date1.year > year) {			
			result = -1;
		}

		else if (date1.year < year) {			
			result = 1;
		}

		else {

			if (date1.month > month) {
				result = -1;				
			}

			else if (date1.month < month) {
				result = 1;				
			}

			else {

				if (date1.day > day) {			
					result = -1;
				}

				else if (date1.day < day) {			
					result = 1;
				}		

				else {

					result = 0;	
				}	
			}
		}

		return result;
	}

	public String toString() { 

		return String.format("%d/%d/%d", day, month, year); 
	}

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

}