package Assignment_2;

import java.util.Scanner;

public class task_10 {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        multiArray = new int[n][];

        for (int i = 0; i < n; i++) {
            int nn = sc.nextInt();
            multiArray[i] = new int[nn];
        }
        for (int i = 0; i < n; i++) {
            System.out.println("()".repeat(multiArray[i].length));
        }
    }
}
