package Assignment_1;

import java.util.Scanner;

public class task_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (true) {
            String ite = sc.nextLine();
            if (ite.equals("ENTER")) {
                break;
            }
            sum += Integer.parseInt(ite);
        }
        System.out.println(sum);
    }
}
