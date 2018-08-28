import java.util.Scanner;
/**.
 * This program is used to print factorial of given input.
 */

public class Solution {
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
    static long power(long base, int exponent) {
        boolean flag = false;
        if (base < 0) {
            flag = true;
            base = Math.abs(base);
        }
        if (exponent >= 1) {
            if (exponent > 1) {
                base *= power(base, exponent - 1);
            }
            base = base * 1;
        }
        else if (exponent == 0) {
            return 1;
        }
        if (flag == true) {
            return -base;
        }
        else {
            return base;
        }
    }
    /*
    Need to write the power function and print the output.
    */
}


