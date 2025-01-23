package Assignment_2;

public class task_19f {
    public static void main(String[] args) {
        System.out.println("I am a poet, my name is Tsvetik.");
        System.out.println("Hello from me to you all.");
    }

    public static int[] give_massive(int[] array) {
        int[] reversedArray = new int[array.length];

        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[j] = array[i];
            j++;
        }
        return reversedArray;
    }
}
