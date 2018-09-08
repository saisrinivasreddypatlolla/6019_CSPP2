import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
	private int[] set;
	private int size;
	public Set() {
		final int value = 10;
		set = new int[value];
		size = 0;
	}
	public Set(final int capacity) {
		set = new int[capacity];
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (item == set[i]) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		for (int i = 0; i < size - 1; i++) {
			str += set[i] + ",";
		}
		return str + set[size - 1] + "}";
	}
	public void add(final int item) {
		int flag = 0;
		if (size == set.length) {
			resize();
		}
		if (size >= 0) {
			for (int i = 0; i < size; i++) {
				if (item == set[i]) {
					flag = 1;
				}
			}
			if (flag == 0) {
				set[size++] = item;
			}
		}

	}
	public void add(int[] items) {
		for (int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}
	public Set intersection(Set s) {
		Set s1 = new Set(s.size);
		for (int i = 0; i < size; i++) {
			if (s.contains(set[i])) {
				s1.add(set[i]);
			}
		}
		return s1;
	}
	public Set retainAll(int[] items) {
		Set s1 = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < items.length; j++)
				if (set[i] == items[j]) {
					s1.add(items[j]);
				}
		}
		return s1;
	}
	public int[][] cartesianProduct(Set obj) {
		if (size == 0 || obj.size == 0) {
			return null;
		}
		int k = 0;
		int[] temp;
		int[][] newArray = new int[size * obj.size][2];
		System.out.println(newArray.length);
		while (k < newArray.length) {
			for (int i = 0; i < size; i++) {
				temp = new int[2];
				for (int j = 0; j < obj.size; j++) {
					newArray[k][0] = this.set[i];
					newArray[k][1] = obj.set[j];
					k++;
				}

				// System.out.println(Arrays.toString(temp));
				// temp[0] = this.set[i];
				// temp[1] = obj.set[j];
				// System.out.println(i+" "+Arrays.toString(temp));
			}
			// while (k < newArray.length) {
			// 	System.out.println(k + " " + Arrays.toString(newArray[k]));
			// 	newArray[k++] = temp;
			// }
		}
		return newArray;
	}
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
	 * @param      s     { string input from test case file }
	 *
	 * @return     { int array from the given string }
	 */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
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
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
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
				System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
				break;
			default:
				break;
			}
		}
	}
}
