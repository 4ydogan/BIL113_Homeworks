public class FractionalNumber{

	String first, second, numberToString;
	int firstInt, secondInt;
	double doubleValue;

	public FractionalNumber(String x){
		first = x.substring(0,x.indexOf('/')); // to find numerator as string
		second = x.substring(x.indexOf('/')+1); // to find denominator as string
		firstInt = Integer.parseInt(first); // to find numerator as integer
		secondInt = Integer.parseInt(second);// to find denominator as integer
	}

	public FractionalNumber(int y, int z){
		firstInt = y; // to find numerator as integer
		secondInt = z;// to find denominator as integer
	}
	
	public double getDoubleValue(){
		doubleValue = (double)firstInt/(double)secondInt;
		return doubleValue;
	}
	
	public String toString(){
		numberToString = "" + firstInt + "/" + secondInt;

		return numberToString;
	}
	
	public static String simplify(FractionalNumber fractional){

		return sadeleştirme(fractional.firstInt, fractional.secondInt);
	}

	public static String add(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int ekok =1, max, addFirst, addSecond, addPay, addPayda	;
		
		if (fractional_1.secondInt > fractional_2.secondInt) {
			max = fractional_1.secondInt;			
		}
		else {
			max = fractional_2.secondInt;
		}
		boolean kontrol = true;
		while(kontrol == true){
			if(max%fractional_1.secondInt == 0 && max%fractional_2.secondInt == 0){
				ekok = max;
				kontrol = false;
			}
			max++;
		}

		addFirst = fractional_1.firstInt * (ekok/fractional_1.secondInt);
		addSecond = fractional_2.firstInt * (ekok/fractional_2.secondInt);
		addPay = addFirst + addSecond;
		addPayda = ekok;

		return sadeleştirme(addPay, addPayda);
	}

	public static String subtract(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int ekok =1, max, subtractFirst, subtractSecond, subtractPay, subtractPayda;
		
		if (fractional_1.secondInt > fractional_2.secondInt) {
			max = fractional_1.secondInt;			
		}
		else {
			max = fractional_2.secondInt;
		}

		boolean kontrol = true;
		while(kontrol == true){ // to find ekok
			if(max%fractional_1.secondInt == 0 && max%fractional_2.secondInt == 0){
				ekok = max;
				kontrol = false;
			}
			max++;
		}

		subtractFirst = fractional_1.firstInt * (ekok/fractional_1.secondInt);
		subtractSecond = fractional_2.firstInt * (ekok/fractional_2.secondInt);
		subtractPay = subtractFirst - subtractSecond;
		subtractPayda = ekok;
		
		return sadeleştirme(subtractPay,subtractPayda);
	}

	public static String multiply(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int multiPay, multiPayda;
		multiPay = fractional_1.firstInt * fractional_2.firstInt;
		multiPayda = fractional_1.secondInt * fractional_2.secondInt;

		return sadeleştirme(multiPay, multiPayda);
	}

	public static String divide(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int dividePay, dividePayda;
		dividePay = fractional_1.firstInt * fractional_2.secondInt;
		dividePayda = fractional_1.secondInt * fractional_2.firstInt;

		return sadeleştirme(dividePay, dividePayda);
	}

	public static String sadeleştirme(int pay, int payda){
		int i = 1;
		int max, ebob=1, sadeleştirmePay, sadeleştirmePayda;

		if (pay > payda) {
			max = pay;			
		}
		else {
			max = payda;
		}
		while(i<=max){            // to find ebob
			if (pay%i == 0 && payda%i == 0) {
				ebob = i;				
			}
			i++;
		}

		if (payda<0) {            // to find significant digit
			payda = Math.abs(payda);
			pay = -1*pay;
			
		}
		sadeleştirmePay = pay / ebob;
		sadeleştirmePayda = payda / ebob;

		if (pay == 0) {           // if numerator is zero 

			return "0/1";
		}

		else if (payda == 0) {    // if denominator is zero

			return null;
		}

		else{

			return "" + sadeleştirmePay + "/" + sadeleştirmePayda;
		}
	}

	public boolean equals(FractionalNumber fractional){
		if (firstInt == fractional.firstInt && secondInt == fractional.secondInt){
			return true;
		}
		else{
			return false;
		}
	}
}