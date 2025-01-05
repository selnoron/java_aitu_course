package Assignment_1;

import java.util.Scanner;

public class task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        if (age >= 18 && age < 28) {
            System.out.println(String.format("%s, come to the military registration and enlistment office", name));
        }
        else {
            System.out.println("Just relax and chill");
        }
    }
}
