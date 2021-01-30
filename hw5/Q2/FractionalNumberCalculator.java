import java.util.Scanner;
import java.util.ArrayList;

public class FractionalNumberCalculator{
	public static void main(String[] args) {
		String input, fractionalString, operator = "";
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the formula you want to calculate:");
		input = scan.nextLine() + " ";
		int boslukSayisi = -1, fractionalAdedi=0;
		int length = input.length();
		char bosluk = ' ';

		while(0<length){
			if (input.charAt(length-1) == bosluk){
				boslukSayisi++;	
			}
			length--;
		}
		fractionalAdedi = boslukSayisi/2 + 1;

		ArrayList<FractionalNumber> arrayFractionalNumber = new ArrayList<FractionalNumber>();
		ArrayList<String> arrayOperator = new ArrayList<String>();

  		while(fractionalAdedi>0 && input.length() > 1) {
    		fractionalString = input.substring(0,input.indexOf(' '));
    		FractionalNumber fractionalNumber = new FractionalNumber(fractionalString);

    		if (input.length() > 4) {
    			input = input.substring(input.indexOf(' ')+1);
    		}
    		else {
    			input = "";
    		}

    		if(input.length() > 0){
    			operator = input.substring(0,input.indexOf(' '));
    			input = input.substring(input.indexOf(' ')+1);
    		}
    		else
    			operator = "";
    		
    	    		
   			arrayFractionalNumber.add(fractionalNumber);

   			if(operator.equals("") != true){
   				arrayOperator.add(operator);
   			}

   			fractionalAdedi--;
  		}
		
  		boolean sorun = false;
  		boolean mathProblemNull = false;

  		while(sorun == false){

			while(arrayOperator.indexOf("*") != -1){                   // to multiply
				int indexCarpi = arrayOperator.indexOf("*");
				arrayOperator.remove(indexCarpi);
				String fractionalMultiplyString;
				fractionalMultiplyString = (FractionalNumber.multiply(arrayFractionalNumber.remove(indexCarpi),arrayFractionalNumber.remove(indexCarpi))).toString();
				FractionalNumber fractionalMultiply = new FractionalNumber(fractionalMultiplyString);
				arrayFractionalNumber.add(indexCarpi, fractionalMultiply);
			}

			while(arrayOperator.indexOf("/") != -1){				   // to divide
				int indexBolu = arrayOperator.indexOf("/");	
				
				if ((arrayFractionalNumber.get(indexBolu+1)).firstInt == 0) { // if be wanted to divide by zero
					sorun = true;
					mathProblemNull = true;
					break;	
				}	

				arrayOperator.remove(indexBolu);
				String fractionalDivideString;
				fractionalDivideString = (FractionalNumber.divide(arrayFractionalNumber.remove(indexBolu),arrayFractionalNumber.remove(indexBolu))).toString();
				FractionalNumber fractionalDivide = new FractionalNumber(fractionalDivideString);
				arrayFractionalNumber.add(indexBolu, fractionalDivide);
			}

			if (sorun == true) {
				break;
			}

			while(arrayOperator.indexOf("+") != -1){			      // to add
				int indexArti = arrayOperator.indexOf("+");
				arrayOperator.remove(indexArti);
				String fractionalAddString;
				fractionalAddString = (FractionalNumber.add(arrayFractionalNumber.remove(indexArti),arrayFractionalNumber.remove(indexArti))).toString();
				FractionalNumber fractionalAdd = new FractionalNumber(fractionalAddString);
				arrayFractionalNumber.add(indexArti, fractionalAdd);
			}

			while(arrayOperator.indexOf("-") != -1){				   // to subtract
				int indexEksi = arrayOperator.indexOf("-");
				arrayOperator.remove(indexEksi);
				String fractionalSubtractString;
				fractionalSubtractString = (FractionalNumber.subtract(arrayFractionalNumber.remove(indexEksi),arrayFractionalNumber.remove(indexEksi))).toString();
				FractionalNumber fractionalSubtract = new FractionalNumber(fractionalSubtractString);
				arrayFractionalNumber.add(indexEksi, fractionalSubtract);
			}

			sorun = true;
		}

		if (mathProblemNull == false) {
			System.out.println("Result:" + arrayFractionalNumber.get(0));
		}
		else{
			System.out.println("Result:null");	
		}
		
				
	}

}