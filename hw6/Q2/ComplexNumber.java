public class ComplexNumber{
	
	String operator; // the operator is significant digit of imaginaryPart
	FractionalNumber realPart, imaginaryPart;

	public ComplexNumber(){}

	public ComplexNumber(FractionalNumber real, FractionalNumber imaginary){

		realPart = real;
		imaginaryPart = imaginary;

	}

	public ComplexNumber(String fullNumber){

		operator = fullNumber.substring(fullNumber.indexOf("/"), fullNumber.lastIndexOf("/"));

		if (operator.indexOf("+") != -1 && operator.indexOf("-") == -1) {

			operator = "+";
		}

		else{

			operator = "-";
		}

		realPart = new FractionalNumber(fullNumber.substring(0, fullNumber.indexOf(operator, fullNumber.indexOf("/"))));
		imaginaryPart = new FractionalNumber(fullNumber.substring(fullNumber.indexOf(operator, fullNumber.indexOf("/")),fullNumber.indexOf("i")));

	}

	public String toString(){

		if (imaginaryPart.getNumerator() >= 0) {

			return "" + realPart.toString() + "+" + imaginaryPart.toString() + "i";
			
		}

		else{

			return "" + realPart.toString() + imaginaryPart.toString() + "i";
		}
	
	}

	public static ComplexNumber simplify(ComplexNumber cmplx){

		ComplexNumber complexNum = new ComplexNumber();

		complexNum.realPart = FractionalNumber.simplify(cmplx.realPart);
		complexNum.imaginaryPart = FractionalNumber.simplify(cmplx.imaginaryPart);

		return complexNum;
	}

	public static ComplexNumber add(ComplexNumber cmplx1, ComplexNumber cmplx2){ // to add two ComplexNumber

		ComplexNumber complexNum = new ComplexNumber();

		complexNum.realPart = FractionalNumber.add(cmplx1.realPart, cmplx2.realPart);
		complexNum.imaginaryPart = FractionalNumber.add(cmplx1.imaginaryPart, cmplx2.imaginaryPart);

		return complexNum;
	}

	public static ComplexNumber subtract(ComplexNumber cmplx1, ComplexNumber cmplx2){ // to subtract two ComplexNumber

		ComplexNumber complexNum = new ComplexNumber();

		complexNum.realPart = FractionalNumber.subtract(cmplx1.realPart, cmplx2.realPart);
		complexNum.imaginaryPart = FractionalNumber.subtract(cmplx1.imaginaryPart, cmplx2.imaginaryPart);

		return complexNum;
	}

	public static ComplexNumber multiply(ComplexNumber cmplx1, ComplexNumber cmplx2){ // (a+bi)x(c+di)=(a*c-b*d)+(b*c+a*d)i 

		ComplexNumber complexNum = new ComplexNumber();

		complexNum.realPart = FractionalNumber.subtract(FractionalNumber.multiply(cmplx1.realPart, cmplx2.realPart), 
			FractionalNumber.multiply(cmplx1.imaginaryPart, cmplx2.imaginaryPart));
		complexNum.imaginaryPart = FractionalNumber.add(FractionalNumber.multiply(cmplx1.realPart, cmplx2.imaginaryPart),
			FractionalNumber.multiply(cmplx1.imaginaryPart, cmplx2.realPart));

		return complexNum;
	}

	public static ComplexNumber divide(ComplexNumber cmplx1, ComplexNumber cmplx2){

		FractionalNumber cmplx2_negative = new FractionalNumber(cmplx2.imaginaryPart.getNumerator()*-1, cmplx2.imaginaryPart.getDenominator());

		ComplexNumber complexNum = new ComplexNumber();
		ComplexNumber complexNumerator = new ComplexNumber();
		ComplexNumber complexDenominator = new ComplexNumber();
		ComplexNumber cmplx2_eslenik = new ComplexNumber();

		cmplx2_eslenik.realPart = cmplx2.realPart;
		cmplx2_eslenik.imaginaryPart = cmplx2_negative;

		complexNumerator = ComplexNumber.multiply(cmplx1, cmplx2_eslenik);
		complexDenominator = ComplexNumber.multiply(cmplx2, cmplx2_eslenik);

		complexNum.realPart = FractionalNumber.divide(complexNumerator.realPart, complexDenominator.realPart);
		complexNum.imaginaryPart = FractionalNumber.divide(complexNumerator.imaginaryPart, complexDenominator.realPart);

		if (complexNum.realPart == null || complexNum.imaginaryPart == null) { // if there is a null result
			return null;
		}

		else{

			return complexNum;
		}
	}

	public boolean equals(ComplexNumber complex_1){ // to compare two ComplexNumber

		boolean result = false;

		if (realPart.getNumerator() == complex_1.realPart.getNumerator() ) {

			if (realPart.getDenominator() == complex_1.realPart.getDenominator()) {

				if (imaginaryPart.getNumerator() == complex_1.imaginaryPart.getNumerator()) {

					if (imaginaryPart.getDenominator() == complex_1.imaginaryPart.getDenominator()) {

						result = true;
						
					}
					
				}
				
			}
			
		}

		return result;
	}
}