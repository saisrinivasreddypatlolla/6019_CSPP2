import java.util.Scanner;
/**.
 * Class for input validator.
 */
class InputValidator {
    /**.
     * { var_description }
     */
    private final int length = 6;
    /**.
     * { var_description }
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
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        if (value.length() >= length) {
            return true;
        } else {
            return false;
        }
    }
}
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * { item_description }
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
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
