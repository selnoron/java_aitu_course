package Assignment_2;

import java.util.Arrays;

public class task_9 {
    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                result[i][j] = i + j;
            }
        }
        System.out.println(Arrays.deepToString(result)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );
    }
}
