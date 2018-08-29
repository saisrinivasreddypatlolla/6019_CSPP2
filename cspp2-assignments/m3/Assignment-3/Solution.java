
import java.util.Scanner;
/**.
 * Program for gcd values
 */
public final class Solution {
    private static int gcd = 1;
    /**.
     * class for printing gcd values
     */
    private Solution() {
        /**.
         * private constructor.
         */
    }
    /**.
     * main function calls gcd function and prints gcd value.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * checks the condition and returns greatest common
     * factor of given two numbers.
     *
     * @param      n1  The number 1
     * @param      n2  The number 2
     *
     * @return     integer
     */
    static int gcd(final int n1, final int n2) {
        int temp = 0;
        int number1 = n1;
        int number2 = n2;
        if (number1 > number2) {
            temp = number1;
            number1 = number2;
            number2 = temp;
        }
        for (int i = 1; i <= number2; i++) {
            if ((number1 % i == 0) && (number2 % i == 0)) {
                gcd = i;
            }
        }
        return gcd;
    }
    /*
	Need to write the gcd function and print the output.
	*/
}
