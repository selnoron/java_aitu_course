package Assignment_2;

import java.util.Arrays;

public class task_17 {
    public static char[][] chars = {
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'j', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(chars)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );

        for (int i = 1; i < chars.length - 1; i++) {
            for (int j = 1; j < chars[i].length - 1; j++) {
                chars[i][j] = '-';
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(chars)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );
    }
}
