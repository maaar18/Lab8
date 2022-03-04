import java.util.Scanner;


public class Main {

    public static int intInput() throws NumberFormatException, NullPointerException {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (true){
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            }
            else{
                System.out.println("Error type! Please enter an integer value");
                scanner.next();
            }
        }
        return input;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FractionCalculator expression = new FractionCalculator(scanner.nextLine());
        System.out.println(expression.getAnswer());

    }
}

