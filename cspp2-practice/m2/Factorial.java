import java.util.*;
class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		System.out.println(fact(number));
		System.out.format("Factorial of %d is : %d", number, fact(number));

	}
	static int fact(int number) {
		if ((number == 1) || (number == 0))
			return 1;
		else
			return number * fact(number - 1);
	}
}