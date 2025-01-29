package Assignment_3.interfaces.task17;


import java.awt.Color;


public class task17 {
    public interface Animal {
        Color getColor();
    }

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }
}
