package Assignment_3.task11;

public class Mouse implements task11.Movable, task11.Edible {
    @Override
    public void move() {
        System.out.println("Mouse can move");
    }
    @Override
    public void beEaten() {
        System.out.println("Mouse can be eaten");
    }
}
