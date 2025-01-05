package Assignment_2;

import java.util.Arrays;


public class task_22f {
    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }
    public static void reverseArray(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
