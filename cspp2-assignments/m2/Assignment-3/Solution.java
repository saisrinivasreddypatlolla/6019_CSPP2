import java.util.Scanner;
import java.math.*;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    static long power(final long base, final int exponent) {
        boolean flag = false;
        long result = 1;
        if (base < 0) {
            flag = true;
            result = Math.abs(base);
        }
        if (exponent >= 1) {
            if (exponent > 1) {
                result *= power(result, exponent - 1);
            }
            result = result * 1;
        }
        else if (exponent == 0) {
            return 1;
        }
        if (flag == true) {
            return -result;
        }
        else {
            return result;
        }
    }
    /*
    Need to write the power function and print the output.
    */
}
