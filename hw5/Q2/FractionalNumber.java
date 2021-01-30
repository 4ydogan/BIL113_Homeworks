public class FractionalNumber{

	public String first, second, numberToString;
	public int firstInt, secondInt;
	public double doubleValue;

	public FractionalNumber(String x){
		first = x.substring(0,x.indexOf('/'));
		second = x.substring(x.indexOf('/')+1);
		firstInt = Integer.parseInt(first);
		secondInt = Integer.parseInt(second);
	}

	public FractionalNumber(int y, int z){
		firstInt = y;
		secondInt = z;
	}
	
	public double getDoubleValue(){
		doubleValue = (double)firstInt/(double)secondInt;
		return doubleValue;
	}
	
	public String toString(){
		numberToString = "" + firstInt + "/" + secondInt;

		return numberToString;
	}
	
	public static FractionalNumber simplify(FractionalNumber fractional){

		return sadeleştirme(fractional.firstInt, fractional.secondInt);
	}

	public static FractionalNumber add(FractionalNumber fractional_1, FractionalNumber fractional_2){
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

	public static FractionalNumber subtract(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int ekok =1, max, subtractFirst, subtractSecond, subtractPay, subtractPayda;
		
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

		subtractFirst = fractional_1.firstInt * (ekok/fractional_1.secondInt);
		subtractSecond = fractional_2.firstInt * (ekok/fractional_2.secondInt);
		subtractPay = subtractFirst - subtractSecond;
		subtractPayda = ekok;
		
		return sadeleştirme(subtractPay,subtractPayda);
	}

	public static FractionalNumber multiply(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int multiPay, multiPayda;
		multiPay = fractional_1.firstInt * fractional_2.firstInt;
		multiPayda = fractional_1.secondInt * fractional_2.secondInt;

		return sadeleştirme(multiPay, multiPayda);
	}

	public static FractionalNumber divide(FractionalNumber fractional_1, FractionalNumber fractional_2){
		int dividePay, dividePayda;
		dividePay = fractional_1.firstInt * fractional_2.secondInt;
		dividePayda = fractional_1.secondInt * fractional_2.firstInt;
		if (dividePayda == 0)
			return null;
		else
			return sadeleştirme(dividePay, dividePayda);
	}

	public static FractionalNumber sadeleştirme(int pay, int payda){
		int i = 1;
		int max, ebob=1, sadeleştirmePay, sadeleştirmePayda;

		if (pay > payda) {
			max = pay;			
		}
		else {
			max = payda;
		}
		while(i<=max){
			if (pay%i == 0 && payda%i == 0) {
				ebob = i;				
			}
			i++;
		}

		if (payda<0) {
			payda = Math.abs(payda);
			pay = -1*pay;
			
		}
		sadeleştirmePay = pay / ebob;
		sadeleştirmePayda = payda / ebob;

		if (pay == 0) {
			FractionalNumber fractionalSifir = new FractionalNumber("0/1");
			return fractionalSifir;
		}

		else if (payda == 0) {

			return null;
		}

		else{
			FractionalNumber fractionalSonuc = new FractionalNumber("" + sadeleştirmePay + "/" + sadeleştirmePayda);
			return fractionalSonuc;
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