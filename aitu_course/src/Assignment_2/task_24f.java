package Assignment_2;

import java.util.Scanner;

public class task_24f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        signIn(username);
    }
    public static void signIn(String username){
        if (username.equals("user")) {
            return;
        }
        System.out.println("Welcome " + username);
        System.out.println("Missed you very much, " + username);
    }
}
