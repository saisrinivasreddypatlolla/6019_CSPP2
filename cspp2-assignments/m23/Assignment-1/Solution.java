import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     *
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            final int HUNDRED = 100;
            Scanner scan = new Scanner(System.in);
            String dir = scan.nextLine();
            File folder = new File(dir);
            File[] files = folder.listFiles();
            if (files.length == 0) {
                System.out.println("empty directory");
                return;
            }
            for (File i : files) {
                System.out.print("\t" + i );
            }
            System.out.println();
            for (File files1 : files) {
                for (File files2 : files) {
                    Distance map1 = new Distance(files1);
                    double sum1 = map1.ecludian();
                    HashMap<String, Integer> value1 = map1.name;
                    List<Integer> values = new ArrayList<Integer>(map1.name.values());
                    List<String> keys = new ArrayList<String>(map1.name.keySet());
                    Distance map2 = new Distance(files2);
                    double sum2 = map2.ecludian();
                    HashMap<String, Integer> value2 = map2.name;
                    List<Integer> values3 = new ArrayList<Integer>(map2.name.values());
                    double sum = 0;
                    for (String i : value1.keySet()) {
                        if (value2.containsKey(i)) {
                            sum += value1.get(i) * value2.get(i);
                        }
                    }
                    double per = (sum / (Math.sqrt(sum1) * Math.sqrt(sum2))) * HUNDRED;
                    System.out.println(Math.round(per));
                }
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
}