import java.util.*;
class ConverttoWhileLoop{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int i = 2;
        while (i <= number) {
            System.out.println(i);
            i += 2;
        }System.out.println("GoodBye!");
    }
}