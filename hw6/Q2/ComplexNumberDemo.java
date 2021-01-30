import java.util.Scanner;

public class ComplexNumberDemo {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the first complex number in string representation");
        ComplexNumber complexNumber1 = new ComplexNumber(keyboard.nextLine());
        System.out.println("Please enter the second complex number in string representation");
        ComplexNumber complexNumber2 = new ComplexNumber(keyboard.nextLine());
        System.out.println("Please enter the Third complex number in string representation");
        ComplexNumber complexNumber3 = new ComplexNumber(keyboard.nextLine());


        System.out.println("First complex number is " + complexNumber1.toString() + " and its simplified version is " + ComplexNumber.simplify(complexNumber1));
        System.out.println("Second complex number is " + complexNumber2.toString() + " and simplified version is " + ComplexNumber.simplify(complexNumber2));
        System.out.println("Third complex number is " + complexNumber3.toString() + " and simplified version is " + ComplexNumber.simplify(complexNumber3));

        System.out.println();

        if (complexNumber1.equals(complexNumber2))
            System.out.println("First and second complex numbers are equal");
        else
            System.out.println("First and second complex numbers are not equal");

        if (complexNumber1.equals(complexNumber3))
            System.out.println("First and third complex numbers are equal");
        else
            System.out.println("First and third complex numbers are not equal");

        if (complexNumber2.equals(complexNumber3))
            System.out.println("Second and third complex numbers are equal");
        else
            System.out.println("Second and third complex numbers are not equal");



        System.out.println();
        System.out.println(complexNumber1.toString() + " + " + complexNumber2.toString() +" = " + ComplexNumber.add(complexNumber1,complexNumber2));
        System.out.println(complexNumber1.toString() + " + " + complexNumber3.toString() +" = " + ComplexNumber.add(complexNumber1,complexNumber3));
        System.out.println(complexNumber2.toString() + " + " + complexNumber3.toString() +" = " + ComplexNumber.add(complexNumber2,complexNumber3));
        System.out.println();

        System.out.println(complexNumber1.toString() + " - " + complexNumber2.toString() +" = " + ComplexNumber.subtract(complexNumber1,complexNumber2));
        System.out.println(complexNumber1.toString() + " - " + complexNumber3.toString() +" = " + ComplexNumber.subtract(complexNumber1,complexNumber3));
        System.out.println(complexNumber2.toString() + " - " + complexNumber3.toString() +" = " + ComplexNumber.subtract(complexNumber2,complexNumber3));
        System.out.println();

        System.out.println(complexNumber1.toString() + " * " + complexNumber2.toString() +" = " + ComplexNumber.multiply(complexNumber1,complexNumber2));
        System.out.println(complexNumber1.toString() + " * " + complexNumber3.toString() +" = " + ComplexNumber.multiply(complexNumber1,complexNumber3));
        System.out.println(complexNumber3.toString() + " * " + complexNumber2.toString() +" = " + ComplexNumber.multiply(complexNumber3,complexNumber2));

        System.out.println();

        System.out.println(complexNumber1.toString() + " / " + complexNumber2.toString() +" = " + ComplexNumber.divide(complexNumber1,complexNumber2));
        System.out.println(complexNumber1.toString() + " / " + complexNumber3.toString() +" = " + ComplexNumber.divide(complexNumber1,complexNumber3));
        System.out.println(complexNumber3.toString() + " / " + complexNumber2.toString() +" = " + ComplexNumber.divide(complexNumber3,complexNumber2));


    }
}