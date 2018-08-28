import java.util.Scanner;
import java.math.*;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base,exponent);
        System.out.println(result);
    }
    static long power(int base, int exponent){
        boolean flag = false;
        long number = 0;
        if(base < 0){
            flag = true;
            base = Math.abs(base);
        }
        if(exponent >= 1){
            if(exponent > 1)
                base *= power(base,exponent-1);
                System.out.println(base+" "+exponent);
            base = base*1;
        }
        else if(exponent == 0) return 1;
        if(flag == true)
            return -base;
        else
            return base;
    }
    /*
    Need to write the power function and print the output.
    */
}
