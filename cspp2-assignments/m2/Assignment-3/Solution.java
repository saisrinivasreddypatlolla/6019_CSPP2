import java.util.Scanner;
/**.
 * This program is used to print factorial of given input.
 */

public final class Solution {
    /**
     * this class is for printing factorial og given input.
     */
    private Solution() {
        /**.
         * this the constructor of class
         */
    }
    /**.
     * main function
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**.
     * In this method we return factorial number.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     integer
     */
    static long power(final long base,final int exponent) {
        long number = base;
        int exp = exponent;
        boolean flag = false;
        if (number < 0) {
            flag = true;
            number = Math.abs(number);
        }
        if (exp >= 1) {
            if (exp > 1) {
                number *= power(number, exp - 1);
            }
            number = number * 1;
        }
        else if (exp == 0) {
            return 1;
        }
        if (flag == true) {
            return -number;
        }
        else {
            return number;
        }
    }
    /*
    Need to write the power function and print the output.
    */
}


