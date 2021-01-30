import java.util.Scanner;

public class Unifying{
	public static void main(String[] args){
		double uzumaki1, uzumaki2, uzumaki3, uzumaki4; // Values of Uzumaki
		double uchiha1, uchiha2, uchiha3, uchiha4; // Values of Uchiha
		Scanner keyboard = new Scanner(System.in); // to get input from the user

		System.out.println("Please enter 4 observation pairs:");
		uzumaki1 = keyboard.nextDouble();
		uchiha1 = keyboard.nextDouble();

		uzumaki2 = keyboard.nextDouble();
		uchiha2 = keyboard.nextDouble();

		uzumaki3 = keyboard.nextDouble();
		uchiha3 = keyboard.nextDouble();

		uzumaki4 = keyboard.nextDouble();
		uchiha4 = keyboard.nextDouble();
		
		System.out.print("Please enter the measurement you want to convert:");
		double convert = keyboard.nextDouble(); // measurement that be wanted 

		double firstStep = 4*(uzumaki1*uchiha1 + uzumaki2*uchiha2 + uzumaki3*uchiha3 + uzumaki4*uchiha4);
		double secondStep = (uzumaki1 + uzumaki2 + uzumaki3 + uzumaki4)*(uchiha1 + uchiha2 +uchiha3 + uchiha4);
		double thirdStep = 4*(uzumaki1*uzumaki1 + uzumaki2*uzumaki2 + uzumaki3*uzumaki3 + uzumaki4*uzumaki4);
		double fourthStep = Math.pow((uzumaki1 + uzumaki2 + uzumaki3 + uzumaki4),2);
		double fifthStep = (uchiha1 + uchiha2 + uchiha3 + uchiha4);
		double sixthStep = (uzumaki1 + uzumaki2 + uzumaki3 + uzumaki4);
		
		// Finding the values ​​of a and b in the equation y = ax + b using linear regression
		double a = (firstStep - secondStep)/(thirdStep - fourthStep);
		double b = (fifthStep - a*sixthStep)/4; 

		double result = a*convert + b; // replacing the convert number for x in the equation y = ax + b

		System.out.println("Converted measurement is " + result);
	}
}