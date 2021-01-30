public class FractionalNumber {
    private int numerator;
    private int denominator;

    public FractionalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public FractionalNumber(String number) {
        this.numerator = Integer.parseInt(number.substring(0, number.indexOf('/')));
        this.denominator = Integer.parseInt(number.substring(number.indexOf('/') + 1));
    }
    
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean equals(FractionalNumber fractionalNumber) {
        return this.numerator * fractionalNumber.denominator == this.denominator * fractionalNumber.numerator;
    }

    public double getDoubleValue() {
        return  (double) numerator / denominator;
    }

    public static FractionalNumber simplify(FractionalNumber fractionalNumber) {
        int gcd = findGreatestCommonDivisor(fractionalNumber.numerator, fractionalNumber.denominator);

        int newNumerator = fractionalNumber.numerator / gcd;
        int newDenominator = fractionalNumber.denominator / gcd;

        if (newNumerator > 0 && newDenominator < 0) {
            newNumerator = -1 * newNumerator;
            newDenominator = -1 * newDenominator;

        }
        return new FractionalNumber(newNumerator, newDenominator);
    }

    public static int findGreatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }


    public static FractionalNumber add(FractionalNumber fractionalNumber1, FractionalNumber fractionalNumber2) {
        int newNumerator = fractionalNumber1.numerator * fractionalNumber2.denominator + fractionalNumber2.numerator * fractionalNumber1.denominator;
        int newDenominator = fractionalNumber1.denominator * fractionalNumber2.denominator;

        return  FractionalNumber.simplify(new FractionalNumber(newNumerator, newDenominator));
    }

    public static FractionalNumber subtract(FractionalNumber fractionalNumber1, FractionalNumber fractionalNumber2) {
        int newNumerator = fractionalNumber1.numerator * fractionalNumber2.denominator - fractionalNumber2.numerator * fractionalNumber1.denominator;
        int newDenominator = fractionalNumber1.denominator * fractionalNumber2.denominator;

        int gcd = findGreatestCommonDivisor(newNumerator, newDenominator);

        return   FractionalNumber.simplify(new FractionalNumber(newNumerator / gcd, newDenominator/gcd));
    }

    public static FractionalNumber multiply(FractionalNumber fractionalNumber1, FractionalNumber fractionalNumber2) {
        int newNumerator = fractionalNumber1.numerator * fractionalNumber2.numerator;
        int newDenominator = fractionalNumber1.denominator * fractionalNumber2.denominator;

        int gcd = findGreatestCommonDivisor(newNumerator, newDenominator);

        return  FractionalNumber.simplify(new FractionalNumber(newNumerator / gcd, newDenominator/gcd));
    }

    public static FractionalNumber divide(FractionalNumber fractionalNumber1, FractionalNumber fractionalNumber2) {
        if (fractionalNumber2.getNumerator() == 0)
            return null;
        int newNumerator = fractionalNumber1.numerator * fractionalNumber2.denominator;
        int newDenominator = fractionalNumber1.denominator * fractionalNumber2.numerator;

        int gcd = findGreatestCommonDivisor(newNumerator, newDenominator);

        return   FractionalNumber.simplify(new FractionalNumber(newNumerator / gcd, newDenominator/gcd));
    }

    @Override
    public String toString() {
        return ""+ numerator + "/" + denominator;
    }
}
