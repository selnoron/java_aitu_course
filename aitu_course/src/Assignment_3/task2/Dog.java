package Assignment_3.task2;


public class Dog implements task2.CanEat, task2.CanMove {
    @Override
    public void move() {
        System.out.print("dog moving");
    }

    @Override
    public void eat() {
        System.out.print("dog eating");
    }
}
