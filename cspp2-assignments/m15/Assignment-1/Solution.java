import java.util.Scanner;
import java.util.Arrays;
/**.
 * List of .
 */
class List {
    /**.
     * { var_description }
     */
    private int[] list;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Constructs the object.
     */
    List() {
        final int ten = 10;
        list = new int[ten];
        size = 0;
    }
    /**.
     * { function_description }
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * size);
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        list[size++] = item;
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
     * { function_description }
     *
     * @param      index      The index
     *
     * @throws     Exception  { exception_description }
     */
    public void remove(final int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Invalid Position Exception");
        } else {
            int i;
            for (i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            } list[i] = list[size - 1];
            size--;
        }
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int item) {
        for (int index = 0; index < size; index++) {
            if (item == list[index]) {
                return index;
            }
        }
        return -1;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        for (int index = 0; index < size - 1; index++) {
            str += list[index] + ",";
        }
        return str + list[size - 1] + "]";
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
        for (int index = 0; index < size; index++) {
            if (list[index] == item) {
                return index;
            }
        }
        return -1;
    }
    /**.
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        for (int index = 0; index < items.length; index++) {
            add(items[index]);
        }
    }
    /**.
     * { function_description }
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
        if (size == list.length) {
            resize();
        }
        for (int i = size; i >= index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (item == list[index]) {
                count += 1;
            }
        }
        return count;
    }
    /**.
     * Removes all.
     *
     * @param      items      The items
     *
     * @throws     Exception  { exception_description }
     */
    public void removeAll(final int[] items) throws Exception {
        for (int index = 0; index < items.length; index++) {
            while (indexOf(items[index]) != -1) {
                remove(indexOf(items[index]));
            }
        }
    }
    /**.
     * { function_description }
     *
     * @param      start      The start
     * @param      end        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public List subList(final int start, final int end) throws Exception {
        if (start < 0 || end > size || start == end) {
            throw new Exception("Index Out of Bounds Exception");
        }
        List l = new List();
        for (int index = start; index < end; index++) {
            l.add(list[index]);
        }
        return l;
    }
    /**.
     * { function_description }
     *
     * @param      listObject    The l 1
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List listObject) {
        return listObject.toString().equals(toString());
    }
    /**.
     * { function_description }
     */
    public void clear() {
        size = 0;
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
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        List obj = new List();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "add":
                if ((tokens.length) == 2) {
                    String[] tempArray = tokens[1].split(",");
                    if (tempArray.length == 1) {
                        obj.add(Integer.parseInt(tokens[1]));
                    } else {
                        if (tempArray.length > 1) {
                            obj.add(Integer.parseInt(tempArray[0]),
                                    Integer.parseInt(tempArray[1]));
                        }
                    }
                }
                break;
            case "size":
                System.out.println(obj.size());
                break;
            case "remove":
                try {
                    obj.remove(Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "get":
                System.out.println(obj.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(obj.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(obj.toString());
                break;
            case "indexOf":
                System.out.println(obj.indexOf(Integer.parseInt(tokens[1])));
                break;
            case "addAll":
                String[] tempArray0 = tokens[1].split(",");
                int[] temp = new int[tempArray0.length];
                for (int i = 0; i < tempArray0.length; i++) {
                    temp[i] = Integer.parseInt(tempArray0[i]);
                }
                obj.addAll(temp);
                break;
            case "count":
                System.out.println(obj.count(Integer.parseInt(tokens[1])));
                break;
            case "removeAll":
                if (tokens.length == 1) {
                    break;
                }
                try {
                    String[] tempArray1 = tokens[1].split(",");
                    int[] temp2 = new int[tempArray1.length];
                    for (int i = 0; i < tempArray1.length; i++) {
                        temp2[i] = Integer.parseInt(tempArray1[i]);
                    }
                    obj.removeAll(temp2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "subList":
                try {
                    String[] tempArray2 = tokens[1].split(",");
                    List obj1 = obj.subList(Integer.parseInt(tempArray2[0]),
                                            Integer.parseInt(tempArray2[1]));
                    System.out.println(obj1.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "equals":
                if (tokens.length == 1) {
                    break;
                }
                String[] tempArray3 = tokens[1].split(",");
                List obj2 = new List();
                for (int i = 0; i < tempArray3.length; i++) {
                    obj2.add(Integer.parseInt(tempArray3[i]));
                }
                System.out.println(obj.equals(obj2));
                break;
            case "clear":
                obj.clear();
                break;
            default:
                break;
            }
        }

    }

}
