import java.util.*;
class Pattern {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= number; i++){
			for (int j = 1; j <= i; j++){
				System.out.print(j);
			}
		System.out.println();
		}
	}
}