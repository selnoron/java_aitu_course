package Assignment_3.task11;


public class task11 {
    public interface Movable {
        void move();
    }
    public interface Edible {
        void beEaten();
    }
    public interface Eat {
        void eat();
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.beEaten();
        mouse.move();
    }
}
