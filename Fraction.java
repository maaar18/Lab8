public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() { //Default constructor 1/1
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator){ //Custom Fraction constructor param1/param2
        this.numerator = numerator;
        try {
            if (denominator == 0)
                throw new ZeroDenominatorException();
        } catch (ZeroDenominatorException e) {
            e.printStackTrace();
            System.out.println("Please restart and enter a different Denominator.");
            System.exit(1);
        }
        this.denominator = denominator;
    }

    public Fraction(Fraction fraction) { // Assignment constructor
        this.numerator = fraction.getNumerator();
        this.denominator = fraction.getDenominator();
    }

    public Fraction (String fraction){
        String[] fractionString = fraction.split("/");

        try{
            if (fractionString.length != 2){ //Checking if the fraction is inputted correctly. (e.g. not 1//2)
                throw new InvalidFractionException();
            }
            numerator = Integer.parseInt(fractionString[0]); //Trying to get integer value from a string
            denominator = Integer.parseInt(fractionString[1]);
            if (denominator == 0) //Checking for zero denominator
                throw new ZeroDenominatorException();
        }
        catch (ZeroDenominatorException zeroDenominatorException){ //Zero denominator case
            zeroDenominatorException.printStackTrace();
            System.out.println("Error invalid fraction. Please restart and try again.");
            System.exit(1);
        }
        catch (InvalidFractionException invalidFractionException){ //Incorrect expression case
            invalidFractionException.printStackTrace();
            System.out.println("Error invalid fraction. Please restart and try again.");
            System.exit(1);
        }
        catch (NumberFormatException numberFormatException){ //Not integer value case
            numberFormatException.printStackTrace();
            System.out.println("Error invalid fraction. Please restart and try again.");
            System.exit(1);
        }

    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public static Fraction sum(Fraction f1, Fraction f2) throws NullPointerException{ //Sum two fractions
        int num;
        int denom;

        if (f1.getDenominator() != f2.getDenominator()) {
            denom = f1.getDenominator() * f2.getDenominator();
            num = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
        } else {
            denom = f1.getDenominator();
            num = f1.getNumerator() + f2.getNumerator();
        }
        Fraction f3 = new Fraction(num, denom);
        return f3;
    }

    public void sum(Fraction f2) throws NullPointerException{ // Sum this Fraction and new
        if (denominator != f2.getDenominator()) {
            numerator = numerator * f2.getDenominator() + f2.getNumerator() * denominator;
            denominator = denominator * f2.getDenominator();
        } else {
            numerator = numerator + f2.getNumerator();
        }
    }

    public static Fraction subtract(Fraction f1, Fraction f2) { // Similarly for Subtraction, Multiplication and Division
        int num;
        int denom;

        if (f1.getDenominator() != f2.getDenominator()) {
            denom = f1.getDenominator() * f2.getDenominator();
            num = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
        } else {
            denom = f1.getDenominator();
            num = f1.getNumerator() - f2.getNumerator();
        }
        Fraction f3 = new Fraction(num, denom);
        return f3;
    }

    public void subtract(Fraction f2) {
        if (denominator != f2.getDenominator()) {
            numerator = numerator * f2.getDenominator() - f2.getNumerator() * denominator;
            denominator = denominator * f2.getDenominator();
        } else {
            numerator = numerator - f2.getNumerator();
        }
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getNumerator() * f2.getNumerator(), f1.getDenominator() * f2.getDenominator());
        return f3;
    }

    public void multiply(Fraction f2) {
        int num = numerator * f2.getNumerator();
        int denom = denominator * f2.getDenominator();
        numerator = num;
        denominator = denom;
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getNumerator() * f2.getDenominator(), f1.getDenominator() * f2.getNumerator());
        return f3;
    }

    public void divide(Fraction f2) {
        int num = numerator * f2.getDenominator();
        int denom = denominator * f2.getNumerator();
        numerator = num;
        denominator = denom;
    }

    public String toString() { //Fraction print
        return (numerator + "/" + denominator);
    }
}

