package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Please enter a positive number");
            return;
        }
        int[] arr = new int[n];
        if (n % 2 == 0) {
            for (int i = n - 1; i >= 0; i--) {
                arr[n - i - 1] = i + 1;
            }
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
