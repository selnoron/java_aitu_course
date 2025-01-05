package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;

public class task_15 {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int a = sc.nextInt();
                array[j][i] = a;
            }
        }
        System.out.println(Arrays.deepToString(array)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]", ""));
    }
}
