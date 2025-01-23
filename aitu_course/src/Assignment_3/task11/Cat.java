package Assignment_3.task11;

public class Cat implements task11.Movable, task11.Eat, task11.Edible{
    @Override
    public void move() {
        System.out.print("Cat can move");
    }
    @Override
    public void beEaten() {
        System.out.print("Cat can be eaten");
    }
    @Override
    public void eat() {
        System.out.print("Cat can eat");
    }
}
