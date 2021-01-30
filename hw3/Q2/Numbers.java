import java.util.Scanner;

public class Numbers
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a 4-digit number:");
		int number = keyboard.nextInt(); 					// takes a number from the user
		int birler = (number % 10)/1; 						// finds the fourth digit of a number
		int onlar = (number % 100 - number % 10)/10; 		// finds the third digit of a number
		int yüzler = (number % 1000 - number % 100)/100; 	// finds the second digit of a number
		int binler = (number % 10000 - number % 1000)/1000; // finds the first digit of a number
		int kalan = (birler + onlar) % (yüzler + binler) ;

		if (kalan == 0)
			System.out.println(number + " is a Bil113 Number.");
		else
			System.out.println(number + " is not a Bil113 Number.");
	}
}