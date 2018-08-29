import java.util.*;
class SumOfNNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for ( int i = 1; i <= number; i++) {
        	sum += i;
        }
        System.out.format("Sum of %d numbers is : %d",number,sum);
	}
}