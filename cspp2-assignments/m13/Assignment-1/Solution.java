import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : srinivas reddy
 */
class Set {
    /**.
     * variable for set.
     */
    private int[] set;
    /**.
     * variable for size of set
     */
    private int size;
    /**.
     * Constructs the object.
     */
    Set() {
        final int value = 10;
        set = new int[value];
        size = 0;
    }
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    Set(final int capacity) {
        set = new int[capacity];
        size = 0;
    }
    /**.
     * this function returns the size of set
     *
     * @return     returns size
     */
    public int size() {
        return size;
    }
    /**.
     * this function checks the item is in the set
     * or not and returns boolean value
     *
     * @param      item  The item
     *
     * @return     returns boolean value
     */
    public boolean contains(final int item) {
        for (int index = 0; index < size; index++) {
            if (item == set[index]) {
                return true;
            }
        }
        return false;
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
        for (int index = 0; index < size - 1; index++) {
            str += set[index] + ", ";
        }
        return str + set[size - 1] + "}";
    }
    /**.
     * add the value into the set.
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
                set[size++] = item;
            }
        }

    }
    /**.
     * this function add set of values to the set[].
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        for (int index = 0; index < items.length; index++) {
            add(items[index]);
        }
    }
    /**.
     * this function add similar values and
     * return the set class object
     *
     * @param      setObject the object
     *
     * @return     returns object
     */
    public Set intersection(final Set setObject) {
        Set s1 = new Set(setObject.size);
        for (int index = 0; index < size; index++) {
            if (setObject.contains(set[index])) {
                s1.add(set[index]);
            }
        }
        return s1;
    }
    /**.
     * this function retains the similar values in
     * both sets.
     *
     * @param      items  The items
     *
     * @return     returns set object
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
     * this function returns the product of 2D array
     *
     * @param      obj   The object
     *
     * @return     returns the 2D array
     */
    public int[][] cartesianProduct(final Set obj) {
        if (size == 0 || obj.size == 0) {
            return null;
        }
        int k = 0;
        int[] temp;
        int[][] newArray = new int[size * obj.size][2];
        while (k < newArray.length) {
            for (int index = 0; index < size; index++) {
                temp = new int[2];
                for (int j = 0; j < obj.size; j++) {
                    newArray[k][0] = this.set[index];
                    newArray[k][1] = obj.set[j];
                    k++;
                }
            }
        }
        return newArray;
    }
    /**.
     * this function resize the array.
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      str     { string input from test case file }
     *
     * @return     { int array from the given string }
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
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new
                                    BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(
                                       Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(
                                       s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
