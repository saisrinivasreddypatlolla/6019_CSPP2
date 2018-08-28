import java.util.*;
class BiggerEqualSmaller{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int varA = scan.nextInt();
		int varB = scan.nextInt();
		if(varA > varB){
			System.out.println("Bigger");
		}
		else if(varA == varB){
			System.out.println("Equal");
		}
		else{
			System.out.println("Smaller");
		}
	}
}