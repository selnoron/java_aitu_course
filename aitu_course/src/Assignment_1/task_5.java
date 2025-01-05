package Assignment_1;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner tem = new Scanner(System.in);
        System.out.println("Enter the tempreture outside - ");
        double temp = tem.nextDouble();
        if (temp >= 0) {
            System.out.println("It's warm outside");
        }
        else {
            System.out.println("It's cold outside");
        }
    }
}
