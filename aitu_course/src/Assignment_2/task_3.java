package Assignment_2;

import java.util.Arrays;

public class task_3 {
    public static int[] array = new int[]{-1, 2, 3, -4, -5};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] *= -1;
            }
        }
        System.out.println(Arrays.toString(array));

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }
}
