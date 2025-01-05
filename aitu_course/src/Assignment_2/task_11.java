package Assignment_2;

import java.util.Arrays;

public class task_11 {
    public static int[][][][] multiarray = new int[][][][]{
            {{{4, 8, 15}, {16}},
            {{23, 42}, {}},
            {{1}, {2}, {3}, {4, 5}}}
    };
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiarray)
                .replace("[]", "[()]")
                .replace(",", "")
                .replace("[[[", "")
                .replace("]]]", "")
                .replace("]] ", ",\n")
                .replace("] ", ", ")
                .replace("[", "")
                .replace("]", "")
        );
    }
}
