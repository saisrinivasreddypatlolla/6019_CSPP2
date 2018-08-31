
import java.util.Scanner;
/**.
 * This program to print reverse of given string.
 */
public final class Solution {
    /**.
     * This class to print reverse of given string.
     */
    private Solution() {
        /**.
         * private constructor.
         */
    }
    /**.
     * This main function to print reverse of given string.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**.
     * This function reverse the given string and return that string.
     *
     * @param      string  The string
     *
     * @return     returns string type.
     */
    static String reverseString(final String string) {
        String reverseString = "";
        for (int index = 0; index < string.length(); index++) {
            reverseString = string.charAt(index) + reverseString;
        }
        return reverseString;
    }

}
