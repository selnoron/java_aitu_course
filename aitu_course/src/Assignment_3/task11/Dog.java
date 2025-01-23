package Assignment_3.task11;

public class Dog implements task11.Eat, task11.Movable {
    @Override
    public void move() {
        System.out.print("Dog can move");

    }
    @Override
    public void eat() {
        System.out.print("Dog can eat");

    }
}
