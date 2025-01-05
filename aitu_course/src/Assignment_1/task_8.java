package Assignment_1;

import java.util.Scanner;

public class task_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age - ");
        int age = sc.nextInt();

        if (age < 20 || age > 60) {
            System.out.println("You don't have to work6");
        }
    }
}
