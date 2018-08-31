
import java.util.*;
/**.
 * This program is to convert binary to decimal.
 */
public final class Solution {
    /**
     * class is to print decimal value.
     */
    private Solution() {
        /**.
         * private constructor.
         */
    }
    /**.
     * main function takes binary input and prints decimal.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        // int lines = sc.nextInt();
        int lines = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lines; i++) {
            String string = sc.nextLine();
            long res = binaryToDecimal(string);
            System.out.println(res);
        }
    }
    /**.
     * { function_description }
     *
     * @param      string     string with binary data
     *
     * @return     returns the long decimal value.
     */
    static long binaryToDecimal(final String string) {
        long sum = 0;
        String reverseString = "";
        for (int index = 0; index < string.length(); index++) {
            reverseString = string.charAt(index) + reverseString;
        }
        for (int index = 0; index < reverseString.length(); index++) {
            int character = Integer.parseInt(reverseString.charAt(index) + "");
            sum += (character * ((int)Math.pow(2,
                                               reverseString.indexOf
                                               (Integer.toString(character),
                                                index))));
        }
        return sum;
    }

}
