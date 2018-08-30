
import java.util.*;
/**.
 * { item_description }
 */
public final class Solution {
	/**.
	 * Constructs the object.
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
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		int i = 0;
		for (; i < n; i++)
			arr[i] = Integer.parseInt(sc.nextLine());
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				arr[i + 1] = arr[i];
			}
		}
		System.out.println(arr[i]);
	}
}
