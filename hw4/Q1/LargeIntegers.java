import java.util.Scanner;

public class LargeInteger
{

	public static int fromStringtoIntForDigit(String str) // to convert srting to integer for digits
	{
		if (str.equals("0"))
			return 0;
		if (str.equals("1"))
			return 1;
		if (str.equals("2"))
			return 2;
		if (str.equals("3"))
			return 3;
		if (str.equals("4"))
			return 4;
		if (str.equals("5"))
			return 5;
		if (str.equals("6"))
			return 6;
		if (str.equals("7"))
			return 7;
		if (str.equals("8"))
			return 8;
		if (str.equals("9"))
			return 9;
		return 0;
	}

	public static void main(String [] args)
	{
		String sayi_1, sayi_2, last1, last2, result="", reverse="";
		int islem, sonuc, elde=0, length_sayi_1, length_sayi_2;
		int a=1, b=0, lastDigit1=0, lastDigit2=0, x=0;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter two numbers. First number:");
		sayi_1 = "0" + keyboard.next();
		System.out.print("Second number:");
		sayi_2 = "0" + keyboard.next();
		System.out.print("Please enter 1 for addition or 2 for subtraction:");
		islem = keyboard.nextInt();
		length_sayi_1 = sayi_1.length();
		length_sayi_2 = sayi_2.length();

		while(length_sayi_1 != length_sayi_2) // to add zero to the beginning of a number
		{
			sayi_2 = "0" + sayi_2;
			length_sayi_2 = sayi_2.length();
		}

		while(a <= length_sayi_1)
		{
			
			last1 = sayi_1.substring(length_sayi_1-a, length_sayi_1-b);
			last2 = sayi_2.substring(length_sayi_2-a, length_sayi_2-b);
			a++;
			b++;

			lastDigit1 = fromStringtoIntForDigit(last1);
			lastDigit2 = fromStringtoIntForDigit(last2);

			length_sayi_1 = sayi_1.length();
			length_sayi_2 = sayi_2.length();

			if (islem == 1) // to determine the operation
			{
				sonuc = lastDigit1 + lastDigit2 + elde;
				if (sonuc>9) // to determine the excess
				{
					sonuc -=10;
					elde = 1;					
				}
				else
					elde = 0;
				result = result + sonuc;
			}
			if (islem == 2) 
			{
				sonuc = lastDigit1 - elde - lastDigit2;
				if (sonuc<0) 
				{
					sonuc += 10;
					elde = 1;					
				}
				else
					elde = 0;
				result = result + sonuc;				
			}
		}

		x = result.length() - 1;
		while (x >= 0) // to reverse result string 
		{
			reverse = reverse + result.charAt(x);
			x--;
		}

		while ((reverse.substring(0,1)).equals("0")) //to remove unnecessary zeros
		{
			reverse = reverse.substring(1);
		}

		System.out.println("Result:" + reverse);
	}
}