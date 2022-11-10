/*
 * ChoicesAndLoops
 * reading and using inputs with choices and loops
 * Author: Nagl Patrick
 * Last Change:  02.11.2022
 */
import java.util.Locale;
import java.util.Scanner;

public class ChoicesAndLoops {
    public static void main(String[] args) {
        java.util.Locale.setDefault(new java.util.Locale("en", "US"));
        Scanner scanner = new Scanner(System.in);

        double amount = 0; //used double, so that when using it for mean, it would output a double
        while(true) {
            System.out.print("Amount: "); //input one
            if (scanner.hasNextInt()) {   // check int
                amount = scanner.nextInt();  //save amount;
                // ask if scanner is emty and clean it AND ask if amount < 0 only after there is an amount initialised,then stop loop
                if (scanner.nextLine().isEmpty() && amount > 0 )
                    break;
            } else {
                scanner.nextLine(); // do !NOT! use .nextLine!!! it confuses [enter] with having to jump in next line and using output???
            }
        }

        int sum = 0;//have to initialize before for-loop so it doesn't reset
        int minimum = 2147483647; // used highest int number, so that any number will be smaller than it
        int maximum = -2147483648;

        // for loop which runs until amount reached
        for (int i = 0; i < amount; i++) {
            // while loop(infinite) so i counts only after input conditions are met
            while (true) {
                System.out.printf("#%d:", i + 1);// ask for input 2 (numbered)
                if (scanner.hasNextInt()) { //check int
                    int number = scanner.nextInt(); //save number
                    //ask if scanner is emty and clean it
                    if (scanner.nextLine().isEmpty()) {

                        //generating sum while loop
                        sum = sum + number;

                        //generating min, max while loop
                        if (number < minimum) {
                            minimum = number;
                        }
                        if (number > maximum) {
                            maximum = number;
                        }

                        break;
                    }

                } else {
                    scanner.nextLine();
                }
            }
        }
        scanner.close();

        //Calculations:
        double mean = sum/amount;
        double meanAbs;
        if (mean < 0) {
            meanAbs = -mean;
        } else {
            meanAbs = mean;
        }
        int delta = maximum - minimum;
        long sumMinMax = 0; // to prevent integer overflow
        for (int i=minimum; i<=maximum; i++){
            sumMinMax += i;
        }
//        long sumMinMaxMath = ((maximum * (maximum + 1)) / 2) - (((minimum - 1) * minimum) / 2);

        //Output: looks better line by line :)
        System.out.println("Sum = " + sum);
        System.out.println("Minimum = " + minimum);
        System.out.println("Maximum = " + maximum);
        System.out.printf("Mean = %.2f\n", mean);
        System.out.printf("Reciprocal of mean = %.2f\n", 1/mean);
        System.out.printf("Additive inverse of mean = %.2f\n", -mean);
        System.out.printf("Absolute value of mean = %.2f\n", meanAbs);
        System.out.println("Delta of minimum and maximum = " + delta);
        System.out.println("Sum of numbers from minimum to maximum = " + sumMinMax);
//        System.out.println("Sum with mathematical solution = " + sumMinMaxMath);
    }
}