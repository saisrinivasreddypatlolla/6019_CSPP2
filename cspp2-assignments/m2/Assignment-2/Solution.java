import java.util.Scanner;
import java.math.*;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	static void rootsOfQuadraticEquation(int a, int b, int c) {
		double root = Math.sqrt((b * b) - (4 * a * c));
		double numerator1 = -b + root;
		double numerator2 = -b - root;
		double denominator = 2 * a;
		double value1 = numerator1 / denominator;
		double value2 = numerator2 / denominator;
		System.out.println(value1 + " " + value2);

	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
}
