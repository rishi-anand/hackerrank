package thirty.days.of.code.two;

import java.util.*;
import java.math.*;

public class Arithmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.

        double numberToRoundHere = mealCost +
                (mealCost * ((double) tipPercent / 100)) +
                (mealCost * ((double) taxPercent / 100));

        /*
        If integer tipPercent taxPercent is not casted to double then integer division
        result will end to 0 and when assigned to double it will become 0.0.
         */

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(numberToRoundHere);

        // Print your result
        System.out.println("The total meal cost is " + totalCost + " dollars.");
    }
}