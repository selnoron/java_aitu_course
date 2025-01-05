package Assignment_1;

import java.util.Scanner;

public class task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter body temperature - ");
        double temperature = sc.nextDouble();

        boolean isHigh = temperature > 37;
        boolean isLow = temperature < 36;

        if (isHigh) {
            System.out.println("Temperature of body is High");
        }
        else if (isLow) {
            System.out.println("Temperature of body is Low");
        }
        else {
            System.out.println("Temperature of body is Normal");
        }
    }
}
