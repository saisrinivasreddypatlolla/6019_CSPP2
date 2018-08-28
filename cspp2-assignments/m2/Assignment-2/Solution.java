import java.util.Scanner;
import java.math.*;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
        final int value = 4;
        double root = Math.sqrt((b * b) - (value * a * c));
        double numerator1 = -b + root;
        double numerator2 = -b - root;
        double denominator = 2 * a;
        double value1 = numerator1 / denominator;
        double value2 = numerator2 / denominator;
        System.out.println(value1 + " " + value2);

    }
    /*
    Need to write the rootsOfQuadraticEquation function and print the output.
    */
}
