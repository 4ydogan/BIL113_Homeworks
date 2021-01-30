import java.util.Scanner;

public class FractionalNumberDemo {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the first fractional number in string representation");
        FractionalNumber fractionalNumber1 = new FractionalNumber(keyboard.nextLine());
        System.out.println("Please enter the second fractional number in string representation");
        FractionalNumber fractionalNumber2 = new FractionalNumber(keyboard.nextLine());
        System.out.println("Please enter the third fractional number in numerator and denominator form");
        FractionalNumber fractionalNumber3 = new FractionalNumber(keyboard.nextInt(), keyboard.nextInt());

        System.out.println("First fractional number is " + fractionalNumber1.toString() + " and its double value is " + fractionalNumber1.getDoubleValue());
        System.out.println("Second fractional number is " + fractionalNumber2.toString() + " and its double value is " + fractionalNumber2.getDoubleValue());
        System.out.println("Third fractional number is " + fractionalNumber3.toString() + " and its double value is " + fractionalNumber3.getDoubleValue());
        System.out.println();

        System.out.println("First fractional number is " + fractionalNumber1.toString() + " and its simplified version is " + FractionalNumber.simplify(fractionalNumber1));
        System.out.println("Second fractional number is " + fractionalNumber2.toString() + " and simplified version is " + FractionalNumber.simplify(fractionalNumber2));
        System.out.println("Third fractional number is " + fractionalNumber3.toString() + " and simplified version is " + FractionalNumber.simplify(fractionalNumber3));

        System.out.println();

        if (fractionalNumber1.equals(fractionalNumber2))
            System.out.println("First and second fractional numbers are equal");
        else
            System.out.println("First and second fractional numbers are not equal");

        if (fractionalNumber1.equals(fractionalNumber3))
            System.out.println("First and third fractional numbers are equal");
        else
            System.out.println("First and third fractional numbers are not equal");

        if (fractionalNumber2.equals(fractionalNumber3))
            System.out.println("Second and third fractional numbers are equal");
        else
            System.out.println("Second and third fractional numbers are not equal");



        System.out.println();
        System.out.println(fractionalNumber1.toString() + " + " + fractionalNumber2.toString() + " = " + FractionalNumber.add(fractionalNumber1,fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " + " + fractionalNumber3.toString() + " = " + FractionalNumber.add(fractionalNumber1,fractionalNumber3));
        System.out.println(fractionalNumber2.toString() + " + " + fractionalNumber3.toString() + " = " + FractionalNumber.add(fractionalNumber2,fractionalNumber3));
        System.out.println();

        System.out.println(fractionalNumber1.toString() + " - " + fractionalNumber2.toString() + " = " + FractionalNumber.subtract(fractionalNumber1,fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " - " + fractionalNumber3.toString() + " = " + FractionalNumber.subtract(fractionalNumber1,fractionalNumber3));
        System.out.println(fractionalNumber2.toString() + " - " + fractionalNumber3.toString() + " = " + FractionalNumber.subtract(fractionalNumber2,fractionalNumber3));
        System.out.println();

        System.out.println(fractionalNumber1.toString() + " * " + fractionalNumber2.toString() + " = " + FractionalNumber.multiply(fractionalNumber1,fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " * " + fractionalNumber3.toString() + " = " + FractionalNumber.multiply(fractionalNumber1,fractionalNumber3));
        System.out.println(fractionalNumber3.toString() + " * " + fractionalNumber2.toString() + " = " + FractionalNumber.multiply(fractionalNumber3,fractionalNumber2));

        System.out.println();

        System.out.println(fractionalNumber1.toString() + " / " + fractionalNumber2.toString() + " = " + FractionalNumber.divide(fractionalNumber1,fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " / " + fractionalNumber3.toString() + " = " + FractionalNumber.divide(fractionalNumber1,fractionalNumber3));
        System.out.println(fractionalNumber3.toString() + " / " + fractionalNumber2.toString() + " = " + FractionalNumber.divide(fractionalNumber3,fractionalNumber2));


    }
}