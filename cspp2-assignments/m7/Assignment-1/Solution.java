import java.util.Scanner;
/**.
 * Class for input validator.
 */
class InputValidator {
    /**.
     * This class is used to return boolean
     * value to student class
     */
    private final int length = 6;
    /**.
     * ths variable is to get the input value.
     */
    private static String value;
    /**.
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        this.value = input;
    }
    /**.
     * this method checks the length and returns
     * boolean values.
     *
     * @return     return boolean value
     */
    public boolean validateData() {
        if (value.length() >= length) {
            return true;
        }
        return false;

    }
}
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * This class to print the boolean value return
     * from details class.
     */
    private Solution() {
        /**.
         * private constructor
         */
    }
    /**.
     * main method is to print boolean values.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
