import java.util.Scanner;
import java.text.NumberFormat;

public class DeptPayment{
	public static void main(String[] args) {
		int month=0;
		double yearlyRate, monthlyPayment, debt, firstDebt, monthlyRate, monthInterest=0.0, totalInterest=0.0;

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the initial debt:");
		debt = keyboard.nextDouble();
		firstDebt = debt;
		System.out.print("Please enter the yearly interest rate (in percentages):");
		yearlyRate = keyboard.nextDouble();
		System.out.print("Please enter the monthly payment you want to make:");
		monthlyPayment = keyboard.nextDouble();
		monthlyRate = yearlyRate/(double)1200;

		while(debt > 0){
			monthInterest = debt*monthlyRate;
			debt = debt - (monthlyPayment - monthInterest);
			month++;
			totalInterest += monthInterest;
		}


		System.out.println("It takes " + month + " months to pay the debt and the total payment equals to " + currency.format(firstDebt+totalInterest));
	}
}