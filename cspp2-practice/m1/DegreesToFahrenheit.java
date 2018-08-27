import java.util.*;
class DegreesToFahrenheit{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degrees = scan.nextDouble();
		double fahrenhiet = (degrees*1.8)+32;
		System.out.println("for "+degrees+" fahrenhiet is "+fahrenhiet);
	}
}