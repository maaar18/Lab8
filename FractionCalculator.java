public class FractionCalculator {

    private Fraction fraction1;
    private Fraction fraction2;
    private String sign;

    public FractionCalculator(String expression) {

        String[] splitExpression = expression.split(" "); //Splitting into string[]
        if (splitExpression.length != 3 ){ //Check if expression has more than 2 operands or more than 1 operator(sign)
            System.out.println("Incorrect number of operands. Please restart and try again");
            System.exit(1);
        }
        fraction1 = new Fraction(splitExpression[0]); //Creating fractions from string expression
        fraction2 = new Fraction(splitExpression[2]);
        if (!(splitExpression[1].equals("+") | splitExpression[1].equals("-") | //Check if the sign is correct (+, -, *, /)
                splitExpression[1].equals("*") | splitExpression[1].equals("/") )) {
            System.out.println("Error! Incorrect sign. Please use +, -, *, /. Please restart and try again");
            System.exit(1);
        }
        else{
            sign = splitExpression[1];
        }
    }


    public Fraction getAnswer(){ //Do operation according to sign
        Fraction answer = new Fraction();
        switch(sign){

            case "+":
                answer = Fraction.sum(fraction1, fraction2);
                break;
            case "-":
                answer = Fraction.subtract(fraction1, fraction2);
                break;
            case "*":
                answer = Fraction.multiply(fraction1, fraction2);
                break;
            case "/":
                answer = Fraction.divide(fraction1, fraction2);
                break;
        }
        return answer;
    }

}
