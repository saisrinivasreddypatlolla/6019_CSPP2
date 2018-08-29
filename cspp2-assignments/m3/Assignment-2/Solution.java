
import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
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
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            int remainder = 0;
            for (int j = i; j > 0; j = j/10) {
                remainder = j % 10;;
                if (remainder == 7) {
                    count += 1;
                }
            }
        }System.out.println(count);
    }
}