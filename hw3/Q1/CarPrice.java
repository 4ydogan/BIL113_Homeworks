import java.util.Scanner;
import java.text.NumberFormat;

public class CarPrice{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the base price of the car:");
		int priceOfCar = keyboard.nextInt(); // priseOfCar is the base prise of car.

		System.out.print("Please enter the engine capacity:");
		int engineCapacity = keyboard.nextInt(); // engineCapacity is the engine capacity of car. 
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();

		double specialConsumptionTax;

		if (engineCapacity <= 1600) 
		{
			if (priceOfCar <=10625)
			{
				specialConsumptionTax = priceOfCar * 0.45;
			}
			else if (priceOfCar < 16250 && 10625 < priceOfCar)
			{
				specialConsumptionTax = priceOfCar * 0.5;
			}
			else
				specialConsumptionTax = priceOfCar * 0.8;
		}
		else if (1600 < engineCapacity && engineCapacity < 2000)
		{
			if (priceOfCar < 21250)
			{
				specialConsumptionTax = priceOfCar * 1.30;
			}
			else
				specialConsumptionTax = priceOfCar * 1.50;
		}
		else
			specialConsumptionTax = priceOfCar * 2.20;
		
		double valueAddedTax = (priceOfCar + specialConsumptionTax) * 0.18; // to calculate Value Added Tax
		double totalTax = specialConsumptionTax + valueAddedTax; // sum of Special Consumptiın Tax and Value Added Tax
		double finalPrice = priceOfCar + totalTax; // final price of car
		double rateOfSCT = specialConsumptionTax/finalPrice; // rate of Special Consumption Tax on final prise
		double rateOfVAT = valueAddedTax/finalPrice; // rate of Value Added Tax on final prise

		System.out.println("Base price:" + currency.format(priceOfCar));
		System.out.println("Special Consumption Tax:" + currency.format(specialConsumptionTax));
		System.out.println("Value Added Tax:" + currency.format(valueAddedTax));
		System.out.println("Total Tax:" + currency.format(totalTax));
		System.out.println("Final Price:" + currency.format(finalPrice));
		System.out.println("Approximately " + percent.format(rateOfSCT) + " of the final price is Special Consumption Tax");
		System.out.println("Approximately " + percent.format(rateOfVAT) + " of the final price is Value Added Tax");
	}
}