package Assignment_1;

import java.util.Scanner;

public class task_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        int end = sc.nextInt();
        int mul = sc.nextInt();
        int sum = 0;
        for(int i = str; i < end; i++) {
            if (i % mul == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
