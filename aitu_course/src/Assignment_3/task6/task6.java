package Assignment_3.task6;

import java.util.Scanner;


public class task6 {
    public static void main(String[] args) {
        Screen scr = new Screen();
        Scanner scn = new Scanner(System.in) ;
        while(true) {
            System.out.println("1. Select Screen");
            System.out.println("2. Refresh screen");
            System.out.print("Select: ");

            int vybor = scn.nextInt();
            if(vybor == 1) {
                scr.select();
                break;
            } else if(vybor == 2) {
                scr.refresh();
            } else {
                System.out.println("Invalid selection");
            }

        }

    }
}
