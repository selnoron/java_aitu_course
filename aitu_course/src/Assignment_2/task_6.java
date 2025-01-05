package Assignment_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task_6 {
    public static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(array[n - 1]);
    }
}
