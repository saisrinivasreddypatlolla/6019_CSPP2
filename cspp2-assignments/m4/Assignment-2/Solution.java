import java.util.*;
/**.
 * This program is to print additon of two matrices.
 */
public final class Solution {
    /**.
     * This class is to print additon of two matrices.
     */
    private Solution() {
        /**.
         * private constructor.
         */
    }
    static Scanner scan = new Scanner(System.in);
    /**
     * main function to print additon of two matrices.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int row, column;
        String rowString;
        int[][] matrix1 = matrix();
        int[][] matrix2 = matrix();
        int[][] sum = new int[matrix1.length][matrix1[0].length];
        if ((matrix1.length == matrix2.length)
                && (matrix1[0].length == matrix2[0].length)) {
            for (row = 0; row < matrix1.length; row++) {
                for (column = 0; column < matrix1[0].length; column++) {
                    sum[row][column] = matrix1[row][column]
                                       + matrix2[row][column];
                }
            }
            for (row = 0; row < matrix1.length; row++) {
                rowString = "";
                for (column = 0; column < matrix1[0].length - 1; column++) {
                    rowString += sum[row][column] + " ";
                } System.out.println(rowString + sum[row][column]);
            }
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * this functon return the matrix values to other matrix.
     *
     * @return     matrix
     */
    public static int[][] matrix() {
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = scan.nextInt();
            }
        }
        return matrix;

    }
}