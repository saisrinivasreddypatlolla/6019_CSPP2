import java.util.*;
class Average{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(scan.nextLine());
        }
        for (int i = 0; i < n; i++)
            sum += arr[i];
        int average = sum/n;
        System.out.println(average);
    }
}