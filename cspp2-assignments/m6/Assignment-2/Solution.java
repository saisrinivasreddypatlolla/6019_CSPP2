import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      array     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] array,
                                final int rows,
                                final int columns) {
        final int multiple = 100;
        int value = 0;
        final int number = 50;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (array[row][column] % multiple >= number) {
                    value = array[row][column] / multiple;
                    if (array[row][column] / multiple >= 0) {
                        value += 1;
                    }
                    array[row][column] = value * multiple;
                } else {
                    value = array[row][column] / multiple;
                    array[row][column] = value * multiple;
                }
            }
        }
        return array;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
