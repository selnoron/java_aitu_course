package Assignment_3.task2;

public class Duck implements task2.CanEat, task2.CanMove, task2.CanFly {
    @Override
    public void eat() {
        System.out.println("duck eating");
    }

    @Override
    public void move() {
        System.out.println("duck moving");
    }

    @Override
    public void fly() {
        System.out.println("duck flying");
    }
}