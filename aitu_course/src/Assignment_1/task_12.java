package Assignment_1;

public class task_12 {
    public static void main(String[] args) {
        int i = 0;
        int count = 1;
        int sum = 0;
        while (i < 100) {
            if (count % 3 != 0) {
                sum += count;
            }
            count++;
            i++;
        }
        System.out.println(sum);
    }
}
