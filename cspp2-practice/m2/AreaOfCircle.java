import java.util.*;
class AreaOfCircle{
	static double area(int radius){
		double area = pi()*radius*radius;
		return area;
	}
	static double pi(){
		return 3.14f;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();
		System.out.println(area(radius));
	}
}