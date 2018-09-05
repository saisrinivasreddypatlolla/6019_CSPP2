import java.util.Scanner;
/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**.
 * Class for fibonacci.
 */
public class Fibonacci {
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    /**.
     * Function to add fibonacci numbers to list
     *
     * @param      number  The number
     *
     * @return     returns the list of List type.
     */
    public static List fib(final int number) {
        // todo - complete this method
        List list = new List();
        int value1 = 0, value2 = 1, tempValue;
        list.add(value1);
        list.add(value2);
        for (int i = 2; i < number; i++) {
            tempValue = value1 + value2;
            value1 = value2;
            value2 = tempValue;
            list.add(value2);
        }
        return list;
    }
    /**.
     * Class for fibonacci.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(fib(number));
    }
}