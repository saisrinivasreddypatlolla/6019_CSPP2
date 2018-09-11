import java.util.Scanner;
import java.util.Arrays;
/**.
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**.
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**.
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**.
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    SetEmptyException(final String s) {
        super(s);
    }
}
/**.
 * Class for set.
 */
class Set {
    /**.
     * { var_description }
     */
    private int[] set;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Constructs the object.
     */
    Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (size >= 0) {
            for (int index = 0; index < size; index++) {
                if (item == set[index]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                int i, j = 0, count = 0;
                if (size > 0) {
                    for (i = 0; i < size; i++) {
                        if (item > set[i]) {
                            count += 1;
                        }
                    }
                    for (j = size; j > count; j--) {
                        set[j] = set[j - 1];
                    }
                }
                set[count] = item;
                size++;
            }
        }

    }
    /**.
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < size - 1; i++) {
            str += set[i] + ", ";
        }
        return str + set[size - 1] + "}";
    }
    /**.
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set s) {
        Set s1 = new Set();
        for (int i = 0; i < size; i++) {
            if (s.contains(set[i])) {
                s1.add(set[i]);
            }
        }
        return s1;
    }
    /**.
     * { function_description }
     *
     * @param      items  The items
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] items) {
        Set s1 = new Set();
        for (int index = 0; index < size; index++) {
            for (int j = 0; j < items.length; j++) {
                if (set[index] == items[j]) {
                    s1.add(items[j]);
                }
            }
        }
        return s1;
    }
    /**.
     * { function_description }
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }
    /**.
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last()throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return set[size - 1];
    }
    /**.
     * { function_description }
     *
     * @param      start                            The start
     * @param      end                              The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] subSet(final int start, final int end)throws
        InvalidSubsetSelectionException {
        if (start > end) {
            throw new
            InvalidSubsetSelectionException(
                "Invalid Arguments to Subset Exception");
        }
        if (size == 0) {
            int[] subSet = new int[0];
            return subSet;
        }
        int a = start(start);
        int b = end(end);
        int[] subSet = new int[b - a];
        int i, j;
        for (i = a, j = 0; i < b; i++, j++) {
            subSet[j] = set[i];
        }
        return subSet;
    }
    /**
     * { function_description }.
     *
     * @param      start1  The start 1
     *
     * @return     { description_of_the_return_value }
     */
    public int start(final int start1) {
        for (int i = 0; i < size; i++) {
            if (start1 <= set[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * { function_description }.
     *
     * @param      end1  The end 1
     *
     * @return     { description_of_the_return_value }
     */
    public int end(final int end1) {
        for (int i = size - 1; i >= 0; i--) {
            if (end1 >= set[i]) {
                if (end1 > set[i]) {
                    return i + 1;
                }
                return i;
            }
        }
        return -1;
    }
    /**.
     * { function_description }
     *
     * @param      end                The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int[] headSet(final int end)throws SetEmptyException {
        if (end(end) < 1) {
            throw new SetEmptyException("Set Empty Exception");
        }
        int a = end(end);
        if (a == -1) {
            int[] temp = new int[0];
            return temp;
        }
        int[] temp = new int[a];
        for (int i = 0; i < a; i++) {
            temp[i] = set[i];
        }
        return temp;
    }

}
/**.
 * { item_description }
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static int[] intArray(final String str) {
        String input = str;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (str.contains("[")) {
            input = str.substring(1, str.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Set obj = new Set();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "add":
                obj.add(Integer.parseInt(tokens[1]));
                break;
            case "addAll":
                String[] tempArray = tokens[1].split(",");
                int[] temp = new int[tempArray.length];
                for (int i = 0; i < tempArray.length; i++) {
                    temp[i] = Integer.parseInt(
                                  tempArray[i]);
                }
                obj.addAll(temp);
                break;
            case "size":
                System.out.println(obj.size());
                break;
            case "print":
                System.out.println(obj.toString());
                break;
            case "intersection":
                obj = new Set();
                Set t = new Set();
                int[] intArray = intArray(tokens[1]);
                obj.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(obj.intersection(t));
                break;
            case "retainAll":
                obj = new Set();
                intArray = intArray(tokens[1]);
                obj.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(obj.retainAll(
                                       intArray));
                break;
            case "subSet":
                try {
                    String[] tempA = tokens[1].split(",");
                    int[] tempB = obj.subSet(Integer.
                                             parseInt(tempA[0]),
                                             Integer.
                                             parseInt(tempA[1]));
                    String str = "{";
                    int i;
                    if (tempB.length == 0) {
                        System.out.println("{}");
                        break;
                    }
                    for (i = 0; i < tempB.length - 1; i++) {
                        str += tempB[i] + ", ";
                    }
                    str += tempB[tempB.length - 1] + "}";
                    System.out.println(str);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
            case "headSet":
                try {
                    int[] tempC = obj.headSet(Integer.
                                              parseInt(tokens[1]));
                    String str1 = "{";
                    int in;
                    if (tempC.length == 0) {
                        System.out.println("{}");
                        break;
                    }
                    for (in = 0; in < tempC.length - 1; in++) {
                        str1 += tempC[in] + ", ";
                    }
                    str1 += tempC[tempC.length - 1] + "}";
                    System.out.println(str1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(obj.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                break;

            }
        }
    }
}
