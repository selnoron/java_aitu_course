package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;

public class task_16 {
    public static char[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        array = new char[height][];
        for (int i = 1; i <= height; i++) {
            String line = " ".repeat(height - i) + "# ".repeat(i);
            char[] row = line.toCharArray();
            array[i - 1] = row;
        }
        System.out.println(Arrays.deepToString(array)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );
    }
}
