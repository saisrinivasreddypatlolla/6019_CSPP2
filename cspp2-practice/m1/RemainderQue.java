import java.util.*;
class RemainderQue{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int qoutient = a/b;
		int remainder = a%b;
		System.out.println("qoutient is :"+qoutient);
		System.out.println("remainder is :"+remainder);
	}
}