package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;

public class task_7 {
    public static String[] strings = new String[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < 6; i++) {
            if (strings[i] == null) continue;
            for (int j = i + 1; j < 6; j++) {
                if (strings[i] != null && strings[j].equals(strings[i])) {
                    strings[i] = null;
                    strings[j] = null;
                }
            }
        }
        System.out.println(Arrays.toString(strings));
    }
}
