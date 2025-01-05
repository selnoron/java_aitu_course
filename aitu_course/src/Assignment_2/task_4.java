package Assignment_2;

public class task_4 {
    public static int[] firstArray = new int[] {
            0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9
    };
    public static int[] secondArray = new int[] {
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19
    };
    public static int[] resultArray;
    public static void main(String[] args) {
        int f_n = firstArray.length, s_n = secondArray.length;
        resultArray = new int[f_n + s_n];
        int r_n = resultArray.length;
        System.arraycopy(firstArray, 0, resultArray, 0, f_n);
        System.arraycopy(secondArray, 0, resultArray, f_n, s_n);
        for (int i = 0; i < r_n; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}
