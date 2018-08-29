
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * { item_description }
     */
    private Solution() {
        /**.
         * private Constructor.
         */
    }
    /**.
     * main function to display number of 7's in between 1 to given number
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        final int value = 10;
        final int number = 7;
        for (int i = 1; i <= n; i++) {
            int remainder = 0;
            for (int j = i; j > 0; j = j / value) {
                remainder = j % value;
                if (remainder == number) {
                    count += 1;
                }
            }
        } System.out.println(count);
    }
}