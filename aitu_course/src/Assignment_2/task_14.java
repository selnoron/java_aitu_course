package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class task_14 {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum_row = 0;
        int[][] cols = new int[3][3];
        int[] sums_row = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int a = sc.nextInt();
                array[i][j] = a;
                sum_row += a;
                cols[j][i] = a;
            }
            sums_row[i] = sum_row;
            sum_row = 0;
        }
        int[] sums_col = new int[3];
        for (int i = 0; i < 3; i++) {
            sums_col[i] = IntStream.of(cols[i]).sum();
        }
        Arrays.sort(sums_col);
        Arrays.sort(sums_row);
        int min_col = sums_col[0];
        int min_row = sums_row[0];
        System.out.println("Minimum of rows or columns - " + Math.min(min_col, min_row));
    }
}
