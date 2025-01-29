package Assignment_3.oop_part2.task8;

public class Solution {
    public static void main(String[] args) {
        String s1 = new String("JavaITU");
        s1 = "JavaENU";
        String s2 = "JavaENU";
        String s3 = "JavaENU";
        System.out.println(s1 == s3);
        System.out.println(s2.equals(s3));
    }
}
